package com.joantolos.kata.hashtag.generator.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GeneratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetHashTagsText() throws Exception {
        this.mockMvc
                .perform(get("/1/3"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
