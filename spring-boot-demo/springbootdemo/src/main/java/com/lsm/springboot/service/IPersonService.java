package com.lsm.springboot.service;

import com.lsm.springboot.domain.Person;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lishenming on 2017/4/18.
 */
public interface IPersonService {

    int insert(Person person);

    Person selectById(int id);

    void transactionTestFailure() throws IllegalAccessException;
}
