package com.lsm.springboot.service.impl;

import com.lsm.springboot.annotation.Cache;
import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.mapper.test2.EmployeeMapper;
import com.lsm.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lishenming on 2017/4/19.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int insert(Employee employee){

        return employeeMapper.insert(employee);
    }

    @Override
    @Cache(prefix = "employeeById")
    public Employee selectByPrimaryKey(Long id){

        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    @Cache(prefix = "employeeByPhoneNum")
    public List<Employee> selectByPhoneNum(Long phoneNum){

        return employeeMapper.selectByPhoneNum(phoneNum);
    }
}
