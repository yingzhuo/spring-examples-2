package spring.examples.retry.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class EchoServiceImpl implements EchoService {

    @Override
    @Retryable(
            value = {UnsupportedOperationException.class},
            maxAttemptsExpression = "${retry.max-attempts}",
            backoff = @Backoff(delayExpression = "${retry.max-delay}")
    )
    public String echo(String input) {
        log.debug("echo ...");
        throw new UnsupportedOperationException();
    }

}
