package spring.examples.jasypt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBoot {

//    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .environment(new StandardEncryptableEnvironment())
//                .sources(ApplicationBoot.class)
//                .run(args);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

}
