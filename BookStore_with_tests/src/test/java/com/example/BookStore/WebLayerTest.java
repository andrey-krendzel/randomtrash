package com.example.BookStore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testDefaultMessage() throws Exception {
     //   this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
        //          .andExpect(content().string(containsString("Hello World")));
    }
}