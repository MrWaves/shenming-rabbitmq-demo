package com.lsm.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Created by lishenming on 2017/5/11.
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/home")
    public String home() {
        File file = new File("classpath:dataFile/ZH.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "Hello World!";
    }
}
