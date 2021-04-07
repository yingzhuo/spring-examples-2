package spring.examples.retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.retry.service.EchoService;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private EchoService echoService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        echoService.echo(null);
    }

}
