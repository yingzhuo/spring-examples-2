package spring.examples.rabbitmq.helper;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

@Deprecated
public class TTLMessagePostProcessor implements MessagePostProcessor {

    public static final MessagePostProcessor TTL_5_SECONDS = new TTLMessagePostProcessor(5);

    public static final MessagePostProcessor TTL_1_MINUTE = new TTLMessagePostProcessor(60 * 1000);

    private final Integer ttl;

    private TTLMessagePostProcessor(int ttl) {
        this.ttl = ttl;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        message.getMessageProperties().getHeaders().put("expiration", ttl.toString());
        return message;
    }

}
