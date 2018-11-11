package spring.examples.redis.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.redis.session.web.SessionWebApplicationInitializer;

@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationBoot.class, SessionWebApplicationInitializer.class);
        application.run(args);
    }

}
