package spring.examples.rabbitmq.sender;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import spring.examples.rabbitmq.helper.RabbitUtils;

@Component
public class Sender implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        RabbitUtils.send("q1", "你好，世界。", 3000);
        System.out.println("--- 消息发送成功");
    }

}
