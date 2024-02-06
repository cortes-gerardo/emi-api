package com.gerardocortes.emiapi.controller;

public record ResultResponse(Boolean success, Integer value) implements Response {
    ResultResponse(Integer value) {
        this(true, value);
    }
}
