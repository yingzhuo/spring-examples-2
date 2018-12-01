package spring.examples.redis.redisson;

import lombok.val;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        val lock = redissonClient.getLock("lock");

        val isLocked = lock.tryLock(10,1, TimeUnit.SECONDS);

        if (isLocked) {
            System.out.println("work here ...");
        }

        if (isLocked) {
            lock.unlock();
        }
    }

}
