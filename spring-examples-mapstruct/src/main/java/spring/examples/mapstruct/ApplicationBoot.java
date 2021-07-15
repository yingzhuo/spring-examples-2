package spring.examples.mapstruct;

import lombok.val;
import org.mapstruct.extensions.spring.converter.ConversionServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.examples.mapstruct.domain.CarVO;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private ConversionServiceAdapter adapter;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        val vo = new CarVO("vm", 5, "SEDAN");
        System.out.println(adapter.mapCarVOToCar(vo));
    }

}
