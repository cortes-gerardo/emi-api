package com.gerardocortes.emiapi.controller;

import java.math.BigDecimal;

public record ResultResponse(Boolean success, BigDecimal value) implements Response {
    ResultResponse(BigDecimal value) {
        this(true, value);
    }
}
