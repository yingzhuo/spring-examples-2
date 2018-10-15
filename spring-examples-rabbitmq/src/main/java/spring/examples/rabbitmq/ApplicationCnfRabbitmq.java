package spring.examples.rabbitmq;

import com.google.common.collect.ImmutableMap;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ApplicationCnfRabbitmq {

    @Bean("queue1")
    public Queue queue1() {
        final Map<String, Object> args = ImmutableMap.of(
                "x-dead-letter-exchange", "",
                "x-dead-letter-routing-key", "q2",
                "x-message-ttl", 5000
        );

        return new Queue("q1", false, false, false, args);
    }

    @Bean("queue2")
    public Queue queue2() {
        return new Queue("q2");
    }

}
