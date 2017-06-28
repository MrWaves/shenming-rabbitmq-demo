package com.lsm.springboot.service;

import com.lsm.springboot.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/28.
 */
public class IRedisSetServiceTest extends BaseTest {
    @Autowired
    private IRedisSetService redisSetServiceImpl;

    @Test
    public void sAdd() {
        Long sAdd = redisSetServiceImpl.sAdd("sAdd", "sAdd1", "sAdd2");
        System.out.println(sAdd);
        Long sAdd2 = redisSetServiceImpl.sAdd("sAdd", "sAdd3", "sAdd2");
        System.out.println(sAdd2);
    }

    @Test
    public void sRem() {
        Long sAdd = redisSetServiceImpl.sAdd("sRem", "sRem1", "sRem2");
        System.out.println(sAdd);
        Long sAdd2 = redisSetServiceImpl.sRem("sRem", "sRem3", "sRem2");
        System.out.println(sAdd2);
    }

    @Test
    public void sIsMember() throws Exception {
        Boolean sIsMember = redisSetServiceImpl.sIsMember("sIsMember", "sIsMember");
        System.out.println(sIsMember);
        redisSetServiceImpl.sAdd("sIsMember", "sIsMember");
        sIsMember = redisSetServiceImpl.sIsMember("sIsMember", "sIsMember");
        System.out.println(sIsMember);
    }

    @Test
    public void sCard() throws Exception {
        System.out.println(redisSetServiceImpl.sCard("sCard"));
        redisSetServiceImpl.sAdd("sCard", "sCard1", "sCard");
        System.out.println(redisSetServiceImpl.sCard("sCard"));
    }

    @Test
    public void sMembers() throws Exception {
        redisSetServiceImpl.sAdd("sMembers", "sMembers1", "sMembers2", "sMembers4", "sMembers3");
        List<String> sMembers = redisSetServiceImpl.sMembers("sMembers");
        System.out.println(sMembers);
    }

    @Test
    public void sDiff() throws Exception {
        redisSetServiceImpl.sAdd("sDiff_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sDiff2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sDiff3_key", "sDiff2", "sDiff22", "sDif32");
        List<String> resultList = redisSetServiceImpl.sDiff("sDiff_key", "sDiff2_key", "sDiff3_key");
        System.out.println(resultList);
    }

    @Test
    public void sDiffStore() throws Exception {
        redisSetServiceImpl.sAdd("sDiffStore1_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sDiffStore2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sDiffStore3_key", "sDiff2", "sDiff22", "sDif32");
        redisSetServiceImpl.sDiffStore("sDiffStore_key", "sDiffStore1_key", "sDiffStore2_key", "sDiffStore3_key");
        List<String> resultList = redisSetServiceImpl.sMembers("sDiffStore_key");
        System.out.println(resultList);
    }

    @Test
    public void sInter() throws Exception {
        redisSetServiceImpl.sAdd("sInter1_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sInter2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sInter3_key", "sDiff1", "sDiff22", "sDif32");
        List<String> resultList = redisSetServiceImpl.sInter("sInter1_key", "sInter2_key", "sInter3_key");
        System.out.println(resultList);
    }

    @Test
    public void sInterStore() throws Exception {
        redisSetServiceImpl.sAdd("sInterStore1_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sInterStore2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sInterStore3_key", "sDiff1", "sDiff22", "sDif32");
        redisSetServiceImpl.sInterStore("sInterStore_key", "sInterStore1_key", "sInterStore2_key", "sInterStore3_key");
        List<String> resultList = redisSetServiceImpl.sMembers("sInterStore_key");
        System.out.println(resultList);
    }

    @Test
    public void sUnion() throws Exception {
        redisSetServiceImpl.sAdd("sUnion1_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sUnion2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sUnion3_key", "sDiff1", "sDiff22", "sDif32");
        List<String> resultList = redisSetServiceImpl.sUnion("sUnion1_key", "sUnion2_key", "sUnion3_key");
        System.out.println(resultList);

    }

    @Test
    public void sUnionStore() throws Exception {
        redisSetServiceImpl.sAdd("sUnionStore1_key", "sDiff1", "sDiff2", "sDif3");
        redisSetServiceImpl.sAdd("sUnionStore2_key", "sDiff1", "sDiff21", "sDif31");
        redisSetServiceImpl.sAdd("sUnionStore3_key", "sDiff1", "sDiff22", "sDif32");
        redisSetServiceImpl.sUnionStore("sUnionStore_key", "sUnionStore1_key", "sUnionStore2_key", "sUnionStore3_key");
        List<String> resultList = redisSetServiceImpl.sMembers("sUnionStore_key");
        System.out.println(resultList);
    }

}
