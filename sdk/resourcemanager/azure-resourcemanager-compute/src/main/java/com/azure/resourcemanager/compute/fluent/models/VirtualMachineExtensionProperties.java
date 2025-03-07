// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.compute.models.VirtualMachineExtensionInstanceView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes the properties of a Virtual Machine Extension. */
@Fluent
public final class VirtualMachineExtensionProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(VirtualMachineExtensionProperties.class);

    /*
     * How the extension handler should be forced to update even if the
     * extension configuration has not changed.
     */
    @JsonProperty(value = "forceUpdateTag")
    private String forceUpdateTag;

    /*
     * The name of the extension handler publisher.
     */
    @JsonProperty(value = "publisher")
    private String publisher;

    /*
     * Specifies the type of the extension; an example is
     * "CustomScriptExtension".
     */
    @JsonProperty(value = "type")
    private String type;

    /*
     * Specifies the version of the script handler.
     */
    @JsonProperty(value = "typeHandlerVersion")
    private String typeHandlerVersion;

    /*
     * Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension
     * will not upgrade minor versions unless redeployed, even with this
     * property set to true.
     */
    @JsonProperty(value = "autoUpgradeMinorVersion")
    private Boolean autoUpgradeMinorVersion;

    /*
     * Indicates whether the extension should be automatically upgraded by the
     * platform if there is a newer version of the extension available.
     */
    @JsonProperty(value = "enableAutomaticUpgrade")
    private Boolean enableAutomaticUpgrade;

    /*
     * Json formatted public settings for the extension.
     */
    @JsonProperty(value = "settings")
    private Object settings;

    /*
     * The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     */
    @JsonProperty(value = "protectedSettings")
    private Object protectedSettings;

    /*
     * The provisioning state, which only appears in the response.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /*
     * The virtual machine extension instance view.
     */
    @JsonProperty(value = "instanceView")
    private VirtualMachineExtensionInstanceView instanceView;

    /*
     * Indicates whether failures stemming from the extension will be
     * suppressed (Operational failures such as not connecting to the VM will
     * not be suppressed regardless of this value). The default is false.
     */
    @JsonProperty(value = "suppressFailures")
    private Boolean suppressFailures;

    /*
     * The extensions protected settings that are passed by reference, and
     * consumed from key vault
     */
    @JsonProperty(value = "protectedSettingsFromKeyVault")
    private Object protectedSettingsFromKeyVault;

    /**
     * Get the forceUpdateTag property: How the extension handler should be forced to update even if the extension
     * configuration has not changed.
     *
     * @return the forceUpdateTag value.
     */
    public String forceUpdateTag() {
        return this.forceUpdateTag;
    }

    /**
     * Set the forceUpdateTag property: How the extension handler should be forced to update even if the extension
     * configuration has not changed.
     *
     * @param forceUpdateTag the forceUpdateTag value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withForceUpdateTag(String forceUpdateTag) {
        this.forceUpdateTag = forceUpdateTag;
        return this;
    }

    /**
     * Get the publisher property: The name of the extension handler publisher.
     *
     * @return the publisher value.
     */
    public String publisher() {
        return this.publisher;
    }

    /**
     * Set the publisher property: The name of the extension handler publisher.
     *
     * @param publisher the publisher value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    /**
     * Get the type property: Specifies the type of the extension; an example is "CustomScriptExtension".
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type property: Specifies the type of the extension; an example is "CustomScriptExtension".
     *
     * @param type the type value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the typeHandlerVersion property: Specifies the version of the script handler.
     *
     * @return the typeHandlerVersion value.
     */
    public String typeHandlerVersion() {
        return this.typeHandlerVersion;
    }

    /**
     * Set the typeHandlerVersion property: Specifies the version of the script handler.
     *
     * @param typeHandlerVersion the typeHandlerVersion value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withTypeHandlerVersion(String typeHandlerVersion) {
        this.typeHandlerVersion = typeHandlerVersion;
        return this;
    }

    /**
     * Get the autoUpgradeMinorVersion property: Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension will not upgrade minor versions unless
     * redeployed, even with this property set to true.
     *
     * @return the autoUpgradeMinorVersion value.
     */
    public Boolean autoUpgradeMinorVersion() {
        return this.autoUpgradeMinorVersion;
    }

    /**
     * Set the autoUpgradeMinorVersion property: Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension will not upgrade minor versions unless
     * redeployed, even with this property set to true.
     *
     * @param autoUpgradeMinorVersion the autoUpgradeMinorVersion value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withAutoUpgradeMinorVersion(Boolean autoUpgradeMinorVersion) {
        this.autoUpgradeMinorVersion = autoUpgradeMinorVersion;
        return this;
    }

    /**
     * Get the enableAutomaticUpgrade property: Indicates whether the extension should be automatically upgraded by the
     * platform if there is a newer version of the extension available.
     *
     * @return the enableAutomaticUpgrade value.
     */
    public Boolean enableAutomaticUpgrade() {
        return this.enableAutomaticUpgrade;
    }

    /**
     * Set the enableAutomaticUpgrade property: Indicates whether the extension should be automatically upgraded by the
     * platform if there is a newer version of the extension available.
     *
     * @param enableAutomaticUpgrade the enableAutomaticUpgrade value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withEnableAutomaticUpgrade(Boolean enableAutomaticUpgrade) {
        this.enableAutomaticUpgrade = enableAutomaticUpgrade;
        return this;
    }

    /**
     * Get the settings property: Json formatted public settings for the extension.
     *
     * @return the settings value.
     */
    public Object settings() {
        return this.settings;
    }

    /**
     * Set the settings property: Json formatted public settings for the extension.
     *
     * @param settings the settings value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withSettings(Object settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get the protectedSettings property: The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     *
     * @return the protectedSettings value.
     */
    public Object protectedSettings() {
        return this.protectedSettings;
    }

    /**
     * Set the protectedSettings property: The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     *
     * @param protectedSettings the protectedSettings value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withProtectedSettings(Object protectedSettings) {
        this.protectedSettings = protectedSettings;
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state, which only appears in the response.
     *
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the instanceView property: The virtual machine extension instance view.
     *
     * @return the instanceView value.
     */
    public VirtualMachineExtensionInstanceView instanceView() {
        return this.instanceView;
    }

    /**
     * Set the instanceView property: The virtual machine extension instance view.
     *
     * @param instanceView the instanceView value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withInstanceView(VirtualMachineExtensionInstanceView instanceView) {
        this.instanceView = instanceView;
        return this;
    }

    /**
     * Get the suppressFailures property: Indicates whether failures stemming from the extension will be suppressed
     * (Operational failures such as not connecting to the VM will not be suppressed regardless of this value). The
     * default is false.
     *
     * @return the suppressFailures value.
     */
    public Boolean suppressFailures() {
        return this.suppressFailures;
    }

    /**
     * Set the suppressFailures property: Indicates whether failures stemming from the extension will be suppressed
     * (Operational failures such as not connecting to the VM will not be suppressed regardless of this value). The
     * default is false.
     *
     * @param suppressFailures the suppressFailures value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withSuppressFailures(Boolean suppressFailures) {
        this.suppressFailures = suppressFailures;
        return this;
    }

    /**
     * Get the protectedSettingsFromKeyVault property: The extensions protected settings that are passed by reference,
     * and consumed from key vault.
     *
     * @return the protectedSettingsFromKeyVault value.
     */
    public Object protectedSettingsFromKeyVault() {
        return this.protectedSettingsFromKeyVault;
    }

    /**
     * Set the protectedSettingsFromKeyVault property: The extensions protected settings that are passed by reference,
     * and consumed from key vault.
     *
     * @param protectedSettingsFromKeyVault the protectedSettingsFromKeyVault value to set.
     * @return the VirtualMachineExtensionProperties object itself.
     */
    public VirtualMachineExtensionProperties withProtectedSettingsFromKeyVault(Object protectedSettingsFromKeyVault) {
        this.protectedSettingsFromKeyVault = protectedSettingsFromKeyVault;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (instanceView() != null) {
            instanceView().validate();
        }
    }
}
