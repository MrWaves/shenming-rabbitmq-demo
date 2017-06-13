package com.lsm.springboot.service.impl;

import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.User;
import com.lsm.springboot.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lishenming on 2017/4/19.
 */
public class UserServiceImplTest extends BaseTest {
    @Autowired
    private IUserService userServiceImpl;

    @Test
    @Transactional(value = "test2TxManager")
    public void testInsert(){
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("test" + i);
            user.setPhonenum(18621949188L);
            userServiceImpl.insert(user);
        }
        int j = 10 / 0;
        User user = new User();
        user.setName("testtesttest");
        user.setPhonenum(18621949188L);
        userServiceImpl.insert(user);
    }

    @Test
    public void testSelectByPrimaryKey(){
        Long id = 1L;
        User user = userServiceImpl.selectByPrimaryKey(id);
        System.out.println(user);
    }

    @Test
    public void testSelectByPhoneNum() {
        List<User> users = userServiceImpl.selectByPhoneNum(18821988276L);
        for (User user : users) {
            System.out.println(user.getId());
        }

    }
}
