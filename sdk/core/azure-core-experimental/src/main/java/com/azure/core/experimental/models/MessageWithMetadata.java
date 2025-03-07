// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.experimental.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.BinaryData;

/**
 * An abstraction for a message containing a content type along with its data.
 */
@Fluent
public class MessageWithMetadata {
    private BinaryData binaryData;
    private String contentType;

    /**
     * Gets the message body.
     *
     * @return The message body.
     */
    public BinaryData getBodyAsBinaryData() {
        return binaryData;
    }

    /**
     * Sets the message body.
     *
     * @param binaryData The message body.
     *
     * @return The updated {@link MessageWithMetadata} object.
     */
    public MessageWithMetadata setBodyAsBinaryData(BinaryData binaryData) {
        this.binaryData = binaryData;
        return this;
    }

    /**
     * Gets the content type.
     *
     * @return The content type.
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the content type.
     *
     * @param contentType The content type.
     *
     * @return The updated {@link MessageWithMetadata} object.
     */
    public MessageWithMetadata setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
