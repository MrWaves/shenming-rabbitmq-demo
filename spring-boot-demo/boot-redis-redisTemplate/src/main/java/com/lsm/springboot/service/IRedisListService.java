package com.lsm.springboot.service;

import java.util.List;

/**
 * Created by za-lishenming on 2017/6/2.
 * 对列表的操作
 * lPush, rPush, lPop, rPop, lLen, lRange
 * http://irfen.me/redis-learn-5-simple-command-list/
 */
public interface IRedisListService {


    /**
     * 向列表左边添加元素
     * @param key
     * @param obj
     * @return list的长度
     */
    long lPush(String key, Object obj);

    /**
     * 向列表右边添加元素
     * @param key
     * @param obj
     * @return 列表的长度
     */
    long rPush(String key, Object obj);

    /**
     * 从左弹出
     * @param key
     * @return 弹出的值
     */
    String lPop(String key);

    /**
     * 从右弹出
     * @param key
     * @return 弹出的值
     */
    String rPop(String key);

    /**
     * 获取列表中元素的个数
     * @param key
     * @return 列表中元素的个数, 当键不存在是返回0
     */
    Long lLen(String key);

    /**
     * 获取列表片段, 是个闭区间
     * 支持负值索引，这里是负值大家可以把负号加值直接理解成从从右数第多少个
     * 如果start索引比stop索引位置靠后（这里说的是位置，不是索引值的大小），则会返回空列表(empty list or set)
     * 如果stop大于实际的索引范围，则会返回列表最后边的元素
     * @param key
     * @param start 从0开始
     * @param end 从0开始
     * @return
     */
    List<String> lRange(String key, long start, long end);

    /**
     * 从 sourceKey 列表中弹出位于最左端的元素，然后将这个元素推入 destKey 列表的最左端，并返回这个元素
     * @param sourceKey
     * @param destKey
     * @return
     */
    String rPopLPush(String sourceKey, String destKey);
}
