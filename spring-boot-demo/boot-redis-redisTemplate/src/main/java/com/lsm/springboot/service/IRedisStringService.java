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

    /**
     * 将键存储的值加1，如果key不存在则当作0来处理
     * @param key
     * @return 返回修改后的值
     */
    Long incr(String key);

    /**
     *
     * @param key
     * @param amount 将键存储的值加amount
     * @return
     */
    Long incrBy(String key, long amount);
    /**
     * 将键存储的值减1，如果key不存在则当作0来处理
     * @param key
     * @return 返回修改后的值
     */
    Long decr(String key);
    /**
     *
     * @param key
     * @param amount 将键存储的值减去amount
     * @return
     */
    Long decrBy(String key, long amount);
}
