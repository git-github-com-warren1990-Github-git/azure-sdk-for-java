// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.catalog.generated;

import com.azure.analytics.purview.catalog.CollectionClient;
import com.azure.analytics.purview.catalog.PurviewCatalogClientBuilder;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class CollectionCreateOrUpdate {
    public static void main(String[] args) {
        CollectionClient client =
                new PurviewCatalogClientBuilder()
                        .credential(new DefaultAzureCredentialBuilder().build())
                        .endpoint("{Endpoint}")
                        .buildCollectionClient();
        BinaryData entity =
                BinaryData.fromString(
                        "{\"entity\":{\"attributes\":{\"name\":\"exampleaccount\",\"qualifiedName\":\"https://exampleaccount.core.windows.net\"},\"typeName\":\"azure_storage_account\"},\"referredEntities\":{}}");
        RequestOptions requestOptions = new RequestOptions();
        Response<BinaryData> response = client.createOrUpdateWithResponse("ExampleCollection", entity, requestOptions);
    }
}
