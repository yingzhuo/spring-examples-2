package spring.examples.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
@EncryptablePropertySource(value = "classpath:/config/secret.properties", ignoreResourceNotFound = false)
class ApplicationConfigJasypt {
}
