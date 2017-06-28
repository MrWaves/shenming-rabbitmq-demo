package com.lsm.springboot.listener;

import com.lsm.springboot.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by lishenming on 2017/6/12.
 */
@Component
public class ReceiverListener {

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.OBJECT_QUEUE_NAME, containerFactory="rabbitListenerContainerFactory")
    public void processObject(Map<String, String> message) {

        System.out.println("Receiver object : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.STRING_QUEUE_NAME, containerFactory="rabbitListenerContainerFactory")
    public void processString(String message) {

        System.out.println("Receiver string : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.MESSAGE, containerFactory="rabbitListenerContainerFactory")
    public void processTopicMassage(String message) {

        System.out.println("Receiver topic massage : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitMQConfig.MESSAGES, containerFactory="rabbitListenerContainerFactory")
    public void processTopicMassages(String message) {

        System.out.println("Receiver topic massages : " + message);
    }

    @RabbitListener(queues = "fanout.A", containerFactory="rabbitListenerContainerFactory")
    public void processFanoutA(String message) {

        System.out.println("fanout.A Receiver : " + message);
    }

    @RabbitListener(queues = "fanout.B", containerFactory="rabbitListenerContainerFactory")
    public void processFanoutB(String message) {

        System.out.println("fanout.B Receiver : " + message);
    }

    @RabbitListener(queues = "fanout.C", containerFactory="rabbitListenerContainerFactory")
    public void processFanoutC(String message) {

        System.out.println("fanout.C Receiver : " + message);
    }
}
