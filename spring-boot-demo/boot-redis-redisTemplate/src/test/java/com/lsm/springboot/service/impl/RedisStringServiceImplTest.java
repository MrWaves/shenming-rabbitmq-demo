package com.lsm.springboot.service.impl;

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
public class RedisStringServiceImplTest extends BaseTest {
    @Autowired
    private IRedisStringService redisStringServiceImpl;

    @Test
    public void testSet() {
        Employee employee = new Employee();
        employee.setId(100L);
        employee.setName("test");
        employee.setPhoneNum(18621949188L);
        employee.setCreateTime(new Date());
        String jsonString = JSONObject.toJSONString(employee);
//        Employee employee2 = JSONObject.parseObject(jsonString, Employee.class);
        redisStringServiceImpl.set("employee_1000", jsonString);
        redisStringServiceImpl.set("employee_1000_withExpireMillis", jsonString, 10000);
    }

    @Test
    public void testGet() {
        String result = redisStringServiceImpl.get("employee_1000_withExpireMillis");
        System.out.println(result);
    }

    @Test
    public void testExpire() {
        redisStringServiceImpl.expire("employee_1000", 1000);
    }

    @Test
    public void testSetList() {
        redisStringServiceImpl.setList("employeeList", Arrays.asList(
                new Employee(1000L, 18621949187L, "lsm1", new Date()),
                new Employee(1001L, 18621949188L, "lsm2", new Date())));

    }

    @Test
    public void testGetList() {
        List<Employee> employeeList = redisStringServiceImpl.getList("employeeList", Employee.class);
        System.out.println(employeeList);
    }
}
