package com.lsm.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shenming.li on 2017/6/13.
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 8920597824668331209L;

    private Integer id;

    private Integer studentId;

    private String name;

    private Integer age;

    private Date createTime;
}
