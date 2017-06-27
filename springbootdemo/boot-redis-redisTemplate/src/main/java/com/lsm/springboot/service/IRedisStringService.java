package com.lsm.springboot.service;

import java.util.List;

/**
 * Created by za-lishenming on 2017/6/2.
 * redis字符串
 */
public interface IRedisStringService {

    /**
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, String value);

    boolean set(String key, String value, long expireSeconds);

    String get(String key);

    boolean expire(String key,long expire);

    <T> boolean setList(String key ,List<T> list);

    <T> List<T> getList(String key,Class<T> clz);

}
