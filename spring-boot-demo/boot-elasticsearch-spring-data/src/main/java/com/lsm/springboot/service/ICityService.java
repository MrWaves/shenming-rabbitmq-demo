package com.lsm.springboot.service;

import com.lsm.springboot.domain.City;

import java.util.List;

/**
 * Created by lishenming on 2017/7/26.
 */
public interface ICityService {

    /**
     * 索引文档和更新整个文档
     * @param city
     * @return
     */
    Long saveCity(City city);

    void deleteCity(City city);

    void deleteByCityId(Long id);

    List<City> findByDescriptionAndScore(String description, Integer score);

    List<City> findByDescriptionOrScore(String description, Integer score);

    List<City> findByDescription(String description, int pageNumber, int pageSize);

    List<City> findByDescriptionNot(String description, int pageNumber, int pageSize);

    List<City> findByDescriptionLike(String description, int pageNumber, int pageSize);
}
