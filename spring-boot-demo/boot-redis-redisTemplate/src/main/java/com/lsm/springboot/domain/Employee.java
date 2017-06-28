package com.lsm.springboot.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Employee implements Serializable{

    private static final long serialVersionUID = 4626386360165928220L;

    private Long id;

    private Long phoneNum;

    private String name;

    private Date createTime;

    public Employee(Long id, Long phoneNum, String name, Date createTime) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.name = name;
        this.createTime = createTime;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phoneNum=" + phoneNum +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}