package com.lsm.springboot.service;

import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.dto.LoginDto;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by lishenming on 2017/4/21.
 */
@WebService
public interface ILoginService {
    @WebMethod
    Employee getUser(long userId);

    @WebMethod
    long insertUser(LoginDto loginDto);
}
