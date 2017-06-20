package com.lsm.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer userId;

    private String name;

    private Integer age;

    private Date createTime;
}
