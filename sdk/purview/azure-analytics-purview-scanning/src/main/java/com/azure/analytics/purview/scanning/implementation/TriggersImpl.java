// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.scanning.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in Triggers. */
public final class TriggersImpl {
    /** The proxy service used to perform REST calls. */
    private final TriggersService service;

    /** The service client containing this operation class. */
    private final PurviewScanningClientImpl client;

    /**
     * Initializes an instance of TriggersImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    TriggersImpl(PurviewScanningClientImpl client) {
        this.service = RestProxy.create(TriggersService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for PurviewScanningClientTriggers to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{Endpoint}")
    @ServiceInterface(name = "PurviewScanningClien")
    private interface TriggersService {
        @Get("/datasources/{dataSourceName}/scans/{scanName}/triggers/default")
        @ExpectedResponses({200})
        Mono<Response<BinaryData>> getTrigger(
                @HostParam("Endpoint") String endpoint,
                @PathParam("dataSourceName") String dataSourceName,
                @PathParam("scanName") String scanName,
                @QueryParam("api-version") String apiVersion,
                RequestOptions requestOptions,
                Context context);

        @Put("/datasources/{dataSourceName}/scans/{scanName}/triggers/default")
        @ExpectedResponses({200, 201})
        Mono<Response<BinaryData>> createTrigger(
                @HostParam("Endpoint") String endpoint,
                @PathParam("dataSourceName") String dataSourceName,
                @PathParam("scanName") String scanName,
                @QueryParam("api-version") String apiVersion,
                @BodyParam("application/json") BinaryData body,
                RequestOptions requestOptions,
                Context context);

        @Delete("/datasources/{dataSourceName}/scans/{scanName}/triggers/default")
        @ExpectedResponses({200, 204})
        Mono<Response<BinaryData>> deleteTrigger(
                @HostParam("Endpoint") String endpoint,
                @PathParam("dataSourceName") String dataSourceName,
                @PathParam("scanName") String scanName,
                @QueryParam("api-version") String apiVersion,
                RequestOptions requestOptions,
                Context context);
    }

    /**
     * Gets trigger information.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return trigger information along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> getTriggerWithResponseAsync(
            String dataSourceName, String scanName, RequestOptions requestOptions) {
        return FluxUtil.withContext(
                context ->
                        service.getTrigger(
                                this.client.getEndpoint(),
                                dataSourceName,
                                scanName,
                                this.client.getServiceVersion().getVersion(),
                                requestOptions,
                                context));
    }

    /**
     * Gets trigger information.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @param context The context to associate with this operation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return trigger information along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> getTriggerWithResponseAsync(
            String dataSourceName, String scanName, RequestOptions requestOptions, Context context) {
        return service.getTrigger(
                this.client.getEndpoint(),
                dataSourceName,
                scanName,
                this.client.getServiceVersion().getVersion(),
                requestOptions,
                context);
    }

    /**
     * Gets trigger information.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return trigger information along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getTriggerWithResponse(
            String dataSourceName, String scanName, RequestOptions requestOptions) {
        return getTriggerWithResponseAsync(dataSourceName, scanName, requestOptions).block();
    }

    /**
     * Creates an instance of a trigger.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> createTriggerWithResponseAsync(
            String dataSourceName, String scanName, BinaryData body, RequestOptions requestOptions) {
        return FluxUtil.withContext(
                context ->
                        service.createTrigger(
                                this.client.getEndpoint(),
                                dataSourceName,
                                scanName,
                                this.client.getServiceVersion().getVersion(),
                                body,
                                requestOptions,
                                context));
    }

    /**
     * Creates an instance of a trigger.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @param context The context to associate with this operation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> createTriggerWithResponseAsync(
            String dataSourceName, String scanName, BinaryData body, RequestOptions requestOptions, Context context) {
        return service.createTrigger(
                this.client.getEndpoint(),
                dataSourceName,
                scanName,
                this.client.getServiceVersion().getVersion(),
                body,
                requestOptions,
                context);
    }

    /**
     * Creates an instance of a trigger.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Request Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param body The body parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> createTriggerWithResponse(
            String dataSourceName, String scanName, BinaryData body, RequestOptions requestOptions) {
        return createTriggerWithResponseAsync(dataSourceName, scanName, body, requestOptions).block();
    }

    /**
     * Deletes the trigger associated with the scan.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> deleteTriggerWithResponseAsync(
            String dataSourceName, String scanName, RequestOptions requestOptions) {
        return FluxUtil.withContext(
                context ->
                        service.deleteTrigger(
                                this.client.getEndpoint(),
                                dataSourceName,
                                scanName,
                                this.client.getServiceVersion().getVersion(),
                                requestOptions,
                                context));
    }

    /**
     * Deletes the trigger associated with the scan.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @param context The context to associate with this operation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> deleteTriggerWithResponseAsync(
            String dataSourceName, String scanName, RequestOptions requestOptions, Context context) {
        return service.deleteTrigger(
                this.client.getEndpoint(),
                dataSourceName,
                scanName,
                this.client.getServiceVersion().getVersion(),
                requestOptions,
                context);
    }

    /**
     * Deletes the trigger associated with the scan.
     *
     * <p><strong>Query Parameters</strong>
     *
     * <table border="1">
     *     <caption>Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     *     <tr><td>apiVersion</td><td>String</td><td>Yes</td><td>Api Version</td></tr>
     * </table>
     *
     * <p><strong>Response Body Schema</strong>
     *
     * <pre>{@code
     * {
     *     id: String
     *     name: String
     *     properties: {
     *         recurrence: {
     *             frequency: String(Week/Month)
     *             interval: Integer
     *             startTime: String
     *             endTime: String
     *             schedule: {
     *                 additionalProperties: {
     *                     String: Object
     *                 }
     *                 minutes: [
     *                     int
     *                 ]
     *                 hours: [
     *                     int
     *                 ]
     *                 weekDays: [
     *                     String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                 ]
     *                 monthDays: [
     *                     int
     *                 ]
     *                 monthlyOccurrences: [
     *                     {
     *                         additionalProperties: {
     *                             String: Object
     *                         }
     *                         day: String(Sunday/Monday/Tuesday/Wednesday/Thursday/Friday/Saturday)
     *                         occurrence: Integer
     *                     }
     *                 ]
     *             }
     *             timeZone: String
     *         }
     *         recurrenceInterval: String
     *         createdAt: String
     *         lastModifiedAt: String
     *         lastScheduled: String
     *         scanLevel: String(Full/Incremental)
     *         incrementalScanStartTime: String
     *     }
     * }
     * }</pre>
     *
     * @param dataSourceName The dataSourceName parameter.
     * @param scanName The scanName parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> deleteTriggerWithResponse(
            String dataSourceName, String scanName, RequestOptions requestOptions) {
        return deleteTriggerWithResponseAsync(dataSourceName, scanName, requestOptions).block();
    }
}
