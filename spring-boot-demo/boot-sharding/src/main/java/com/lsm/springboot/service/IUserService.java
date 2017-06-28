package com.lsm.springboot.service;

import com.lsm.springboot.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
public interface IUserService {

    Integer insert(User u);

    List<User> findAll();

    User selectByUserId(Integer userId);

    List<User> findByUserIds(List<Integer> ids);

    @Transactional(value = "shardingTransactionManager")
    void transactionTestSucess();

    @Transactional(value = "shardingTransactionManager")
    void transactionTestFailure() throws IllegalAccessException;
}
