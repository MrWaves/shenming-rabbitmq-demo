package com.lsm.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Person;
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
public class MongoControllerTest extends BaseTest {

    MockMvc mvc;
    @Autowired
    WebApplicationContext webApplicationConnect;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();

    }

    @Test
    public void insertUser() throws Exception {
        String uri = "/mongo/insertPerson.json";
        Person person = new Person();

        person.setName("testtest");

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(person)))
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();

        System.out.println(response + " : " + status);

    }
}
