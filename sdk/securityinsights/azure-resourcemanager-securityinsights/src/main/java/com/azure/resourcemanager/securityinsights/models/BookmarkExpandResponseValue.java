// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.fluent.models.EntityInner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The expansion result values. */
@Fluent
public final class BookmarkExpandResponseValue {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(BookmarkExpandResponseValue.class);

    /*
     * Array of the expansion result entities.
     */
    @JsonProperty(value = "entities")
    private List<EntityInner> entities;

    /*
     * Array of expansion result connected entities
     */
    @JsonProperty(value = "edges")
    private List<ConnectedEntity> edges;

    /**
     * Get the entities property: Array of the expansion result entities.
     *
     * @return the entities value.
     */
    public List<EntityInner> entities() {
        return this.entities;
    }

    /**
     * Set the entities property: Array of the expansion result entities.
     *
     * @param entities the entities value to set.
     * @return the BookmarkExpandResponseValue object itself.
     */
    public BookmarkExpandResponseValue withEntities(List<EntityInner> entities) {
        this.entities = entities;
        return this;
    }

    /**
     * Get the edges property: Array of expansion result connected entities.
     *
     * @return the edges value.
     */
    public List<ConnectedEntity> edges() {
        return this.edges;
    }

    /**
     * Set the edges property: Array of expansion result connected entities.
     *
     * @param edges the edges value to set.
     * @return the BookmarkExpandResponseValue object itself.
     */
    public BookmarkExpandResponseValue withEdges(List<ConnectedEntity> edges) {
        this.edges = edges;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (entities() != null) {
            entities().forEach(e -> e.validate());
        }
        if (edges() != null) {
            edges().forEach(e -> e.validate());
        }
    }
}
