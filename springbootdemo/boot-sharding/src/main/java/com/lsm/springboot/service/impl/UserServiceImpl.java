package com.lsm.springboot.service.impl;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.lsm.springboot.domain.Student;
import com.lsm.springboot.domain.User;
import com.lsm.springboot.mapper.sharding.StudentMapper;
import com.lsm.springboot.mapper.sharding.UserMapper;
import com.lsm.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public StudentMapper studentMapper;

    @Autowired
    private IdGenerator idGenerator;

    @Override
    public Integer insert(User u) {
        return userMapper.insert(u);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User selectByUserId(Integer userId){

        return userMapper.selectByUserId(userId);
    }

    @Override
    public List<User> findByUserIds(List<Integer> ids) {
        return userMapper.findByUserIds(ids);
    }

    @Transactional(value = "shardingTransactionManager")
    @Override
    public void transactionTestSucess() {
        User u = new User();
        u.setId(idGenerator.generateId().longValue());
        u.setUserId(29);
        u.setAge(25);
        u.setName("war3 1.27");
        userMapper.insert(u);

        Student student = new Student();
        student.setId(idGenerator.generateId().longValue());
        student.setStudentId(22);
        student.setAge(21);
        student.setName("hehe");
        studentMapper.insert(student);
    }

    @Transactional(value = "shardingTransactionManager")
    @Override
    public void transactionTestFailure() throws IllegalAccessException {
        User u = new User();
        u.setId(idGenerator.generateId().longValue());
        u.setUserId(31);
        u.setAge(25);
        u.setName("war3 1.27 good");
        userMapper.insert(u);

        Student student = new Student();
        student.setId(idGenerator.generateId().longValue());
        student.setStudentId(31);
        student.setAge(21);
        student.setName("hehe1");
        studentMapper.insert(student);
        throw new IllegalAccessException();
    }
}
