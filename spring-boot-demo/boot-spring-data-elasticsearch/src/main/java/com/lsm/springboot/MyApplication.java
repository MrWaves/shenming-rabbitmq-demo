package com.lsm.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by lishenming on 2017/4/18.
 * 对应的elasticsearch的版本是2.4.5
 */
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) throws Exception {

        SpringApplication.run(MyApplication.class, args);
    }
}
