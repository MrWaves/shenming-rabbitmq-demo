package com.lsm.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lishenming on 2017/6/12.
 * exchange接收到消息后，就根据消息的key和已经设置的binding，进行消息路由，将消息投递到一个或多个队列里。
 * exchange也有几个类型
 *      完全根据key进行投递的叫做Direct交换机,例如，绑定时设置了routing key为”abc”，那么客户端提交的消息，只有设置了key为”abc”的才会投递到队列
 *      对key进行模式匹配后进行投递的叫做Topic交换机，符号”#”匹配一个或多个词，符号”*”匹配正好一个词。例如”abc.#”匹配”abc.def.ghi”，”abc.*”只匹配”abc.def”
 *      还有一种不需要key的，叫做Fanout交换机，它采取广播模式，一个消息进来时，投递到与该交换机绑定的所有队列
 * RabbitMQ支持消息的持久化,sprintBootMQ默认持久化
 *      exchange持久化，在声明时指定durable => 1
 *      queue持久化，在声明时指定durable => 1
 *      消息持久化，在投递时指定delivery_mode => 2（1是非持久化）
 * 如果exchange和queue都是持久化的，那么它们之间的binding也是持久化的。如果exchange和queue两者之间有一个持久化，一个非持久化，就不允许建立绑定
 */
@Configuration
public class RabbitMQConfig {
    public static final String OBJECT_QUEUE_NAME = "object_queen";

    public static final String STRING_QUEUE_NAME = "string_queen";

    public final static String MESSAGE = "topic.message";

    public final static String MESSAGES = "topic.messages";

    public final static String EXCHANGE = "exchange";

    public final static String FANOUT_EXCHANGE = "fanoutExchange";

    /**
     * Direct是RabbitMQ默认的交换机模式,也是最简单的模式.
     * 即创建消息队列的时候,指定一个BindingKey.
     * 当发送者发送消息的时候,指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.
     * direct 使用mq默认的Exchange
     * @return
     */
    @Bean
    public Queue objectQueue() {
        return new Queue(OBJECT_QUEUE_NAME);
    }

    @Bean
    public Queue stringQueue() {
        return new Queue(STRING_QUEUE_NAME);
    }

    /**
     * topic转发信息主要是依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串),
     * 而当发送消息的时候,只有指定的Key和该模式相匹配的时候,消息才会被发送到该消息队列中
     * @return
     */
    @Bean(name="message")
    public Queue queueMessage() {
        return new Queue(MESSAGE);
    }

    @Bean(name="messages")
    public Queue queueMessages() {
        return new Queue(MESSAGES);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding bindingExchangeMessage(@Qualifier("message") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(@Qualifier("messages") Queue queueMessages, TopicExchange exchange) {
        //*表示一个词,#表示零个或多个词
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    /**
     * Fanout是路由广播的形式,将会把消息发给绑定它的全部队列,即便设置了key,也会被忽略
     * @return
     */
    @Bean(name="Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }


    @Bean(name="Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean(name="Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);//配置广播路由器
    }

    @Bean
    public Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
