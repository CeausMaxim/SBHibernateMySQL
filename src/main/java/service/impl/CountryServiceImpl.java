package service.impl;

import com.example.sbhibernatemysql.exception.ResourceNotFoundException;
import com.example.sbhibernatemysql.model.Country;
import org.springframework.stereotype.Service;
import com.example.sbhibernatemysql.repository.CountryRepository;
import service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        super();
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country get(long id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
    }

    @Override
    public Country update(Country country, long id) {
        Country existingCountry = countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
        existingCountry.setName(country.getName());
        countryRepository.save(existingCountry);
        return null;
    }

    @Override
    public void delete(long id) {
        countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country", "id", id));
        countryRepository.deleteById(id);
    }
}
