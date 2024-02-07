package com.gerardocortes.emiapi.controller;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public final class EmiArguments {

    @NotNull
    @Positive
    @Digits(integer=8, fraction=2)
    private final BigDecimal loanValue;

    @NotNull
    @PositiveOrZero
    @Max(value = 100, message = "should not exceed 100")
    @Digits(integer=3, fraction=2)
    private final Double yearlyInterestRate;

    @NotNull
    @PositiveOrZero
    @Max(value = 30, message = "should not exceed 30")
    private final Integer loanTerm;

}
