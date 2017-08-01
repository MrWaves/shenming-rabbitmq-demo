package com.lsm.springboot.service;

import com.lsm.springboot.domain.City;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by lishenming on 2017/7/26.
 */
public interface ICityService {

    /**
     * 索引文档和更新整个文档
     * @param city
     * @return
     */
    String saveCity(City city) throws ExecutionException, InterruptedException;

    /*void deleteCity(City city);

    void deleteByCityId(Long id);

    List<City> findByDescriptionAndScore(String description, Integer score);

    List<City> findByDescriptionOrScore(String description, Integer score);

    List<City> findByDescription(String description, int pageNumber, int pageSize);

    List<City> findByDescriptionNot(String description, int pageNumber, int pageSize);

    List<City> findByDescriptionLike(String description, int pageNumber, int pageSize);*/
}
