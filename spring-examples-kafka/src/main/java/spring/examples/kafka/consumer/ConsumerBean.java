package spring.examples.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerBean {

    private static final String GROUP_ID = "spring-examples";

    @KafkaListener(topics = "test_topic", groupId = GROUP_ID)
    public void listen(String message) {
        log.debug("received message in group {}: {}", GROUP_ID, message);
    }

}
