package com.gerardocortes.emiapi.controller;

import com.gerardocortes.emiapi.service.EmiService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController {

    private final EmiService service;

    @Autowired
    public CalculatorController(final EmiService service) {
        this.service = service;
    }

    @PostMapping(value= "/emi")
    public ResponseEntity<ResultResponse> calculate(@Valid @RequestBody EmiArguments emiArguments) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResultResponse(service.calculate(emiArguments.getLoanValue(), emiArguments.getYearlyInterestRate(), emiArguments.getLoanTerm())));
    }
}
