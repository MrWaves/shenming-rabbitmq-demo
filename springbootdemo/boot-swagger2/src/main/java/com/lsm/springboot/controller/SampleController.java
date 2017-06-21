package com.lsm.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lishenming on 2017/4/3.
 */

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/log")
    @ApiOperation(value = "log测试", response = String.class)
    public String index() {

        // Log a simple message
        log.debug("debug level log");
        log.info("info level log");
        log.warn("warn level log");
        log.error("error level log");

        return "Hello world from Spring Boot!";
    }


}
