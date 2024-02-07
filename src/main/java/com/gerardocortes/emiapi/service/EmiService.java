package com.gerardocortes.emiapi.service;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class EmiService {
    private static final int MONTHS_IN_A_YEAR = 12;
    private static final CurrencyUnit CURRENCY = CurrencyUnit.EUR;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public BigDecimal calculate(BigDecimal loanValue, Double yearlyInterestRate, Integer loanTermInYears) {
        return emi(getBigMoney(loanValue), getMonthlyInterestRate(yearlyInterestRate), getLoanTermInMonths(loanTermInYears))
                .rounded(2, ROUNDING_MODE)
                .getAmount()
                .setScale(2, ROUNDING_MODE);
    }

    private static BigMoney getBigMoney(final BigDecimal loanValue) {
        return BigMoney.of(CURRENCY, loanValue);
    }

    private static double getMonthlyInterestRate(final double yearlyInterestRate) {
        return yearlyInterestRate / 100 / MONTHS_IN_A_YEAR;
    }

    private static int getLoanTermInMonths(final int loanTermInYears) {
        return loanTermInYears * MONTHS_IN_A_YEAR;
    }

    private BigMoney emi(BigMoney loanValue, double monthlyInterestRate, int loanTermInMonths) {
        final double rate = Math.pow(monthlyInterestRate + 1, loanTermInMonths);
        return (loanValue.multipliedBy(monthlyInterestRate).multipliedBy(rate))
                .dividedBy(rate - 1, ROUNDING_MODE);
    }
}
