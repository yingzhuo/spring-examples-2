package spring.examples.mapstruct;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
 * 其实没有必要将Mapper的实例放入ApplicationContext
 * 这里例子放在这里作为参考
 */
@Configuration
@ComponentScan("org.mapstruct.extensions.spring.converter")
public class ApplicationCnfMapstruct {

}
