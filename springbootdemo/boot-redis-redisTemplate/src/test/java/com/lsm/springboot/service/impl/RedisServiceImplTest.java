package com.lsm.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.service.IRedisService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by za-lishenming on 2017/6/2.
 */
public class RedisServiceImplTest extends BaseTest {
    @Autowired
    private IRedisService redisServiceImpl;

    @Test
    public void testSet() {
        Employee employee = new Employee();
        employee.setId(100L);
        employee.setName("test");
        employee.setPhoneNum(18621949188L);
        employee.setCreateTime(new Date());
        String jsonString = JSONObject.toJSONString(employee);
//        Employee employee2 = JSONObject.parseObject(jsonString, Employee.class);
        redisServiceImpl.set("employee_1000", jsonString);
        redisServiceImpl.set("employee_1000_withExpireMillis", jsonString, 10000);
    }

    @Test
    public void testGet() {
        String result = redisServiceImpl.get("employee_1000_withExpireMillis");
        System.out.println(result);
    }

    @Test
    public void testExpire() {
        redisServiceImpl.expire("employee_1000", 1000);
    }

    @Test
    public void testSetList() {
        redisServiceImpl.setList("employeeList", Arrays.asList(
                new Employee(1000L, 18621949187L, "lsm1", new Date()),
                new Employee(1001L, 18621949188L, "lsm2", new Date())));

    }

    @Test
    public void testGetList() {
        List<Employee> employeeList = redisServiceImpl.getList("employeeList", Employee.class);
        System.out.println(employeeList);
    }

    @Test
    public void testLPush() {
        redisServiceImpl.lPush("employee_lPush", new Employee(3000L, 18621949197L, "lsm12", new Date()));
        redisServiceImpl.lPush("employee_lPush", new Employee(3001L, 18621949198L, "lsm13", new Date()));
    }

    @Test
    public void testRPush() {

//        redisServiceImpl.rPush("employee_lPush", new Employee(4001L, 48621949198L, "lsm43", new Date()));
        System.out.println("start" + System.currentTimeMillis());
        for (int i = 0; i < 1000000; i++) {
            redisServiceImpl.rPush("employee_lPush_batch", new Employee((long) i, i + 100L, "test" + i, new Date()));
        }
        System.out.println("end" + System.currentTimeMillis());
    }

    @Test
    public void testLPop() {
        String lPush = redisServiceImpl.lPop("employee_lPush");
        Employee employee = JSONObject.parseObject(lPush, Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testRPop() {
        String lPush = redisServiceImpl.rPop("employee_lPush");
        Employee employee = JSONObject.parseObject(lPush, Employee.class);
        System.out.println(employee);
    }

    @Test
    public void testLLen() {
        Long length = redisServiceImpl.lLen("employee_lPush_batch");
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
        List<String> stringList = redisServiceImpl.lRange("employee_lPush_batch", 1000, 2000);
        System.out.println(stringList );
        long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        System.out.println("total:" + (end - start));
    }

}
