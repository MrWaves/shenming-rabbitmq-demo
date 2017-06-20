package com.lsm.springboot.service.impl;

import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lishenming on 2017/4/19.
 */
public class EmployeeServiceImplTest extends BaseTest {
    @Autowired
    private IEmployeeService employeeServiceImpl;

    @Test
    @Transactional(value = "test2TxManager")
    public void testInsert() throws IllegalAccessException {
        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.setName("test" + i);
            employee.setPhoneNum(18621949188L);
            employeeServiceImpl.insert(employee);
        }
        Employee employee = new Employee();
        employee.setName("testtesttest");
        employee.setPhoneNum(18621949188L);
        employeeServiceImpl.insert(employee);
        throw new IllegalAccessException();
    }

    @Test
    public void testSelectByPrimaryKey(){
        Long id = 1L;
        Employee employee = employeeServiceImpl.selectByPrimaryKey(id);
        System.out.println(employee);
    }

    @Test
    public void testSelectByPhoneNum() {
        List<Employee> employees = employeeServiceImpl.selectByPhoneNum(18821988276L);
        for (Employee employee : employees) {
            System.out.println(employee.getId());
        }

    }
}
