package com.lsm.springboot.mapper.sharding;

import com.lsm.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Mapper
public interface UserMapper {

    Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);
}
