package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.Person;
import com.lsm.springboot.mapper.test.PersonMapper;
import com.lsm.springboot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lishenming on 2017/4/18.
 */
@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private PersonMapper personMapper;

    @Override
    public int insert(Person person){

        return personMapper.insert(person);
    }

    @Override
    public Person selectById(int id) {

        return personMapper.selectById(id);
    }

    @Override
    public List<Person> selectAll() {

        return personMapper.selectAll();
    }

    @Override
    public List<Person> selectByTable( String tableName){

        return personMapper.selectByTable(tableName);
    }

}
