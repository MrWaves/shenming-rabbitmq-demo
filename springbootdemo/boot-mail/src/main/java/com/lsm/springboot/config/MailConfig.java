package com.lsm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Created by shenming.li on 2017/6/12.
 */
public class MailConfig {
    private String username;
    private String host;
    private String auth;
    @Bean(name = "JavaMailSender")
    public JavaMailSender getSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername(username);
        javaMailSender.setHost(host);
        javaMailSender.setPort(587);//①
        javaMailSender.setDefaultEncoding("UTF-8");
        Properties props = new Properties();//②
        props.setProperty("mail.smtp.host", host);
        props.setProperty("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("xxxxxx@qq.com",auth);
            }
        });
        javaMailSender.setSession(session);//③
        return javaMailSender;
    }
}
