package com.gerardocortes.emiapi.controller;

import java.math.BigDecimal;
import java.util.List;

public record HistoryResponse(Boolean success, List<BigDecimal> history) implements Response {
    HistoryResponse(List<BigDecimal> history) {
        this(true, history);
    }
}
