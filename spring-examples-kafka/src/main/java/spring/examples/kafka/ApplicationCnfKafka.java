package spring.examples.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class ApplicationCnfKafka {

//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        final Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.99.114:9092");
//        return new KafkaAdmin(configs);
//    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("test_topic", 2, (short) 1);
    }

}
