package spring.examples.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class ApplicationConfigValidation implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasenames("classpath:config/i18n/messages");
        bean.setDefaultEncoding("UTF-8");
        bean.setDefaultLocale(Locale.CHINA);
        bean.setCacheSeconds(600);
        return bean;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
        final LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createLocaleChangeInterceptor()).addPathPatterns("/", "/**");
    }

    private LocaleChangeInterceptor createLocaleChangeInterceptor() {
        final LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setIgnoreInvalidLocale(true);
        interceptor.setParamName("lang");
        return interceptor;
    }

}
