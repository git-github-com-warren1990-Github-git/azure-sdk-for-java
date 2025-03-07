# Azure Monitor Query client library for Java

The Azure Monitor Query client library is used to execute read-only queries against [Azure Monitor][azure_monitor_overview]'s two data platforms:

- [Logs](https://docs.microsoft.com/azure/azure-monitor/logs/data-platform-logs) - Collects and organizes log and performance data from monitored resources. Data from different sources such as platform logs from Azure services, log and performance data from virtual machines agents, and usage and performance data from apps can be consolidated into a single [Azure Log Analytics workspace](https://docs.microsoft.com/azure/azure-monitor/logs/data-platform-logs#log-analytics-and-workspaces). The various data types can be analyzed together using the [Kusto Query Language][kusto_query_language].
- [Metrics](https://docs.microsoft.com/azure/azure-monitor/essentials/data-platform-metrics) - Collects numeric data from monitored resources into a time series database. Metrics are numerical values that are collected at regular intervals and describe some aspect of a system at a particular time. Metrics are lightweight and capable of supporting near real-time scenarios, making them particularly useful for alerting and fast detection of issues.

**Resources:**

- [Source code][source]
- [Package (Maven)][package]
- [API reference documentation][msdocs_apiref]
- [Service documentation][azure_monitor_overview]
- [Samples][samples]
- [Change log][changelog]

## Getting started

### Prerequisites

- A [Java Development Kit (JDK)][jdk_link], version 8 or later
- An [Azure subscription][azure_subscription]
- To query Logs, you need an [Azure Log Analytics workspace][azure_monitor_create_using_portal].
- To query Metrics, you need an Azure resource of any kind (Storage Account, Key Vault, Cosmos DB, etc.).

### Install the package

Install the Azure Monitor Query client library for Java by adding the following to your *pom.xml* file:

[//]: # ({x-version-update-start;com.azure:azure-monitor-query;current})

```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-monitor-query</artifactId>
    <version>1.0.2</version>
</dependency>
```

[//]: # ({x-version-update-end})

### Create the client

An authenticated client is required to query Logs or Metrics. The library includes both synchronous and asynchronous forms of the clients. To authenticate, the following examples use `DefaultAzureCredentialBuilder` from the [com.azure:azure-identity](https://search.maven.org/artifact/com.azure/azure-identity) package.

### Authenticating using Azure Active Directory

You can authenticate with Azure Active Directory using the [Azure Identity library][azure_identity]. Note that regional endpoints do not support AAD authentication. Create a [custom subdomain][custom_subdomain] for your resource in order to use this type of authentication.

To use the [DefaultAzureCredential][DefaultAzureCredential] provider shown below, or other credential providers provided with the Azure SDK, please include the `azure-identity` package:

[//]: # ({x-version-update-start;com.azure:azure-identity;dependency})
```xml
<dependency>
    <groupId>com.azure</groupId>
    <artifactId>azure-identity</artifactId>
    <version>1.4.3</version>
</dependency>
```
Set the values of the client ID, tenant ID, and client secret of the AAD application as environment variables: AZURE_CLIENT_ID, AZURE_TENANT_ID, AZURE_CLIENT_SECRET.

#### Synchronous clients

```java readme-sample-createLogsQueryClient
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();
```

```java readme-sample-createMetricsQueryClient
MetricsQueryClient metricsQueryClient = new MetricsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();
```

#### Asynchronous clients

```java readme-sample-createLogsQueryAsyncClient
LogsQueryAsyncClient logsQueryAsyncClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildAsyncClient();
```

```java readme-sample-createMetricsQueryAsyncClient
MetricsQueryAsyncClient metricsQueryAsyncClient = new MetricsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildAsyncClient();
```

### Execute the query

For examples of Logs and Metrics queries, see the [Examples](#examples) section.

## Key concepts

### Logs query rate limits and throttling

The Log Analytics service applies throttling when the request rate is too high. Limits, such as the maximum number of rows returned, are also applied on the Kusto queries. For more information, see [Query API](https://docs.microsoft.com/azure/azure-monitor/service-limits#la-query-api).

### Metrics data structure

Each set of metric values is a time series with the following characteristics:

- The time the value was collected
- The resource associated with the value
- A namespace that acts like a category for the metric
- A metric name
- The value itself
- Some metrics may have multiple dimensions as described in multi-dimensional metrics. Custom metrics can have up to 10 dimensions.

## Examples

- [Logs query](#logs-query)
  - [Map logs query results to a model](#map-logs-query-results-to-a-model)
  - [Handle logs query response](#handle-logs-query-response)
- [Batch logs query](#batch-logs-query)
- [Advanced logs query scenarios](#advanced-logs-query-scenarios)
  - [Set logs query timeout](#set-logs-query-timeout)
  - [Query multiple workspaces](#query-multiple-workspaces)
- [Metrics query](#metrics-query)
  - [Handle metrics query response](#handle-metrics-query-response)
  - [Get average and count metrics](#get-average-and-count-metrics)

### Logs query

```java readme-sample-logsquery
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .buildClient();

LogsQueryResult queryResults = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
        new QueryTimeInterval(Duration.ofDays(2)));

for (LogsTableRow row : queryResults.getTable().getRows()) {
    System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
}
```

#### Map logs query results to a model

```java readme-sample-custommodel
public class CustomLogModel {
    private String resourceGroup;
    private String operationName;

    public String getResourceGroup() {
        return resourceGroup;
    }

    public String getOperationName() {
        return operationName;
    }
}
```

```java readme-sample-logsquerycustommodel
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .buildClient();

List<CustomLogModel> customLogModels = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
        new QueryTimeInterval(Duration.ofDays(2)), CustomLogModel.class);

for (CustomLogModel customLogModel : customLogModels) {
    System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
}
```

#### Handle logs query response

The `query` API returns the `LogsQueryResult`, while the `queryBatch` API returns the `LogsBatchQueryResult`. Here's a hierarchy of the response:

```
LogsQueryResult / LogsBatchQueryResult
|---id (this exists in `LogsBatchQueryResult` object only)
|---status (this exists in `LogsBatchQueryResult` object only)
|---statistics
|---visualization
|---error
|---tables (list of `LogsTable` objects)
    |---name
    |---rows (list of `LogsTableRow` objects)
        |--- rowIndex
        |--- rowCells (list of `LogsTableCell` objects)
    |---columns (list of `LogsTableColumn` objects)
        |---name
        |---type
```

### Batch logs query

```java readme-sample-batchlogsquery
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .buildClient();

LogsBatchQuery logsBatchQuery = new LogsBatchQuery();
String query1 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-1}", new QueryTimeInterval(Duration.ofDays(2)));
String query2 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-2}", new QueryTimeInterval(Duration.ofDays(30)));
String query3 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-3}", new QueryTimeInterval(Duration.ofDays(10)));

LogsBatchQueryResultCollection batchResults = logsQueryClient
        .queryBatchWithResponse(logsBatchQuery, Context.NONE).getValue();

LogsBatchQueryResult query1Result = batchResults.getResult(query1);
for (LogsTableRow row : query1Result.getTable().getRows()) {
    System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
}

List<CustomLogModel> customLogModels = batchResults.getResult(query2, CustomLogModel.class);
for (CustomLogModel customLogModel : customLogModels) {
    System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
}

LogsBatchQueryResult query3Result = batchResults.getResult(query3);
if (query3Result.getQueryResultStatus() == LogsQueryResultStatus.FAILURE) {
    System.out.println(query3Result.getError().getMessage());
}
```

### Advanced logs query scenarios

#### Set logs query timeout

```java readme-sample-logsquerytimeout
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

// set request options: server timeout
LogsQueryOptions options = new LogsQueryOptions()
    .setServerTimeout(Duration.ofMinutes(10));

Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}",
        "{kusto-query}", new QueryTimeInterval(Duration.ofDays(2)), options, Context.NONE);
```

#### Query multiple workspaces

To run the same query against multiple Log Analytics workspaces, use the `LogsQueryOptions.setAdditionalWorkspaces` method:

When multiple workspaces are included in the query, the logs in the result table are not grouped according to the 
workspace from which it was retrieved. To identify the workspace of a row in the result table, you can inspect the 
"TenantId" column in the result table. If this column is not in the table, then you may have to update your query string
to include this column.

```java readme-sample-logsquerymultipleworkspaces
LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .buildClient();

Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}", "{kusto-query}",
        new QueryTimeInterval(Duration.ofDays(2)), new LogsQueryOptions()
                .setAdditionalWorkspaces(Arrays.asList("{additional-workspace-identifiers}")),
        Context.NONE);
LogsQueryResult result = response.getValue();
```

### Metrics query

A resource ID, as denoted by the `{resource-id}` placeholder in the sample below, is required to query metrics. To find the resource ID:

1. Navigate to your resource's page in the Azure portal.
2. From the **Overview** blade, select the **JSON View** link.
3. In the resulting JSON, copy the value of the `id` property.

```java readme-sample-metricsquery
MetricsQueryClient metricsQueryClient = new MetricsQueryClientBuilder()
        .credential(new DefaultAzureCredentialBuilder().build())
        .buildClient();

MetricsQueryResult metricsQueryResult = metricsQueryClient.queryResource("{resource-uri}",
        Arrays.asList("SuccessfulCalls", "TotalCalls"));

for (MetricResult metric : metricsQueryResult.getMetrics()) {
    System.out.println("Metric name " + metric.getMetricName());
    for (TimeSeriesElement timeSeriesElement : metric.getTimeSeries()) {
        System.out.println("Dimensions " + timeSeriesElement.getMetadata());
        for (MetricValue metricValue : timeSeriesElement.getValues()) {
            System.out.println(metricValue.getTimeStamp() + " " + metricValue.getTotal());
        }
    }
}
```

#### Handle metrics query response

The metrics query API returns a `MetricsQueryResult` object. The `MetricsQueryResult` object contains properties such as a list of `MetricResult`-typed objects, `granularity`, `namespace`, and `timeInterval`. The `MetricResult` objects list can be accessed using the `metrics` param. Each `MetricResult` object in this list contains a list of `TimeSeriesElement` objects. Each `TimeSeriesElement` contains `data` and `metadata_values` properties. In visual form, the object hierarchy of the response resembles the following structure:

```
MetricsQueryResult
|---granularity
|---timeInterval
|---cost
|---namespace
|---resourceRegion
|---metrics (list of `MetricResult` objects)
    |---id
    |---type
    |---name
    |---unit
    |---timeSeries (list of `TimeSeriesElement` objects)
        |---metadata (dimensions)
        |---metricValues (list of data points represented by `MetricValue` objects)
             |--- timeStamp
             |--- count
             |--- average
             |--- total
             |--- maximum
             |--- minimum
```

#### Get average and count metrics

```java readme-sample-metricsqueryaggregation
MetricsQueryClient metricsQueryClient = new MetricsQueryClientBuilder()
    .credential(new DefaultAzureCredentialBuilder().build())
    .buildClient();

Response<MetricsQueryResult> metricsResponse = metricsQueryClient
    .queryResourceWithResponse("{resource-id}", Arrays.asList("SuccessfulCalls", "TotalCalls"),
        new MetricsQueryOptions()
            .setGranularity(Duration.ofHours(1))
            .setAggregations(Arrays.asList(AggregationType.AVERAGE, AggregationType.COUNT)),
        Context.NONE);

MetricsQueryResult metricsQueryResult = metricsResponse.getValue();

for (MetricResult metric : metricsQueryResult.getMetrics()) {
    System.out.println("Metric name " + metric.getMetricName());
    for (TimeSeriesElement timeSeriesElement : metric.getTimeSeries()) {
        System.out.println("Dimensions " + timeSeriesElement.getMetadata());
        for (MetricValue metricValue : timeSeriesElement.getValues()) {
            System.out.println(metricValue.getTimeStamp() + " " + metricValue.getTotal());
        }
    }
}
```

## Troubleshooting

See our [troubleshooting guide](https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query/TROUBLESHOOTING.md)
for details on how to diagnose various failure scenarios.

## Next steps

To learn more about Azure Monitor, see the [Azure Monitor service documentation][azure_monitor_overview].

## Contributing

This project welcomes contributions and suggestions. Most contributions require you to agree to a [Contributor License Agreement (CLA)][cla] declaring that you have the right to, and actually do, grant us the rights to use your contribution.

When you submit a pull request, a CLA-bot will automatically determine whether you need to provide a CLA and decorate
the PR appropriately (e.g., label, comment). Simply follow the instructions provided by the bot. You will only need to
do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct][coc]. For more information, see
the [Code of Conduct FAQ][coc_faq] or contact [opencode@microsoft.com][coc_contact] with any additional questions or
comments.

<!-- LINKS -->

[azure_monitor_create_using_portal]: https://docs.microsoft.com/azure/azure-monitor/logs/quick-create-workspace
[azure_monitor_overview]: https://docs.microsoft.com/azure/azure-monitor/overview
[azure_subscription]: https://azure.microsoft.com/free/java
[changelog]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query/CHANGELOG.md
[jdk_link]: https://docs.microsoft.com/java/azure/jdk/?view=azure-java-stable
[kusto_query_language]: https://docs.microsoft.com/azure/data-explorer/kusto/query/
[log_levels]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/core/azure-core/src/main/java/com/azure/core/util/logging/ClientLogger.java
[msdocs_apiref]: https://docs.microsoft.com/java/api/com.azure.monitor.query?view=azure-java-stable
[package]: https://search.maven.org/artifact/com.azure/azure-monitor-query
[samples]: https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/monitor/azure-monitor-query/src/samples/java/README.md
[source]: https://github.com/Azure/azure-sdk-for-java/tree/main/sdk/monitor/azure-monitor-query/src
[performance_tuning]: https://github.com/Azure/azure-sdk-for-java/wiki/Performance-Tuning

[cla]: https://cla.microsoft.com
[coc]: https://opensource.microsoft.com/codeofconduct/
[coc_faq]: https://opensource.microsoft.com/codeofconduct/faq/
[coc_contact]: mailto:opencode@microsoft.com

![Impressions](https://azure-sdk-impressions.azurewebsites.net/api/impressions/azure-sdk-for-java%2Fsdk%2Fmonitor%2Fazure-monitor-query%2FREADME.png)
