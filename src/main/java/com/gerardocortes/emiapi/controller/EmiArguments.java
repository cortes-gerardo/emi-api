package com.gerardocortes.emiapi.controller;

import java.math.BigInteger;

public record EmiArguments(BigInteger loanValue, Integer yearlyInterestRate, Integer loanTerm) {
}
