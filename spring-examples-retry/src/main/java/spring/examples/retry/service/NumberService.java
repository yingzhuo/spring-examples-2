package spring.examples.retry.service;

import org.springframework.retry.annotation.Retryable;

public interface NumberService {

    public int getRandomOddInteger();

}
