package spring.examples.ehcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class ApplicationConfigCache {

    @Bean(name = {"cacheKeyGenerator", "kg"})
    public KeyGenerator cacheKeyGenerator() {
        return new SimpleKeyGenerator();
    }

}
