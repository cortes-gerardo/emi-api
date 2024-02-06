package com.gerardocortes.emiapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public final class JsonHelper {
    private static final ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static String asJson(Object obj) {
        return mapper.writeValueAsString(obj);
    }}
