package com.gerardocortes.emiapi.controller;

import java.util.Map;

public record FailedResponse(Boolean success, Map<String, String> violations) {
    FailedResponse(Map<String, String> violations) {
        this(false, violations);
    }
}
