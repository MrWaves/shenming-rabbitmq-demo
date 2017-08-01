package com.lsm.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lsm.springboot.domain.City;
import com.lsm.springboot.service.ICityService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by lishenming on 2017/7/26.
 */
@Service
@Slf4j
public class CityESServiceImpl implements ICityService {

    // ES 操作类
    @Autowired
    TransportClient client;

    @Override
    public String saveCity(City city) throws ExecutionException, InterruptedException {

        IndexRequest indexRequest = new IndexRequest("index", "type", city.getId() + "").source(JSONObject.toJSONString(city), XContentType.JSON);

        IndexResponse response = client.index(indexRequest).get();

        System.out.println(response);

        return response.getIndex();
    }

    /*@Override
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
    }*/

}
