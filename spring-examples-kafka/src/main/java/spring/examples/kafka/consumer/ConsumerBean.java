package spring.examples.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerBean {

    @KafkaListener(topics = "test_topic", groupId = "group1")
    public void listen(String message) {
        System.out.println("Received message in group group1: " + message);
    }

}
