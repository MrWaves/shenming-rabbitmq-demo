package com.lsm.springboot.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by shenming.li on 2017/6/8.
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.lsm.springboot.controller.*.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString()
                + "HTTP_METHOD : " + request.getMethod()
                + "IP : " + request.getRemoteAddr()
                + "CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
                + "ARGS : " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        // 处理完请求，返回内容
        log.info("RESPONSE : " + result + "SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "ms");
        return request;
    }

}
