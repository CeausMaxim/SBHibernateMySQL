package com.example.sbhibernatemysql.service;

import com.example.sbhibernatemysql.model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);

    List<Country> getAll();

    Country get(long id);

    Country update(Country country, long id);

    void delete(long id);
}
