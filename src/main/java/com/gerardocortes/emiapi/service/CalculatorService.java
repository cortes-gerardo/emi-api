package com.gerardocortes.emiapi.service;

import com.gerardocortes.emiapi.repository.EmiRepository;
import com.gerardocortes.emiapi.repository.entity.Emi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Service
public class CalculatorService {
    private final EmiService emiService;
    private final EmiRepository emiRepository;

    @Autowired
    public CalculatorService(final EmiService emiService, final EmiRepository emiRepository) {
        this.emiService = emiService;
        this.emiRepository = emiRepository;
    }

    public BigDecimal calculate(BigDecimal loanValue, Double yearlyInterestRate, Integer loanTermInYears) {
        final BigDecimal total = emiService.calculate(loanValue, yearlyInterestRate, loanTermInYears);
        emiRepository.save(new Emi(total));
        return total;
    }

    public List<BigDecimal> history() {
        return stream(emiRepository.findAll().spliterator(), false)
                .map(Emi::getAmount)
                .collect(Collectors.toList());
    }
}
