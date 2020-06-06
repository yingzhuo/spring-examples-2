package spring.examples.redis;

import com.github.yingzhuo.carnival.redis.lock.RedisLock;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (RedisLock.lock("1000")) {
            System.out.println("拿到锁了，干活");
        } else {
            System.out.println("拿不到锁");
        }

        System.out.println(RedisLock.release("1000"));
    }

}
