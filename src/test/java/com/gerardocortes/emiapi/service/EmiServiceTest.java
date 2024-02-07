package com.gerardocortes.emiapi.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmiServiceTest {

    private final EmiService service = new EmiService();

    @Test
    void whenGivenAValidCase_thenExpectAValidResult() {
        final BigDecimal emi = service.calculate(BigDecimal.valueOf(10_000_000.00), 10.50, 10);

        assertEquals(BigDecimal.valueOf(134_935).setScale(2, RoundingMode.HALF_UP), emi);
    }
}