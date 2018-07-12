package spring.examples.excel.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import spring.examples.excel.view.mvc.ExcelView;

import java.util.Optional;

@Configuration
@ConditionalOnWebApplication
public class ApplicationCnfMvc implements WebMvcConfigurer {

    @Autowired(required = false)
    public void configBeanNameViewResolver(Optional<BeanNameViewResolver> resolver) {
        resolver.ifPresent(it -> it.setOrder(Ordered.HIGHEST_PRECEDENCE));
    }

    @Bean
    public ExcelView excelView() {
        return new ExcelView();
    }

}
