package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.AdminUser;
import com.lsm.springboot.mapper.test.AdminUserMapper;
import com.lsm.springboot.service.IAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shenming.li on 2017/6/15.
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    public AdminUser selectByName(String userName){

        return adminUserMapper.selectByName(userName);
    }
}
