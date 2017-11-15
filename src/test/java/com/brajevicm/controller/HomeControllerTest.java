package com.brajevicm.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author:  Milos Brajevic
 * Mail:    milos.brajevic@hotmail.com
 * Github:  https://github.com/brajevicm
 * Date:    15-Nov-17
 */
public class HomeControllerTest {
  @Test
  public void testHomePage() throws Exception {
    HomeController homeController = new HomeController();
    MockMvc mockMvc = standaloneSetup(homeController).build();
    mockMvc.perform(get("/"))
      .andExpect(view().name("index"));
  }
}
