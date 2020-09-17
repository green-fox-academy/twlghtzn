package com.twlghtzn.workshop.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;


@SpringBootTest
@AutoConfigureMockMvc
public class GuardianControllerIntTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  public GuardianControllerIntTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void givenMessage_ReturnOKAndReceivedAndTranslated() throws Exception {
    mockMvc.perform(get("/groot?message=hello"))
        .andExpect(jsonPath("$.received", is("hello")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")))
        .andExpect(status().isOk());
  }

  @Test
  void givenNoMessage_ReturnBadRequestStatusAndError() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(jsonPath("$.error", is("I am Groot!")))
        .andExpect(status().isBadRequest());
  }

  @Test
  void givenBothParameters_ReturnOKAndInputsAndSpeed() throws Exception {
    mockMvc.perform(get("/yondu?distance=100.0&time=10.0"))
        .andExpect(jsonPath("$.distance", is(100.0)))
        .andExpect(jsonPath("$.time", is(10.0)))
        .andExpect(jsonPath("$.speed", is(10.0)))
        .andExpect(status().isOk());
  }

  @Test
  void givenNoParameters_ReturnBadRequestStatusAndError() throws Exception {
    mockMvc.perform(get("/yondu"))
        .andExpect(jsonPath("$.error", is("Something's missing, pal.")))
        .andExpect(status().isBadRequest());
  }
}
