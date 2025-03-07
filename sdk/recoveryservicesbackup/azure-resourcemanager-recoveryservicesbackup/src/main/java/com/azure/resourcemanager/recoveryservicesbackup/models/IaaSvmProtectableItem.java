// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** IaaS VM workload-specific backup item. */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "protectableItemType",
    defaultImpl = IaaSvmProtectableItem.class)
@JsonTypeName("IaaSVMProtectableItem")
@JsonSubTypes({
    @JsonSubTypes.Type(
        name = "Microsoft.ClassicCompute/virtualMachines",
        value = AzureIaaSClassicComputeVMProtectableItem.class),
    @JsonSubTypes.Type(name = "Microsoft.Compute/virtualMachines", value = AzureIaaSComputeVMProtectableItem.class)
})
@Fluent
public class IaaSvmProtectableItem extends WorkloadProtectableItem {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(IaaSvmProtectableItem.class);

    /*
     * Fully qualified ARM ID of the virtual machine.
     */
    @JsonProperty(value = "virtualMachineId")
    private String virtualMachineId;

    /*
     * Specifies whether the container represents a Classic or an Azure
     * Resource Manager VM.
     */
    @JsonProperty(value = "virtualMachineVersion")
    private String virtualMachineVersion;

    /*
     * Resource group name of Recovery Services Vault.
     */
    @JsonProperty(value = "resourceGroup")
    private String resourceGroup;

    /**
     * Get the virtualMachineId property: Fully qualified ARM ID of the virtual machine.
     *
     * @return the virtualMachineId value.
     */
    public String virtualMachineId() {
        return this.virtualMachineId;
    }

    /**
     * Set the virtualMachineId property: Fully qualified ARM ID of the virtual machine.
     *
     * @param virtualMachineId the virtualMachineId value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withVirtualMachineId(String virtualMachineId) {
        this.virtualMachineId = virtualMachineId;
        return this;
    }

    /**
     * Get the virtualMachineVersion property: Specifies whether the container represents a Classic or an Azure Resource
     * Manager VM.
     *
     * @return the virtualMachineVersion value.
     */
    public String virtualMachineVersion() {
        return this.virtualMachineVersion;
    }

    /**
     * Set the virtualMachineVersion property: Specifies whether the container represents a Classic or an Azure Resource
     * Manager VM.
     *
     * @param virtualMachineVersion the virtualMachineVersion value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withVirtualMachineVersion(String virtualMachineVersion) {
        this.virtualMachineVersion = virtualMachineVersion;
        return this;
    }

    /**
     * Get the resourceGroup property: Resource group name of Recovery Services Vault.
     *
     * @return the resourceGroup value.
     */
    public String resourceGroup() {
        return this.resourceGroup;
    }

    /**
     * Set the resourceGroup property: Resource group name of Recovery Services Vault.
     *
     * @param resourceGroup the resourceGroup value to set.
     * @return the IaaSvmProtectableItem object itself.
     */
    public IaaSvmProtectableItem withResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public IaaSvmProtectableItem withBackupManagementType(String backupManagementType) {
        super.withBackupManagementType(backupManagementType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public IaaSvmProtectableItem withWorkloadType(String workloadType) {
        super.withWorkloadType(workloadType);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public IaaSvmProtectableItem withFriendlyName(String friendlyName) {
        super.withFriendlyName(friendlyName);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public IaaSvmProtectableItem withProtectionState(ProtectionStatus protectionState) {
        super.withProtectionState(protectionState);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
    }
}
