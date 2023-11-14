package com.example.symbolfrequencyproject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = SymbolFrequencyController.class)
class SymbolFrequencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCalculateFrequncy() throws Exception {
        String inputString = "aaaaabcccc";
        String requestBody = "{\"inputString\": \"" + inputString + "\"}";

        mockMvc.perform(post("/calculationFrequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.a").value(5))
                .andExpect(jsonPath("$.b").value(1))
                .andExpect(jsonPath("$.c").value(4));
    }
}