package spring.examples.webflux.dao;

import spring.examples.webflux.domain.City;

import java.util.List;

public interface CityDao {

    public List<City> findAll();

}
