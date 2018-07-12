package spring.examples.retry.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberServiceImpl implements NumberService {

    private static final Random RANDOM = new Random();

    @Override
    @Retryable(value = IllegalStateException.class, maxAttempts = 3, backoff = @Backoff(delay = 100L))
    public int getRandomOddInteger() {
        int num = RANDOM.nextInt(100);
        if (num % 2 == 0) throw new IllegalStateException();
        return num;
    }

}
