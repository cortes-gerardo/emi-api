package com.gerardocortes.emiapi.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public final class EmiArguments {

    @NotNull
    @Positive
    private final BigInteger loanValue;

    @NotNull
    @PositiveOrZero
    @Max(value = 100, message = "should not exceed 100")
    private final Integer yearlyInterestRate;

    @NotNull
    @PositiveOrZero
    @Max(value = 30, message = "should not exceed 30")
    private final Integer loanTerm;

}
