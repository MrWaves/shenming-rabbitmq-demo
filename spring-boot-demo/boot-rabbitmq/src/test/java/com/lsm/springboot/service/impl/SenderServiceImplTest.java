package com.lsm.springboot.service.impl;

import com.lsm.springboot.BaseTest;
import com.lsm.springboot.service.ISenderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishenming on 2017/6/12.
 */
public class SenderServiceImplTest extends BaseTest {
    @Autowired
    private ISenderService senderServiceImpl;

    @Test
    public void testSend(){
        Map<String, String> massage = new HashMap<>();
        massage.put("phoneNum", "18621949186");
        massage.put("name", "lishenming");
        massage.put("id", "1");
        massage.put("date", new Date().toString());

        senderServiceImpl.send(massage);
        /*testSend2();
        testSendTopicMassage1();
        testSendTopicMassage2();
        testSendFanoutMassage();*/
    }

    @Test
    public void testSend2(){
        String massage = "hi, i am MESSAGE 1";

        senderServiceImpl.send(massage);
    }

    @Test
    public void testSendTopicMassage1(){
        senderServiceImpl.sendTopicMassage1();
    }

    @Test
    public void testSendTopicMassage2(){
        senderServiceImpl.sendTopicMassage2();
    }

    @Test
    public void testSendFanoutMassage() {

        senderServiceImpl.sendFanoutMassage();
    }
}
