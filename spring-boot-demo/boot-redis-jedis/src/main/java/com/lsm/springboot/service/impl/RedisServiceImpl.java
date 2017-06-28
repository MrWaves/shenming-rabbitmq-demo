package com.lsm.springboot.service.impl;

import com.lsm.springboot.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by za-lishenming on 2017/6/2.
 */
@Service
@Slf4j
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public Jedis getResource() {
        return jedisPool.getResource();
    }

    @Override
    public void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    @Override
    public void set(String key, String value) {
        set(key, value, -1);
    }

    @Override
    public void set(String key, String value, int expireTime) {
        Jedis jedis=null;
        try{
            jedis = getResource();
            jedis.set(key, value);
            if (expireTime != -1){
                jedis.expire(key, expireTime);
            }
            log.info("Redis set success - " + key + ", value:" + value + ", expireTime: " + expireTime);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis set error: "+ e.getMessage() +" - " + key + ", value:" + value + ", expireTime: " + expireTime);
        }finally{
            close(jedis);
        }
    }

    @Override
    public String get(String key) {
        String result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.get(key);
            log.info("Redis get success - " + key + ", result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis get error: "+ e.getMessage() +" - " + key + ", result:" + result);
        }finally{
            close(jedis);
        }
        return result;
    }

    @Override
    public Long del(String key) {
        Long result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.del(key);
            log.info("Redis del success - " + key + ", result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis del error: "+ e.getMessage() +" - " + key);
        }finally{
            close(jedis);
        }
        return result;
    }

    @Override
    public Boolean exists(String key) {
        Boolean result = null;
        Jedis jedis=null;
        try{
            jedis = getResource();
            result = jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Redis exists error: "+ e.getMessage() +" - " + key);
        }finally{
            close(jedis);
        }
        return result;
    }


}
