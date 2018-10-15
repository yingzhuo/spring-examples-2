package spring.examples.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ApplicationCnfRabbitmq {

    @Bean
    public Queue helloQueue() {
        return new Queue("spring-examples");
    }

}
