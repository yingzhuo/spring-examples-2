package spring.examples.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerBean {

    private static final String GROUP_ID = "spring-examples";

    @KafkaListener(topics = "test_topic", groupId = GROUP_ID, containerFactory = "kafkaManualAckListenerContainerFactory")
    public void listen(@Payload ConsumerRecord<String, String> record, Acknowledgment ack) {
        log.debug("received message in group {}: {}", GROUP_ID, record.value());
        ack.acknowledge();
//        ack.nack(1000L);
    }

}
