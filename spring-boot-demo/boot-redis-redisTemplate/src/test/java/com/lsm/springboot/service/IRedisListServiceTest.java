package com.lsm.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.service.IRedisListService;
import com.lsm.springboot.service.IRedisStringService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by za-lishenming on 2017/6/2.
 */
public class IRedisListServiceTest extends BaseTest {

    @Autowired
    private IRedisListService redisListServiceImpl;

    @Test
    public void testLPush() {
        redisListServiceImpl.lPush("employee_lPush", new Employee(3000L, 18621949197L, "lsm12", new Date()));
        redisListServiceImpl.lPush("employee_lPush", new Employee(3001L, 18621949198L, "lsm13", new Date()));
    }

    @Test
    public void testRPush() {

//        redisServiceImpl.rPush("employee_lPush", new Employee(4001L, 48621949198L, "lsm43", new Date()));
        System.out.println("start" + System.currentTimeMillis());
        for (int i = 0; i < 1000000; i++) {
            redisListServiceImpl.rPush("employee_lPush_batch", new Employee((long) i, i + 100L, "test" + i, new Date()));
        }
        System.out.println("end" + System.currentTimeMillis());
    }

    @Test
    public void testLPop() {
        String lPush = redisListServiceImpl.lPop("employee_lPush");
        Employee employee = JSONObject.parseObject(lPush, Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testRPop() {
        String lPush = redisListServiceImpl.rPop("employee_lPush");
        Employee employee = JSONObject.parseObject(lPush, Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testLLen() {
        Long length = redisListServiceImpl.lLen("employee_lPush_batch");
        System.out.println(length);
    }

    @Test
    public void testLRange() {
       /* redisServiceImpl.rPush("employee_lPush", new Employee(5000L, 48621949197L, "lsm42", new Date()));
        redisServiceImpl.rPush("employee_lPush", new Employee(5001L, 48621949198L, "lsm43", new Date()));
        redisServiceImpl.lPush("employee_lPush", new Employee(6000L, 18621949197L, "lsm12", new Date()));
        redisServiceImpl.lPush("employee_lPush", new Employee(6001L, 18621949198L, "lsm13", new Date()));*/
        long start = System.currentTimeMillis();
        System.out.println("start:" + start);
        List<String> stringList = redisListServiceImpl.lRange("employee_lPush_batch", 1000, 2000);
        System.out.println(stringList );
        long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        System.out.println("total:" + (end - start));
    }

}
