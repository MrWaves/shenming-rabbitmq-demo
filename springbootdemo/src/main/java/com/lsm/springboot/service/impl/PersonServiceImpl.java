package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.domain.Person;
import com.lsm.springboot.mapper.test.PersonMapper;
import com.lsm.springboot.mapper.test2.EmployeeMapper;
import com.lsm.springboot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lishenming on 2017/4/18.
 */
@Service
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public int insert(Person person){

        return personMapper.insert(person);
    }

    @Override
    public Person selectById(int id) {

        return personMapper.selectById(id);
    }

    @Transactional(value = "testTxManager")
    @Override
    public void transactionTestFailure() throws IllegalAccessException {
        Person person = new Person();
        person.setName("transactionTest");
        personMapper.insert(person);

        Person person2 = new Person();
        person2.setName("transactionTest2");
        personMapper.insert(person2);

        /*Employee employee = new Employee();
        employee.setName("transactionTest2");
        employee.setPhoneNum(18621989999L);
        employeeMapper.insert(employee);*/

        throw new IllegalAccessException();

    }
}
