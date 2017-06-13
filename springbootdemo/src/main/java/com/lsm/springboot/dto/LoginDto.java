package com.lsm.springboot.dto;

import java.io.Serializable;

/**
 * Created by lishenming on 2017/4/21.
 */
public class LoginDto implements Serializable{

    private static final long serialVersionUID = -5939599230753662529L;

    private Long userId;

    private String username;

    private Long phoneNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(Long phoneNum) {
        this.phoneNum = phoneNum;
    }
}
