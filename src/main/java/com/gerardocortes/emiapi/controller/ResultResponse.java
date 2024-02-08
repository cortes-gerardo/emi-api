package com.gerardocortes.emiapi.controller;

import java.math.BigDecimal;

public record ResultResponse(Boolean success, BigDecimal amount) implements Response {
    ResultResponse(BigDecimal amount) {
        this(true, amount);
    }
}
