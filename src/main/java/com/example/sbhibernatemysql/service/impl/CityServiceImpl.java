package com.example.sbhibernatemysql.service.impl;

import com.example.sbhibernatemysql.exception.ResourceNotFoundException;
import com.example.sbhibernatemysql.model.City;
import com.example.sbhibernatemysql.model.Country;
import com.example.sbhibernatemysql.repository.CityRepository;
import com.example.sbhibernatemysql.repository.CountryRepository;
import com.example.sbhibernatemysql.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    CityRepository cityRepository;

    public CityServiceImpl(CountryRepository countryRepository) {
        super();
        this.cityRepository = cityRepository;
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City get(long id) {
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
    }

    @Override
    public City update(City city, long id) {
        City existingCountry = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
        existingCountry.setName(city.getName());
        cityRepository.save(existingCountry);
        return null;
    }

    @Override
    public void delete(long id) {
        cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City", "id", id));
        cityRepository.deleteById(id);
    }
}
