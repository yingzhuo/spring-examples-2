package spring.examples.rabbitmq.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class Receiver {

    @RabbitListener(queues = "q2")
    public void onMessage(Message message) {
        final String messageContent = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("--- 消息已收到: '" + messageContent + "'");
    }

}
