package com.example.sbhibernatemysql.repository;

import com.example.sbhibernatemysql.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
