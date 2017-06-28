package com.lsm.springboot.mapper.test;

import com.lsm.springboot.domain.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminUserMapper {

    int insert(AdminUser record);

    AdminUser selectByName(@Param("userName") String userName);
}