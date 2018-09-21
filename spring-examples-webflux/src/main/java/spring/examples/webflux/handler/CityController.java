package spring.examples.webflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import spring.examples.webflux.domain.City;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping
    public Flux<City> findAll() {
        Flux<City> result = cityHandler.findAll();
        return result;
    }

}
