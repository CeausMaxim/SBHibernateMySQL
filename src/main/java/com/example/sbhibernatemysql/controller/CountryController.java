package com.example.sbhibernatemysql.controller;

import com.example.sbhibernatemysql.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sbhibernatemysql.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        super();
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country) {
        return new ResponseEntity<Country>(countryService.save(country), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Country> get() {
        return countryService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Country> get(@PathVariable("id") long id) {
        return new ResponseEntity<Country>(countryService.get(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Country> update(@PathVariable("id") long id, @RequestBody Country country) {
        return new ResponseEntity<Country>(countryService.update(country, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        countryService.delete(id);
        return new ResponseEntity<String>("Country deleted", HttpStatus.OK);
    }
}
