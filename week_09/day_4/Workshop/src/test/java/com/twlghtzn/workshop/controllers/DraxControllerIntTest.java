package com.twlghtzn.workshop.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.twlghtzn.workshop.services.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DraxControllerIntTest {

  private MockMvc mockMvc;
  private FoodService foodService;

  @Autowired
  public DraxControllerIntTest(MockMvc mockMvc,
                               FoodService foodService) {
    this.mockMvc = mockMvc;
    this.foodService = foodService;
  }

  @Test
  void givenFoodsList_ReturnFoodsList() throws Exception {
    mockMvc.perform(get("/drax"))
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$", hasSize(4)))
        .andExpect(jsonPath("$.[0].name", is("Pizza")))
        .andExpect(status().isOk());
  }

  @Test
  void givenFoodsListAndFoodInList_ExpectOKStatus() throws Exception {
    mockMvc.perform(get("/drax/remove?name=Pizza"))
        .andExpect(jsonPath("$.message", is("Why are you taking it from me?!")))
        .andExpect(status().isOk());
  }

  @Test
  void givenFoodsListAndNoParameter_ExpectBadRequestStatus() throws Exception {
    mockMvc.perform(get("/drax/remove"))
        .andExpect(jsonPath("$.message", is("Almost... Try again, buddy!")))
        .andExpect(status().isBadRequest());
  }
}
