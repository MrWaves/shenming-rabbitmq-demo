package com.lsm.springboot.service.impl;

import com.lsm.springboot.service.IRedisSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by shenming.li on 2017/6/28.
 */
@Service
public class RedisSetServiceImpl implements IRedisSetService{
    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    @Override
    public Long sAdd(final String key, final String... values) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = values.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(values[i]);
                }
                return connection.sAdd(serializer.serialize(key), bytes);
            }
        });
    }

    @Override
    public Long sRem(final String key, final String... values) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = values.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(values[i]);
                }
                return connection.sRem(serializer.serialize(key), bytes);
            }
        });
    }

    @Override
    public Boolean sIsMember(final String key, final String value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return connection.sIsMember(serializer.serialize(key), serializer.serialize(value));
            }
        });
    }

    @Override
    public Long sCard(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                return connection.sCard(serializer.serialize(key));
            }
        });
    }

    @Override
    public List<String> sMembers(final String key) {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                Set<byte[]> bytesSet = connection.sMembers(serializer.serialize(key));
                List<String> resultList = new ArrayList<>();
                for (byte[] bytes : bytesSet) {
                    resultList.add(serializer.deserialize(bytes));
                }
                return resultList;
            }
        });
    }

    @Override
    public List<String> sDiff(final String... keys) {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                Set<byte[]> bytesSet = connection.sDiff(bytes);
                List<String> resultList = new ArrayList<>();
                for (byte[] bytes1 : bytesSet) {
                    resultList.add(serializer.deserialize(bytes1));
                }
                return resultList;
            }
        });
    }

    @Override
    public Long sDiffStore(final String destKey, final String... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                return connection.sDiffStore(serializer.serialize(destKey), bytes);
            }
        });
    }

    @Override
    public List<String> sInter(final String... keys) {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                Set<byte[]> bytesSet = connection.sInter(bytes);
                List<String> resultList = new ArrayList<>();
                for (byte[] bytes1 : bytesSet) {
                    resultList.add(serializer.deserialize(bytes1));
                }
                return resultList;
            }
        });
    }

    @Override
    public Long sInterStore(final String destKey, final String... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                return connection.sInterStore(serializer.serialize(destKey), bytes);
            }
        });
    }

    @Override
    public List<String> sUnion(final String... keys) {
        return redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                Set<byte[]> bytesSet = connection.sUnion(bytes);
                List<String> resultList = new ArrayList<>();
                for (byte[] bytes1 : bytesSet) {
                    resultList.add(serializer.deserialize(bytes1));
                }
                return resultList;
            }
        });
    }

    @Override
    public Long sUnionStore(final String destKey, final String... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                int length = keys.length;
                byte[][] bytes = new byte[length][];
                for (int i = 0; i < length; i++) {
                    bytes[i] = serializer.serialize(keys[i]);
                }
                return connection.sUnionStore(serializer.serialize(destKey), bytes);
            }
        });
    }
}
