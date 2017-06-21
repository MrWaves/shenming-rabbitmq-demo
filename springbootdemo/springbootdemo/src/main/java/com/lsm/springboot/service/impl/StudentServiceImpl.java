package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.Student;
import com.lsm.springboot.mapper.sharding.StudentMapper;
import com.lsm.springboot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    public StudentMapper studentMapper;

    @Override
    public Integer insert(Student student) {

        return studentMapper.insert(student);
    }
}
