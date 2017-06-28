package com.lsm.springboot.service;

import com.lsm.springboot.domain.Person;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lishenming on 2017/4/18.
 */
public interface IPersonService {

    int insert(Person person);

    Person selectById(int id);

    List<Person> selectAll();
}
