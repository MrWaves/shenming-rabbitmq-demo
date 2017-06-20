package com.lsm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by lishenming on 2017/4/18.
 */
@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:quartz-scheduled.xml")
public class MyApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }
}
