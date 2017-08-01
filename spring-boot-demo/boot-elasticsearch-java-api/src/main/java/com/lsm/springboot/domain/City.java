package com.lsm.springboot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by lishenming on 2017/7/26.
 */
@Data
public class City implements Serializable {

    private static final long serialVersionUID = 4462233294558764413L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 城市评分
     */
    private Integer score;

}
