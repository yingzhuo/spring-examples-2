package spring.examples.activemq;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class TestAppRunner implements ApplicationRunner {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public void run(ApplicationArguments args) {
        jmsTemplate.send("x", session -> {
            Message message = session.createTextMessage("1st");
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 7000L);
            return message;
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        jmsTemplate.send("x", session -> {
            Message message = session.createTextMessage("2nd");
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 2000L);
            return message;
        });
    }

}
