package com.lsm.springboot.aspect;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.annotation.Cache;
import com.lsm.springboot.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by za-lishenming on 2017/6/2.
 */

@Aspect
@Component
@Slf4j
public class CacheAspect {
    @Autowired
    private IRedisService redisServiceImpl;

    @Pointcut("@annotation(com.lsm.springboot.annotation.Cache)")
    public void cache(){}

    @Around("cache()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable{
        MethodSignature ms = (MethodSignature)jp.getSignature();
        Method method = ms.getMethod();
        Cache cache = method.getAnnotation(Cache.class);
        Class<?> returnType = method.getReturnType();
        String prefix = cache.prefix();
        int timeout = cache.expiredTime();
        String cacheKey=prefix;
        Object[] key = jp.getArgs();
        if(key.length>0){
            for(Object param : key){
                if(param != null){
                    cacheKey += "_" + param.toString();
                }
            }
        }
        String resultString = null;
        try{
            resultString = redisServiceImpl.get(cacheKey);
        }catch(Exception e){
            log.warn("get value from redis failed,key:"+cacheKey);
        }
        if(resultString != null){
            if (List.class.isAssignableFrom(returnType)){
                Type genericReturnType = method.getGenericReturnType();
                if(genericReturnType instanceof ParameterizedType){
                    ParameterizedType pt = (ParameterizedType) genericReturnType;
                    Class genericClazz = (Class)pt.getActualTypeArguments()[0];
                    return JSONObject.parseArray(resultString, genericClazz);
                }else{
                    return JSONObject.parseObject(resultString, returnType);
                }
            }else{
                return JSONObject.parseObject(resultString, returnType);
            }

        }
        Object result = jp.proceed();
        if(result != null){
            try{
                redisServiceImpl.set(cacheKey, JSONObject.toJSONString(result),timeout);
            }catch(Exception e){
                log.warn("set value to redis failed,key:"+cacheKey);
            }
        }
        return result;
    }
}
