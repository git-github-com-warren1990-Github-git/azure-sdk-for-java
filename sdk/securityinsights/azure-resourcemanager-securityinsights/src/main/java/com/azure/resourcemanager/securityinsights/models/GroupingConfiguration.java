// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.util.List;

/** Grouping configuration property bag. */
@Fluent
public final class GroupingConfiguration {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(GroupingConfiguration.class);

    /*
     * Grouping enabled
     */
    @JsonProperty(value = "enabled", required = true)
    private boolean enabled;

    /*
     * Re-open closed matching incidents
     */
    @JsonProperty(value = "reopenClosedIncident", required = true)
    private boolean reopenClosedIncident;

    /*
     * Limit the group to alerts created within the lookback duration (in ISO
     * 8601 duration format)
     */
    @JsonProperty(value = "lookbackDuration", required = true)
    private Duration lookbackDuration;

    /*
     * Grouping matching method. When method is Selected at least one of
     * groupByEntities, groupByAlertDetails, groupByCustomDetails must be
     * provided and not empty.
     */
    @JsonProperty(value = "matchingMethod", required = true)
    private MatchingMethod matchingMethod;

    /*
     * A list of entity types to group by (when matchingMethod is Selected).
     * Only entities defined in the current alert rule may be used.
     */
    @JsonProperty(value = "groupByEntities")
    private List<EntityMappingType> groupByEntities;

    /*
     * A list of alert details to group by (when matchingMethod is Selected)
     */
    @JsonProperty(value = "groupByAlertDetails")
    private List<AlertDetail> groupByAlertDetails;

    /*
     * A list of custom details keys to group by (when matchingMethod is
     * Selected). Only keys defined in the current alert rule may be used.
     */
    @JsonProperty(value = "groupByCustomDetails")
    private List<String> groupByCustomDetails;

    /**
     * Get the enabled property: Grouping enabled.
     *
     * @return the enabled value.
     */
    public boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled property: Grouping enabled.
     *
     * @param enabled the enabled value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get the reopenClosedIncident property: Re-open closed matching incidents.
     *
     * @return the reopenClosedIncident value.
     */
    public boolean reopenClosedIncident() {
        return this.reopenClosedIncident;
    }

    /**
     * Set the reopenClosedIncident property: Re-open closed matching incidents.
     *
     * @param reopenClosedIncident the reopenClosedIncident value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withReopenClosedIncident(boolean reopenClosedIncident) {
        this.reopenClosedIncident = reopenClosedIncident;
        return this;
    }

    /**
     * Get the lookbackDuration property: Limit the group to alerts created within the lookback duration (in ISO 8601
     * duration format).
     *
     * @return the lookbackDuration value.
     */
    public Duration lookbackDuration() {
        return this.lookbackDuration;
    }

    /**
     * Set the lookbackDuration property: Limit the group to alerts created within the lookback duration (in ISO 8601
     * duration format).
     *
     * @param lookbackDuration the lookbackDuration value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withLookbackDuration(Duration lookbackDuration) {
        this.lookbackDuration = lookbackDuration;
        return this;
    }

    /**
     * Get the matchingMethod property: Grouping matching method. When method is Selected at least one of
     * groupByEntities, groupByAlertDetails, groupByCustomDetails must be provided and not empty.
     *
     * @return the matchingMethod value.
     */
    public MatchingMethod matchingMethod() {
        return this.matchingMethod;
    }

    /**
     * Set the matchingMethod property: Grouping matching method. When method is Selected at least one of
     * groupByEntities, groupByAlertDetails, groupByCustomDetails must be provided and not empty.
     *
     * @param matchingMethod the matchingMethod value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withMatchingMethod(MatchingMethod matchingMethod) {
        this.matchingMethod = matchingMethod;
        return this;
    }

    /**
     * Get the groupByEntities property: A list of entity types to group by (when matchingMethod is Selected). Only
     * entities defined in the current alert rule may be used.
     *
     * @return the groupByEntities value.
     */
    public List<EntityMappingType> groupByEntities() {
        return this.groupByEntities;
    }

    /**
     * Set the groupByEntities property: A list of entity types to group by (when matchingMethod is Selected). Only
     * entities defined in the current alert rule may be used.
     *
     * @param groupByEntities the groupByEntities value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withGroupByEntities(List<EntityMappingType> groupByEntities) {
        this.groupByEntities = groupByEntities;
        return this;
    }

    /**
     * Get the groupByAlertDetails property: A list of alert details to group by (when matchingMethod is Selected).
     *
     * @return the groupByAlertDetails value.
     */
    public List<AlertDetail> groupByAlertDetails() {
        return this.groupByAlertDetails;
    }

    /**
     * Set the groupByAlertDetails property: A list of alert details to group by (when matchingMethod is Selected).
     *
     * @param groupByAlertDetails the groupByAlertDetails value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withGroupByAlertDetails(List<AlertDetail> groupByAlertDetails) {
        this.groupByAlertDetails = groupByAlertDetails;
        return this;
    }

    /**
     * Get the groupByCustomDetails property: A list of custom details keys to group by (when matchingMethod is
     * Selected). Only keys defined in the current alert rule may be used.
     *
     * @return the groupByCustomDetails value.
     */
    public List<String> groupByCustomDetails() {
        return this.groupByCustomDetails;
    }

    /**
     * Set the groupByCustomDetails property: A list of custom details keys to group by (when matchingMethod is
     * Selected). Only keys defined in the current alert rule may be used.
     *
     * @param groupByCustomDetails the groupByCustomDetails value to set.
     * @return the GroupingConfiguration object itself.
     */
    public GroupingConfiguration withGroupByCustomDetails(List<String> groupByCustomDetails) {
        this.groupByCustomDetails = groupByCustomDetails;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (lookbackDuration() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property lookbackDuration in model GroupingConfiguration"));
        }
        if (matchingMethod() == null) {
            throw logger
                .logExceptionAsError(
                    new IllegalArgumentException(
                        "Missing required property matchingMethod in model GroupingConfiguration"));
        }
    }
}
