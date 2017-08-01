package com.lsm.springboot.service.impl;

import com.lsm.springboot.domain.City;
import com.lsm.springboot.repository.CityRepository;
import com.lsm.springboot.service.ICityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lishenming on 2017/7/26.
 */
@Service
@Slf4j
public class CityESServiceImpl implements ICityService {

    // ES 操作类
    @Autowired
    CityRepository cityRepository;

    @Override
    public Long saveCity(City city) {
        City cityResult = cityRepository.save(city);

       log.info("cityResult:{}", cityResult.toString());

        return cityResult.getId();
    }

    @Override
    public void deleteCity(City city) {

        cityRepository.delete(city);
    }

    @Override
    public void deleteByCityId(Long id) {

        cityRepository.delete(id);
    }


    @Override
    public List<City> findByDescriptionAndScore(String description, Integer score) {
        return cityRepository.findByDescriptionAndScore(description, score);
    }

    @Override
    public List<City> findByDescriptionOrScore(String description, Integer score) {
        return cityRepository.findByDescriptionOrScore(description, score);
    }

    @Override
    public List<City> findByDescription(String description, int pageNumber, int pageSize) {

        Pageable pageable = new PageRequest(pageNumber, pageSize);

        return cityRepository.findByDescription(description, pageable).getContent();
    }

    @Override
    public List<City> findByDescriptionNot(String description, int pageNumber, int pageSize) {

        Pageable pageable = new PageRequest(pageNumber, pageSize);

        return cityRepository.findByDescriptionNot(description, pageable).getContent();
    }

    @Override
    public List<City> findByDescriptionLike(String description, int pageNumber, int pageSize) {

        Pageable pageable = new PageRequest(pageNumber, pageSize);

        return cityRepository.findByDescriptionLike(description, pageable).getContent();
    }

}
