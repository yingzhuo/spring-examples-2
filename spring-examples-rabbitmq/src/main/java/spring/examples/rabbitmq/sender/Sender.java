package spring.examples.rabbitmq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import spring.examples.rabbitmq.helper.RabbitConstants;

import java.util.UUID;

@Component
public class Sender implements ApplicationRunner {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("---");
        rabbitTemplate.convertAndSend(RabbitConstants.DEFAULT_EXCHANGE, RabbitConstants.QUEUE_1, UUID.randomUUID().toString());
        System.out.println("发送消息成功");
        System.out.println("---");
    }

}
