package com.lsm.springboot.mapper.test2;

import com.lsm.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    User selectByPrimaryKey(@Param("id") Long id);

    List<User> selectByPhoneNum(@Param("phoneNum") Long phoneNum);

}