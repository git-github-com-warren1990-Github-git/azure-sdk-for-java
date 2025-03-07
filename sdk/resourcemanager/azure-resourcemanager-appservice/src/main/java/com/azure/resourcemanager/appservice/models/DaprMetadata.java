// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Container App Dapr component metadata. */
@Fluent
public final class DaprMetadata {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DaprMetadata.class);

    /*
     * Metadata property name.
     */
    @JsonProperty(value = "name")
    private String name;

    /*
     * Metadata property value.
     */
    @JsonProperty(value = "value")
    private String value;

    /*
     * Name of the Container App secret from which to pull the metadata
     * property value.
     */
    @JsonProperty(value = "secretRef")
    private String secretRef;

    /**
     * Get the name property: Metadata property name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Metadata property name.
     *
     * @param name the name value to set.
     * @return the DaprMetadata object itself.
     */
    public DaprMetadata withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the value property: Metadata property value.
     *
     * @return the value value.
     */
    public String value() {
        return this.value;
    }

    /**
     * Set the value property: Metadata property value.
     *
     * @param value the value value to set.
     * @return the DaprMetadata object itself.
     */
    public DaprMetadata withValue(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get the secretRef property: Name of the Container App secret from which to pull the metadata property value.
     *
     * @return the secretRef value.
     */
    public String secretRef() {
        return this.secretRef;
    }

    /**
     * Set the secretRef property: Name of the Container App secret from which to pull the metadata property value.
     *
     * @param secretRef the secretRef value to set.
     * @return the DaprMetadata object itself.
     */
    public DaprMetadata withSecretRef(String secretRef) {
        this.secretRef = secretRef;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
