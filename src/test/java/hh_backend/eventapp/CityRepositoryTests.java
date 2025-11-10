package hh_backend.eventapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import hh_backend.eventapp.domain.City;
import hh_backend.eventapp.domain.CityRepository;

@DataJpaTest
public class CityRepositoryTests {

    @Autowired
    private CityRepository cityRepo;

    @Test
    public void addNewCity() {
        City city = new City("Tampere");
        cityRepo.save(city);
        assertThat(city.getCityId()).isNotNull();
    }

    @Test
    public void deleteCityById() {
        List<City> city = cityRepo.findByName("Tampere");
        Long id = city.get(0).getCityId();
        cityRepo.deleteById(id);
        assertThat(cityRepo.findByName("Tampere")).hasSize(0);
    }

    @Test
    void findAll() {
        Iterable<City> cities = cityRepo.findAll();
        assertThat(cities).hasSize(5);
    }

    @Test
    void findById() {
        List<City> cities = cityRepo.findByName("Tampere");
        Long id = cities.get(0).getCityId();
        Optional<City> foundCity = cityRepo.findById(id);
        assertThat(foundCity).isPresent();
        assertThat(foundCity.get().getName()).isEqualTo("Tampere");
    }

}
