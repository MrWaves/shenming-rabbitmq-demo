/*
package com.lsm.springboot.controller;

import com.lsm.springboot.domain.User;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * Created by lishenming on 2017/4/21.
 *//*

@RestController
@RequestMapping("/cxf")
public class CxfController {

    @RequestMapping(value = "/selectUser")
    public Employee selectUser(@RequestParam Long userId){
        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        Client client =dcf.createClient("http://localhost:8081/springboot/soap/login?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects= new Object[0];
        try {
            objects = client.invoke("getUser",userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (Employee) objects[0];

    }
}
*/
