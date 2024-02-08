package com.gerardocortes.emiapi.controller;

import com.gerardocortes.emiapi.service.CalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController {

    private final CalculatorService service;

    @Autowired
    public CalculatorController(final CalculatorService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value= "/emi")
    public ResponseEntity<ResultResponse> calculate(@Valid @RequestBody EmiArguments emiArguments) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResultResponse(service.calculate(emiArguments.getLoanValue(), emiArguments.getYearlyInterestRate(), emiArguments.getLoanTerm())));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/history")
    public ResponseEntity<HistoryResponse> history() {
        return ResponseEntity
                .ok(new HistoryResponse(service.history()));
    }

}
