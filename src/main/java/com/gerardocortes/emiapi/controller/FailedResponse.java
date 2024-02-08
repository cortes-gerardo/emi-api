package com.gerardocortes.emiapi.controller;

public record FailedResponse(Boolean success, String message) {
    FailedResponse(String message) {
        this(false, message);
    }
}
