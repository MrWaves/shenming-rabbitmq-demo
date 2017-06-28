package com.lsm.springboot.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shenming.li on 2017/6/7.
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET,customerResponseMessage())
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lsm.springboot"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("web project quick start")
                .termsOfServiceUrl("web project quick start")
                .contact(new Contact("lishenming", "", "lishenming8@126.com"))
                .version("1.0")
                .build();
    }

    /**
     * 自定义返回信息
     * @param
     * @return
     */
    private List<ResponseMessage> customerResponseMessage(){
        return Arrays.asList(
                new ResponseMessageBuilder()//500
                        .code(500)
                        .message("服务器异常")
                        .responseModel(new ModelRef("Error"))
                        .build(),
                new ResponseMessageBuilder()//401
                        .code(401)
                        .message("Unauthorized")
                        .build(),
                new ResponseMessageBuilder()//403
                        .code(403)
                        .message("Forbidden")
                        .build(),
                new ResponseMessageBuilder()//404
                        .code(404)
                        .message("Not Found")
                        .build());
    }
}
