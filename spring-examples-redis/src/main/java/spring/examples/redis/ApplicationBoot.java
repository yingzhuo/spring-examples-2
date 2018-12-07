package spring.examples.redis;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationBoot.class);
        application.run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        val v = redisTemplate.opsForValue().get("yingzhuo");
        System.out.println(v);
    }

}
