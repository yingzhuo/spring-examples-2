package spring.examples.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Configuration
public class ApplicationConfigValidation implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasenames("classpath:config/i18n/messages");
        bean.setDefaultEncoding("UTF-8");
        bean.setDefaultLocale(Locale.CHINA);
        bean.setCacheSeconds(-1);
        return bean;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        final Map<String, String> propertyMap = new HashMap<>();
        propertyMap.put("hibernate.validator.fail_fast", "false");

        final LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        bean.setValidationPropertyMap(propertyMap);
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver() {
        final AcceptHeaderLocaleResolver bean = new AcceptHeaderLocaleResolver();
        bean.setDefaultLocale(Locale.CHINESE);
        bean.setSupportedLocales(Arrays.asList(Locale.CHINESE, Locale.ENGLISH));
        return bean;
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(createLocaleChangeInterceptor()).addPathPatterns("/", "/**");
//    }
//
//    private LocaleChangeInterceptor createLocaleChangeInterceptor() {
//        final LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
//        interceptor.setIgnoreInvalidLocale(true);
//        interceptor.setParamName("lang");
//        return interceptor;
//    }

}
