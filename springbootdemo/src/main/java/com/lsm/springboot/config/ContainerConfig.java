/*
package com.lsm.springboot.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

*/
/**
 * Created by lishenming on 2017/4/18.
 *  修改端口号和web路径
 *  1） src/main/resources/application.properties
 *  2） 通过EmbeddedServletContainerCustomizer
 *  3） 通过EmbeddedServletContainerFactory
 *//*

@Configuration
public class ContainerConfig {

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                // Port Number
                container.setPort(8081);
                // Context Path
                container.setContextPath("/springboot");
                // Session Timeout
                container.setSessionTimeout(30, TimeUnit.MINUTES);
            }
        };
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();

        tomcat.setPort(8081);
        tomcat.setContextPath("/springboot");
        tomcat.setSessionTimeout(30, TimeUnit.MINUTES);


        return tomcat;
    }

}
*/
