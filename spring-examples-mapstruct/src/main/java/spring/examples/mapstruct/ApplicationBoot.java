package spring.examples.mapstruct;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import spring.examples.mapstruct.domain.Car;
import spring.examples.mapstruct.domain.CarVO;

@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    @Autowired
    private ConversionService conversionService;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        val vo = new CarVO("vm", 5, "SEDAN");
        System.out.println(conversionService.convert(vo, Car.class));
    }

}
