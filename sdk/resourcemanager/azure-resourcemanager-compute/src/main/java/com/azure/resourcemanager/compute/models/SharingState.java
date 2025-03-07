// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.util.ExpandableStringEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collection;

/** Defines values for SharingState. */
public final class SharingState extends ExpandableStringEnum<SharingState> {
    /** Static value Succeeded for SharingState. */
    public static final SharingState SUCCEEDED = fromString("Succeeded");

    /** Static value InProgress for SharingState. */
    public static final SharingState IN_PROGRESS = fromString("InProgress");

    /** Static value Failed for SharingState. */
    public static final SharingState FAILED = fromString("Failed");

    /** Static value Unknown for SharingState. */
    public static final SharingState UNKNOWN = fromString("Unknown");

    /**
     * Creates or finds a SharingState from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding SharingState.
     */
    @JsonCreator
    public static SharingState fromString(String name) {
        return fromString(name, SharingState.class);
    }

    /** @return known SharingState values. */
    public static Collection<SharingState> values() {
        return values(SharingState.class);
    }
}
