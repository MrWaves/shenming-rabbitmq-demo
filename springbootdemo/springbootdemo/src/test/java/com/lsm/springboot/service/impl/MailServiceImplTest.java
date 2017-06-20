package com.lsm.springboot.service.impl;

import com.lsm.springboot.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * Created by shenming.li on 2017/6/12.
 */
public class MailServiceImplTest extends BaseTest {
    @Autowired
    private MailServiceImpl mailService;

    private String to = "lishenming8@126.com";

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail(to, "主题：简单邮件", "测试邮件内容");
    }

    @Test
    public void sendHtmlMail() {

        mailService.sendHtmlMail(to, "主题：html邮件", "test");
    }

    @Test
    public void sendAttachmentsMail() {

        mailService.sendAttachmentsMail(to, "主题：带附件的邮件", "有附件，请查收！", "C:\\Users\\shenming.li\\Desktop\\字段说明.xlsx");
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "rscId001";
        mailService.sendInlineResourceMail(to,
                "主题：嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:" + rscId + "\' ></body></html>",
                "C:\\Users\\shenming.li\\Desktop\\1111.png",
                rscId);
    }

    @Test
    public void test() {
        String admin = new Md5PasswordEncoder().encodePassword("admin", null);
        System.out.println(admin);
    }
}
