package com.lsm.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by lishenming on 2017/4/18.
 */
/*@MapperScan("com.lsm.springboot.mapper")*/
@SpringBootApplication
@EnableScheduling
@ImportResource("classpath:quartz-scheduled.xml")
public class MyApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }
}
