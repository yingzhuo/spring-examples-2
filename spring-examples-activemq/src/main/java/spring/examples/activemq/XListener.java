package spring.examples.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class XListener {

    @JmsListener(destination = "x")
    public void onMessage(TextMessage textMessage) throws Exception {
        System.out.println(textMessage.getText());
    }

}
