package repository;

import model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public class CountryRepository extends JpaRepository<Country, Long> {
}
