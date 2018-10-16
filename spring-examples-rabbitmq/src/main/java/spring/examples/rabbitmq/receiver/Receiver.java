package spring.examples.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class Receiver {

    @RabbitListener(queues = "q2")
    public void onMessage(Message message, Channel channel) {
        final String messageContent = new String(message.getBody(), StandardCharsets.UTF_8);
        System.out.println("--- 消息已收到: '" + messageContent + "'");
        sendAck(message, channel);
    }

    private void sendAck(Message message, Channel channel) {
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
