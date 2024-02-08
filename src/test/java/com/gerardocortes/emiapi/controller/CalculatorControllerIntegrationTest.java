package com.gerardocortes.emiapi.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static com.gerardocortes.emiapi.util.JsonHelper.asJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void whenGivenAValidInput_thenReturnsCreated() {
        // given
        MockHttpServletRequestBuilder requestBuilder = post("/v1/calculator/emi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJson(new EmiArguments(BigDecimal.valueOf(100.00), 10.50, 10)));

        //when
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        // then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true));
    }
    @Test
    @SneakyThrows
    void whenGivenAnInvalidInput_thenReturnsUnprocessableEntity() {
        // given
        MockHttpServletRequestBuilder requestBuilder = post("/v1/calculator/emi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJson(new EmiArguments(BigDecimal.valueOf(-1.00), 101.00, 31)));

        //when
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        // then
        resultActions
                .andExpect(status().isUnprocessableEntity())
                .andExpect(jsonPath("$.success").value(false))
                .andExpect(jsonPath("$.message").isNotEmpty());
    }

    @Test
    @SneakyThrows
    void whenGivenAValidInput_thenReturnsOk() {
        // given
        MockHttpServletRequestBuilder requestBuilder = get("/v1/calculator/history");

        //when
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success").value(true));
    }

}