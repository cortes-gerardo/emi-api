package com.gerardocortes.emiapi;

import com.gerardocortes.emiapi.controller.CalculatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmiApiApplicationTests {

    @Autowired
    private CalculatorController controller;

    @Test
    void contextLoads() {
        assertNotNull(controller , "CalculatorController is not in the context, the application will not initialize");
    }

}
