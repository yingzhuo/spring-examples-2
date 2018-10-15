package spring.examples.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import spring.examples.rabbitmq.helper.RabbitConstants;

@Component
public class Receiver {

    @RabbitListener(queues = {RabbitConstants.QUEUE_2})
    public void onMessage(String content) {
        System.out.println("---");
        System.out.println("收到消息");
        System.out.println(content);
        System.out.println("---");
    }

}
