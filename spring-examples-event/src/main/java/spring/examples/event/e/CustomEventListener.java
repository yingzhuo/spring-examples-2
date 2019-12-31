package spring.examples.event.e;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @Async
    @EventListener
    public void onEvent(CustomEvent event) {
        System.out.println(event.getMessage());
    }

}
