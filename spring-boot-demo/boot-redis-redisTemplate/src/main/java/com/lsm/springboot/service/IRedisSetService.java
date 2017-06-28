package com.lsm.springboot.service;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/28.
 * 对集合的操作
 * 集合里的元素是不可重复的
 */
public interface IRedisSetService {
    /**
     * 将一个或多个元素添加到集合里面，并返回添加成功的元素数量
     * @param key
     * @param values
     * @return
     */
    Long sAdd(String key, String... values);

    /**
     * 从集合里面移除一个或多个元素，并返回被移出元素的数量
     * @param key
     * @param values
     * @return
     */
    Long sRem(String key, String... values);

    /**
     * 检查集合里面是否存在元素
     * @param key
     * @param value
     * @return
     */
    Boolean sIsMember(String key, String value);

    /**
     * 返回集合中元素的数量
     * @param key
     * @return
     */
    Long sCard(String key);

    /**
     * 返回集合中的所有元素
     * @param key
     * @return
     */
    List<String> sMembers(String key);

    /**
     * 返回存在第一个集合但是不存在其他集合中的元素---差集运算
     * @param keys
     * @return
     */
    List<String> sDiff(String... keys);

    /**
     * 返回存在第一个集合但是不存在其他集合中的元素并存储到 destKey 里面---差集运算
     * @param destKey
     * @param keys
     * @return
     */
    Long sDiffStore(String destKey, String... keys);

    /**
     * 返回同时存在于所有集合的元素-----交集运算
     * @param keys
     * @return
     */
    List<String> sInter(String... keys);

    /**
     * 返回同时存在于所有集合的元素并存储到 destKey 里面-----交集运算
     * @param destKey
     * @param keys
     * @return
     */
    Long sInterStore(String destKey, String... keys);

    /**
     * 返回至少存在于一个集合的元素-----并集运算
     * @param keys
     * @return
     */
    List<String> sUnion(String... keys);

    /**
     * 返回至少存在于一个集合的元素并存储到 destKey 里面-----并集运算
     * @param destKey
     * @param keys
     * @return
     */
    Long sUnionStore(String destKey, String... keys);
}
