package com.lsm.springboot.service;

import java.util.Map;

/**
 * Created by lishenming on 2017/6/12.
 */
public interface ISenderService {

    void send(Map<String, String> massage);

    void send(String massage);

    void sendTopicMassage1();

    void sendTopicMassage2();

    void sendFanoutMassage();
}
