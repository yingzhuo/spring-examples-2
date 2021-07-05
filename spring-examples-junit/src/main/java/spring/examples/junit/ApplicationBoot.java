package spring.examples.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(ApplicationBoot.class);
        application.run(args);
    }

}
