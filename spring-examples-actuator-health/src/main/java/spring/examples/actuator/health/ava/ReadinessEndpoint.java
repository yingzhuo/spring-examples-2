package spring.examples.actuator.health.ava;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Map;

@Component
@RestControllerEndpoint(id = "readiness", enableByDefault = true)
public class ReadinessEndpoint {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/open")
    public Map<String, Object> open() {
        val state = ReadinessState.ACCEPTING_TRAFFIC;
        AvailabilityChangeEvent.publish(applicationContext, state);
        return Collections.singletonMap("current", state);
    }

    @GetMapping("/close")
    public Map<String, Object> close() {
        val state = ReadinessState.REFUSING_TRAFFIC;
        AvailabilityChangeEvent.publish(applicationContext, state);
        return Collections.singletonMap("current", state);
    }

}
