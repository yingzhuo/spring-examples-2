package spring.examples.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
public class ApplicationCnfKafka {

    @Bean
    public NewTopic topic1() {
        return new NewTopic("test_topic", 15, (short) 1);
    }

}
