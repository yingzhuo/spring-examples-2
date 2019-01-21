package spring.examples.redisson;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import spring.examples.redisson.service.InformationService;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private InformationService informationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        val lock = redissonClient.getLock(Long.parseLong("100000") + "");
//        val locked = lock.tryLock(10, 10, TimeUnit.SECONDS);
//
//        if (locked) {
//            try {
//                System.out.println("临界区代码");
//            } finally {
//                lock.unlock();
//            }
//        } else {
//            throw new IllegalArgumentException("我拿不到锁啊。");
//        }

        informationService.get();
        informationService.get();
    }

}
