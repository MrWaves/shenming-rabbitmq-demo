package com.lsm.springboot.controller;

import com.lsm.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lishenming on 2017/4/18.
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/testTH")
    public String testTH(ModelMap map) {
        map.addAttribute("msg", "Hello, test! @Thymeleaf");
        return "test_th";
    }

    @RequestMapping("/testLEGACYHTML5")
    public String testLEGACYHTML5(ModelMap map) {
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person();
            person.setId(i);
            person.setName("范德萨发撒旦法是的" + i + "xixi");

            personList.add(person);
        }
        Map<String, List<Person>> myMap = new HashMap<>();
        myMap.put("test1", personList);
        myMap.put("test2", personList);
        map.addAttribute("personList", personList);
        map.addAttribute("myMap", myMap);
        return "test_legacyhtml5";
    }

}
