package spring.examples.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import spring.examples.webflux.dao.CityDao;
import spring.examples.webflux.domain.City;

@Component
public class CityHandler {

    @Autowired
    private CityDao cityDao;

    Flux<City> findAll() {
        return Flux.fromIterable(cityDao.findAll());
    }

}
