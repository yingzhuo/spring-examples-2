package spring.examples.excel.view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(ApplicationBoot.class);
        application.run(args);
    }

}
