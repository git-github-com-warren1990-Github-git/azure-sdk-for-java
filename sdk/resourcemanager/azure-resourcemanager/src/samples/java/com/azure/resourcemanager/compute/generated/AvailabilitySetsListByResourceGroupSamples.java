// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.generated;

import com.azure.core.util.Context;

/** Samples for AvailabilitySets ListByResourceGroup. */
public final class AvailabilitySetsListByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/compute/resource-manager/Microsoft.Compute/stable/2021-11-01/examples/compute/AvailabilitySets_List_MinimumSet_Gen.json
     */
    /**
     * Sample code: AvailabilitySets_List_MinimumSet_Gen.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void availabilitySetsListMinimumSetGen(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .virtualMachines()
            .manager()
            .serviceClient()
            .getAvailabilitySets()
            .listByResourceGroup("rgcompute", Context.NONE);
    }

    /*
     * x-ms-original-file: specification/compute/resource-manager/Microsoft.Compute/stable/2021-11-01/examples/compute/AvailabilitySets_List_MaximumSet_Gen.json
     */
    /**
     * Sample code: AvailabilitySets_List_MaximumSet_Gen.
     *
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void availabilitySetsListMaximumSetGen(com.azure.resourcemanager.AzureResourceManager azure) {
        azure
            .virtualMachines()
            .manager()
            .serviceClient()
            .getAvailabilitySets()
            .listByResourceGroup("rgcompute", Context.NONE);
    }
}
