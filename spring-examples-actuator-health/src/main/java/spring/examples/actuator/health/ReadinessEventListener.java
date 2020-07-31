package spring.examples.actuator.health;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReadinessEventListener {

    @EventListener
    public void onEvent(AvailabilityChangeEvent<ReadinessState> event) {
        log.warn("changed => {}", event.getState());
    }

}
