package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.dto.LoginDto;
import com.lsm.springboot.service.ILoginService;
import com.lsm.springboot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by lishenming on 2017/4/21.
 */

@WebService(targetNamespace="http://service.springboot.lsm.com/",endpointInterface = "com.lsm.springboot.service.ILoginService")
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private IEmployeeService userServiceImpl;

    @Override
    public Employee getUser(long userId) {

        return userServiceImpl.selectByPrimaryKey(userId);
    }

    @Override
    public long insertUser(LoginDto loginDto) {
        Employee employee = new Employee();
        employee.setName(loginDto.getUsername());
        employee.setPhoneNum(loginDto.getPhoneNum());

        userServiceImpl.insert(employee);

        return employee.getId();
    }
}
