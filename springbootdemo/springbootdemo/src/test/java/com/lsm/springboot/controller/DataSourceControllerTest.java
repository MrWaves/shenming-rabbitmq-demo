package com.lsm.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lsm.springboot.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by lishenming on 2017/4/18.
 */
public class DataSourceControllerTest extends BaseTest {

    MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void insertUser() throws Exception {
        String uri = "/dataSource/insertUser.json";

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.get(uri).
                        param("name", "test12").
                        param("phoneNum", "18821988276").
                        accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertFalse("错误，正确的返回值为200", status != 200);

    }
}
