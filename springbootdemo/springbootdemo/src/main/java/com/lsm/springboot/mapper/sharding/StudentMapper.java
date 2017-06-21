package com.lsm.springboot.mapper.sharding;

import com.lsm.springboot.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Mapper
public interface StudentMapper {

    Integer insert(Student s);

    List<Student> findAll();

    List<Student> findByStudentIds(List<Integer> studentIds);
}
