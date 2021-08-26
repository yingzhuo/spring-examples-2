package spring.examples.mapstruct;

import org.mapstruct.extensions.spring.SpringMapperConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.examples.mapstruct.gen")
@SpringMapperConfig(conversionServiceAdapterPackage = "spring.examples.mapstruct.gen")
public class ApplicationCnfMapstruct {
}
