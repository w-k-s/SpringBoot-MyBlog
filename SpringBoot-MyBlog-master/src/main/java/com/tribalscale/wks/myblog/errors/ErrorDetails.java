package com.tribalscale.wks.myblog.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

public class ErrorDetails {

    private final LocalDateTime timestamp;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String details;

    public ErrorDetails(String message) {
        this(null, message, null);
    }

    public ErrorDetails(String message, String details) {
        this(null, message, details);
    }

    public ErrorDetails(@Nullable LocalDateTime timestamp, @NonNull String message, @Nullable String details) {
        this.timestamp = timestamp == null ? LocalDateTime.now() : timestamp;
        this.message = message;
        this.details = details;
    }

    @NonNull
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
