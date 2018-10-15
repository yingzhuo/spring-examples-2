package spring.examples.rabbitmq.helper;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class RabbitUtils implements ApplicationContextAware {

    public static final String DEFAULT_EXCHANGE = "";

    private static ApplicationContext AC;

    public static void send(String routingKey, String message) {
        send(routingKey, message, -1);
    }

    public static void send(String routingKey, String message, long ttl) {
        send(DEFAULT_EXCHANGE, routingKey, message, ttl);
    }

    public static void send(String exchange, String routingKey, String message, long ttl) {
        final AmqpTemplate template = AC.getBean(AmqpTemplate.class);

        final MessageProperties messageProperties = new MessageProperties();

        if (ttl > 0) {
            messageProperties.setExpiration(Long.valueOf(ttl).toString());
        }
        final Message msg = new Message(message.getBytes(StandardCharsets.UTF_8), messageProperties);

        template.send(exchange, routingKey, msg);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitUtils.AC = applicationContext;
    }

}
