package spring.examples.rabbitmq;

import com.google.common.collect.ImmutableMap;
import lombok.val;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCnfRabbitmq {

    @Bean
    public Queue queue1() {
        val args = ImmutableMap.<String, Object>of(
                "x-dead-letter-exchange", "",
                "x-dead-letter-routing-key", "q2",
                "x-message-ttl", 5000
        );

        return new Queue("q1", true, false, false, args);
    }

    @Bean
    public Queue queue2() {
        return new Queue("q2", true);
    }

    @Bean
    public Queue queue3() {
        return new Queue("q3", true);
    }

}
