package com.lsm.springboot.controller;

import com.lsm.springboot.domain.Person;
import com.lsm.springboot.service.IPersonService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lishenming on 2017/4/18.
 */
@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoController {

    @Autowired
    private IPersonService personServiceImpl;


    @RequestMapping(value = "/insertPerson.json", method = RequestMethod.POST)
    public Person insert(@RequestBody Person person){

        personServiceImpl.insert(person);

        return personServiceImpl.selectById(person.getId());
    }

    @RequestMapping("/log")
    public String index() {

        // Log a simple message
        log.debug("debug level log");
        log.info("info level log");
        log.warn("warn level log");
        log.error("error level log");

        return "Hello world from Spring Boot!";
    }

}
