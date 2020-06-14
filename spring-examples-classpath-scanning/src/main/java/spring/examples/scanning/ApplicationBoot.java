package spring.examples.scanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.scanning.x.EnableScanning;
import spring.examples.scanning.x.Name;

import java.util.ArrayList;
import java.util.List;

@EnableScanning
@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired(required = false)
    private List<Name> beans = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (Name name : beans) {
            System.out.println(name);
        }
    }
}
