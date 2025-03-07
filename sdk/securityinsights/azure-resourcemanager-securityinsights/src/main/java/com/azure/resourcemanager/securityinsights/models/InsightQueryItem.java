// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Represents Insight Query. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonTypeName("Insight")
@Fluent
public final class InsightQueryItem extends EntityQueryItem {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(InsightQueryItem.class);

    /*
     * Properties bag for InsightQueryItem
     */
    @JsonProperty(value = "properties")
    private InsightQueryItemProperties properties;

    /**
     * Get the properties property: Properties bag for InsightQueryItem.
     *
     * @return the properties value.
     */
    public InsightQueryItemProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Properties bag for InsightQueryItem.
     *
     * @param properties the properties value to set.
     * @return the InsightQueryItem object itself.
     */
    public InsightQueryItem withProperties(InsightQueryItemProperties properties) {
        this.properties = properties;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public InsightQueryItem withName(String name) {
        super.withName(name);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public InsightQueryItem withType(String type) {
        super.withType(type);
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
        if (properties() != null) {
            properties().validate();
        }
    }
}
