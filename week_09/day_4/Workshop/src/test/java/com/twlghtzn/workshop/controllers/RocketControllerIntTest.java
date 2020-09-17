package com.twlghtzn.workshop.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.twlghtzn.workshop.services.ShipService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RocketControllerIntTest {

  @Autowired
  private MockMvc mockMvc;
  private ShipService shipService;

  @Autowired
  public RocketControllerIntTest(MockMvc mockMvc, ShipService shipService) {
    this.mockMvc = mockMvc;
    this.shipService = shipService;
  }

  @BeforeEach
  void setup() {
    shipService.clearShip();
  }

  @Test
  void givenAnEmptyShip_ReturnShip() throws Exception {
    mockMvc.perform(get("/rocket"))
        .andExpect(jsonPath("$.caliber25", is(0)))
        .andExpect(jsonPath("$.caliber30", is(0)))
        .andExpect(jsonPath("$.caliber50", is(0)))
        .andExpect(jsonPath("$.shipstatus", is("empty")))
        .andExpect(jsonPath("$.ready", is(false)))
        .andExpect(status().isOk());
  }

  @Test
  void givenA40PercentFill_ReturnModifiedStatus() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.25&amount=5000"))
        .andExpect(jsonPath("$.received", is(".25")))
        .andExpect(jsonPath("$.amount", is(5000)))
        .andExpect(jsonPath("$.shipstatus", is("40%")))
        .andExpect(jsonPath("$.ready", is(false)))
        .andExpect(status().isOk());
  }

  @Test
  void givenAFullFill_ReturnModifiedStatus() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.25&amount=12500"))
        .andExpect(jsonPath("$.received", is(".25")))
        .andExpect(jsonPath("$.amount", is(12500)))
        .andExpect(jsonPath("$.shipstatus", is("full")))
        .andExpect(jsonPath("$.ready", is(true)))
        .andExpect(status().isOk());
  }

  @Test
  void givenA15000Fill_ReturnModifiedStatus() throws Exception {
    mockMvc.perform(get("/rocket/fill?caliber=.25&amount=15000"))
        .andExpect(jsonPath("$.received", is(".25")))
        .andExpect(jsonPath("$.amount", is(15000)))
        .andExpect(jsonPath("$.shipstatus", is("overloaded")))
        .andExpect(jsonPath("$.ready", is(false)))
        .andExpect(status().isOk());
  }

  @Test
  void givenNoParameters_ReturnBadRequestStatusAndErrorMessage() throws Exception {
    mockMvc.perform(get("/rocket/fill"))
        .andExpect(jsonPath("$.error", is("How much for the gun?")))
        .andExpect(status().isBadRequest());
  }
}
