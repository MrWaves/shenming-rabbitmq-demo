package com.lsm.springboot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {
    private Long id;

    private String userName;

    private String passWord;

    private Byte isDeleted;

    private Date updateTime;

    private Date createTime;

}