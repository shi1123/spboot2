package com.szp.spboot2.controller;

import com.szp.spboot2.MyApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
/*
*   必须以application-开头
*   application-dev.properties
*   application-test.properties
*   application-dev.yml
*   application-dev.yml
*
*   @ActiveProfiles("test") //指定使用application-test.yml
*   */
@RunWith(SpringRunner.class)
@SpringBootTest//(classes = {MyApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration
@TestPropertySource(properties = { "spring.config.location = classpath:application.yml" })
public class MyControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetPerson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/test").
                contentType(MediaType.APPLICATION_JSON_UTF8).
                accept(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andDo(MockMvcResultHandlers.print());
    }
}
