package com.gerardocortes.emiapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController {
    @PostMapping(value= "/emi")
    public ResponseEntity<ResultResponse> calculate(@Valid @RequestBody EmiArguments emiArguments) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResultResponse(100));
    }
}
