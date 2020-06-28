package spring.examples.actuator.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FuckedUpController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping("/fucked-up")
    public String json() {
        AvailabilityChangeEvent.publish(publisher, new Object(), ReadinessState.REFUSING_TRAFFIC);
        return "ok";
    }

}
