package com.lsm.springboot.service.impl;

import com.lsm.springboot.config.RabbitMQConfig;
import com.lsm.springboot.service.ISenderService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * Created by lishenming on 2017/6/12.
 */
@Service
public class SenderServiceImpl implements ISenderService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void send(Map<String, String> massage) {

        rabbitTemplate.convertAndSend(RabbitMQConfig.OBJECT_QUEUE_NAME, massage);
    }

    @Override
    public void send(String massage) {

        /**
         *  MessagePostProcessor 可以对message进行处理，如指定编码，设置messageID
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.STRING_QUEUE_NAME, (Object)massage, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setReceivedDelay(1000);
                message.getMessageProperties().setMessageId(UUID.randomUUID().toString());
                return message;
            }
        });
    }

    @Override
    public void sendTopicMassage1() {
        String context = "hi, i am message 1";

        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, RabbitMQConfig.MESSAGE, context);
    }

    @Override
    public void sendTopicMassage2() {
        String context = "hi, i am messages 2";

        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, RabbitMQConfig.MESSAGES, context);
    }

    @Override
    public void sendFanoutMassage() {
        String context = "hi, i am fanout messages";
        // 第二个参数将被忽略
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, RabbitMQConfig.MESSAGES, context);
    }
}
