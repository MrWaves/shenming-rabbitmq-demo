package com.lsm.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.service.IRedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by za-lishenming on 2017/6/2.
 */
public class RedisServiceImplTest extends BaseTest {
    @Autowired
    private IRedisService redisServiceImpl;

    @Test
    public void testSet(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("test");
        employee.setPhoneNum(18621949188L);
        employee.setCreateTime(new Date());
        redisServiceImpl.set("testJedis", JSONObject.toJSONString(employee));
    }

    @Test
    public void testGet(){
        System.out.println(redisServiceImpl.get("testJedis"));
    }

    @Test
    public void testDel(){
        System.out.println(redisServiceImpl.del("testJedis"));
    }

    @Test
    public void testExists(){
        System.out.println(redisServiceImpl.exists("testJedis2"));
    }
}
