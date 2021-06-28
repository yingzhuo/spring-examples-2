package spring.examples.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.async.bean.AsyncTask;

@RestController
@SpringBootApplication
public class ApplicationBoot {

    @Autowired
    private AsyncTask asyncTask;

    public static void main(String[] args) {
        final SpringApplication application = new SpringApplication(ApplicationBoot.class);
        application.run(args);
    }

    @GetMapping("hello")
    public String hello() {
        asyncTask.doTask();
        return "ok";
    }

}
