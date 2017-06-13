package com.lsm.springboot.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.lsm.springboot.BaseTest;
import com.lsm.springboot.domain.Student;
import com.lsm.springboot.domain.User;
import com.lsm.springboot.service.IStudentService;
import com.lsm.springboot.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
public class ShardingJdbcMybatisTest extends BaseTest {

    @Autowired
    public IUserService userServiceImpl;

    @Autowired
    public IStudentService studentServiceImpl;

    @Autowired
    private IdGenerator idGenerator;

    @Test
    public void testUserInsert() {
        for (int i = 100; i < 112; i++) {
            User u = new User();
            u.setId(idGenerator.generateId().longValue());
            u.setUserId(i);
            u.setAge(20 + i);
            u.setName("test" + i);
            Assert.assertEquals(userServiceImpl.insert(u), new Integer(1));
        }
    }

    @Test
    public void testStudentInsert() {
        for (int i = 0; i < 16; i++) {
            Student student = new Student();
            student.setId(idGenerator.generateId().longValue());
            student.setStudentId(i);
            student.setAge(20 + i);
            student.setName("test" + i);
            Assert.assertEquals(studentServiceImpl.insert(student), new Integer(1));
        }
    }

    @Test
    public void testFindAll(){
        List<User> users = userServiceImpl.findAll();
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }

    @Test
    public void testSQLIN(){
        List<User> users = userServiceImpl.findByUserIds(Arrays.asList(2,10,1));
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }

    @Test
    public void testTransactionTestSucess(){
        userServiceImpl.transactionTestSucess();
    }

    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{
        userServiceImpl.transactionTestFailure();
    }
}
