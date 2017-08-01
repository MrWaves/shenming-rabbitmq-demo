package com.lsm.springboot.controller;

import com.lsm.springboot.domain.City;
import com.lsm.springboot.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by lishenming on 2017/7/26.
 */
@RestController
public class CityController {

    @Autowired
    private ICityService cityServiceImpl;

    /**
     * 插入 ES 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public String createCity(@RequestBody City city) throws ExecutionException, InterruptedException {

        return cityServiceImpl.saveCity(city);
    }

    /*@RequestMapping(value = "/api/deleteCity", method = RequestMethod.POST)
    public void deleteCity(@RequestBody City city) {

        cityServiceImpl.deleteCity(city);
    }

    @RequestMapping(value = "/api/deleteByCityId", method = RequestMethod.GET)
    public void deleteByCityId(@RequestParam Long id) {

        cityServiceImpl.deleteByCityId(id);
    }

    *//**
     * AND 语句查询
     *
     * @param description
     * @param score
     * @return
     *//*
    @RequestMapping(value = "/api/city/and/find", method = RequestMethod.GET)
    public List<City> findByDescriptionAndScore(@RequestParam(value = "description") String description,
                                                @RequestParam(value = "score") Integer score) {

        return cityServiceImpl.findByDescriptionAndScore(description, score);
    }

    *//**
     * OR 语句查询
     *
     * @param description
     * @param score
     * @return
     *//*
    @RequestMapping(value = "/api/city/or/find", method = RequestMethod.GET)
    public List<City> findByDescriptionOrScore(@RequestParam(value = "description") String description,
                                               @RequestParam(value = "score") Integer score) {

        return cityServiceImpl.findByDescriptionOrScore(description, score);
    }

    *//**
     * 查询城市描述
     *
     * @param description
     * @return
     *//*
    @RequestMapping(value = "/api/city/description/find", method = RequestMethod.GET)
    public List<City> findByDescription(@RequestParam(value = "description") String description,
                                        @RequestParam(value = "pageNum") int pageNum,
                                        @RequestParam(value = "pageSize") int pageSize) {

        return cityServiceImpl.findByDescription(description, pageNum, pageSize);
    }

    *//**
     * NOT 语句查询
     *
     * @param description
     * @return
     *//*
    @RequestMapping(value = "/api/city/description/not/find", method = RequestMethod.GET)
    public List<City> findByDescriptionNot(@RequestParam(value = "description") String description,
                                           @RequestParam(value = "pageNum") int pageNum,
                                           @RequestParam(value = "pageSize") int pageSize) {

        return cityServiceImpl.findByDescriptionNot(description, pageNum, pageSize);
    }

    *//**
     * LIKE 语句查询
     *
     * @param description
     * @return
     *//*
    @RequestMapping(value = "/api/city/like/find", method = RequestMethod.GET)
    public List<City> findByDescriptionLike(@RequestParam(value = "description") String description,
                                            @RequestParam(value = "pageNum") int pageNum,
                                            @RequestParam(value = "pageSize") int pageSize) {

        return cityServiceImpl.findByDescriptionLike(description, pageNum, pageSize);
    }*/

}
