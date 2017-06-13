package com.lsm.springboot.service;

import com.lsm.springboot.domain.User;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
public interface IUserService {

    Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> ids);

    void transactionTestSucess();

    void transactionTestFailure() throws IllegalAccessException;
}
