package com.lsm.springboot.annotation;

import java.lang.annotation.*;

/**
 * Created by za-lishenming on 2017/6/2.
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)

public @interface Cache {
    //注解参数，缓存key前缀
    String prefix() default"";

    int expiredTime() default 1800;

}
