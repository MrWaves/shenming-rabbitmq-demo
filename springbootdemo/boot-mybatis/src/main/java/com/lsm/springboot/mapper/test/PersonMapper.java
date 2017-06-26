package com.lsm.springboot.mapper.test;


import com.lsm.springboot.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    int insert(Person person);

    Person selectById(@Param("id") int id);

    List<Person> selectAll();
}