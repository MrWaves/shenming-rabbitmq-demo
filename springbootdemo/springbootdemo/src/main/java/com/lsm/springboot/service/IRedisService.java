package com.lsm.springboot.service;

import redis.clients.jedis.Jedis;

/**
 * Created by za-lishenming on 2017/6/2.
 */
public interface IRedisService {

    Jedis getResource();

    void close(Jedis jedis);

    void set(String key, String value);

    void set(String key, String value, int expireTime);

    String get(String key);

    Long del(String key);

    Boolean exists(String key);
}
