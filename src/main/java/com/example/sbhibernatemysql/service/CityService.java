package com.example.sbhibernatemysql.service;

import com.example.sbhibernatemysql.model.City;

import java.util.List;

public interface CityService {
    City save(City city);

    List<City> getAll();

    City get(long id);

    City update(City city, long id);

    void delete(long id);
}
