package com.lsm.springboot.domain;

import java.util.Date;

/**
 * Created by lishenming on 2017/4/18.
 */
public class Person {

    private Integer id;

    private String name;

    private Date insertTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", insertTime=" + insertTime +
                '}';
    }
}
