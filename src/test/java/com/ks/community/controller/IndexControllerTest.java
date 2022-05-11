package com.ks.community.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@WebMvcTest(controllers = IndexController.class)
class IndexControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void index() throws Exception {
      mvc.perform(servletContext -> (MockHttpServletRequest) servletContext.getContext("/index"))
              .andExpect(result -> result.getModelAndView().getViewName().equals("/view/login.html"));
    }
}