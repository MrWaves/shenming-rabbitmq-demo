package com.lsm.springboot.service;

import com.lsm.springboot.domain.AdminUser;

/**
 * Created by shenming.li on 2017/6/15.
 */
public interface IAdminUserService {

    AdminUser selectByName(String userName);
}
