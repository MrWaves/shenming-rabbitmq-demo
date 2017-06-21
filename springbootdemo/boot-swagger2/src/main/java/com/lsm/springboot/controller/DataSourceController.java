package com.lsm.springboot.controller;

import com.lsm.springboot.domain.Employee;
import com.lsm.springboot.domain.Person;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lishenming on 2017/4/18.
 */
@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @ApiOperation(value = "新增人",httpMethod ="POST", response = Person.class)
    @RequestMapping(value = "/insertPerson.json", method = RequestMethod.POST)
    public Person insert(@RequestBody Person person){

        return person;
    }

    @ApiOperation(value = "添加用户",httpMethod ="GET", response = Employee.class,notes = "HelloWorld")
    @RequestMapping(value = "/insertUser.json", method = RequestMethod.GET)
    public Employee insertUser(@RequestParam String name, @RequestParam Long phoneNum){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhoneNum(phoneNum);

        return employee;
    }
}
