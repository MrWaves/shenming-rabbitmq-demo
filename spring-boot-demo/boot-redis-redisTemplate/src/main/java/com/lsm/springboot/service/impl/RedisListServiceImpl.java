package com.lsm.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.service.IRedisListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by za-lishenming on 2017/6/2.
 */
@Service
@Slf4j
public class RedisListServiceImpl implements IRedisListService {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public long lPush(final String key, Object obj) {
        final String value = JSONObject.toJSONString(obj);
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
    }

    @Override
    public long rPush(final String key, Object obj) {
        final String value = JSONObject.toJSONString(obj);
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });
    }

    @Override
    public String lPop(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res =  connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
    }

    @Override
    public String rPop(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res =  connection.rPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
    }

    @Override
    public Long lLen(final String key) {
        return redisTemplate.execute( new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return connection.lLen(serializer.serialize(key));
            }
        });
    }

    @Override
    public List<String> lRange (final String key, final long start, final long end) {
        return redisTemplate.execute( new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                List<byte[]> resultBytes = connection.lRange(serializer.serialize(key), start, end);
                if (CollectionUtils.isEmpty(resultBytes)) {
                    return new ArrayList<>();
                }
                List<String> resultList = new ArrayList<>();
                for (byte[] result : resultBytes) {
                    resultList.add(serializer.deserialize(result));
                }
                return resultList;
            }
        });
    }
}
