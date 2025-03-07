// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A disk access SAS uri. */
@Immutable
public final class AccessUriInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AccessUriInner.class);

    /*
     * A SAS uri for accessing a disk.
     */
    @JsonProperty(value = "accessSAS", access = JsonProperty.Access.WRITE_ONLY)
    private String accessSas;

    /*
     * A SAS uri for accessing a VM guest state.
     */
    @JsonProperty(value = "securityDataAccessSAS", access = JsonProperty.Access.WRITE_ONLY)
    private String securityDataAccessSas;

    /**
     * Get the accessSas property: A SAS uri for accessing a disk.
     *
     * @return the accessSas value.
     */
    public String accessSas() {
        return this.accessSas;
    }

    /**
     * Get the securityDataAccessSas property: A SAS uri for accessing a VM guest state.
     *
     * @return the securityDataAccessSas value.
     */
    public String securityDataAccessSas() {
        return this.securityDataAccessSas;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }
}
