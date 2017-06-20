package com.lsm.springboot.service;

import com.lsm.springboot.annotation.Cache;
import com.lsm.springboot.domain.Employee;

import java.util.List;

/**
 * Created by lishenming on 2017/4/19.
 */

public interface IEmployeeService {

    int insert(Employee employee);

    @Cache(prefix = "employeeById")
    Employee selectByPrimaryKey(Long id);

    @Cache(prefix = "employeeByPhoneNum")
    List<Employee> selectByPhoneNum(Long phoneNum);
}
