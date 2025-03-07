// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.fluent.models.EyesOnSettingsProperties;
import com.azure.resourcemanager.securityinsights.fluent.models.SettingsInner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Settings with single toggle. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonTypeName("EyesOn")
@Fluent
public final class EyesOn extends SettingsInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(EyesOn.class);

    /*
     * EyesOn properties
     */
    @JsonProperty(value = "properties")
    private EyesOnSettingsProperties innerProperties;

    /**
     * Get the innerProperties property: EyesOn properties.
     *
     * @return the innerProperties value.
     */
    private EyesOnSettingsProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public EyesOn withEtag(String etag) {
        super.withEtag(etag);
        return this;
    }

    /**
     * Get the isEnabled property: Determines whether the setting is enable or disabled.
     *
     * @return the isEnabled value.
     */
    public Boolean isEnabled() {
        return this.innerProperties() == null ? null : this.innerProperties().isEnabled();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
