package spring.examples.groovy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.groovy.service.MathService;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private MathService mathService;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationBoot.class);
        application.run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(mathService.add(1, 2));
    }

}
