package spring.examples.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEncryptableProperties
@EncryptablePropertySources({
        @EncryptablePropertySource(value = "classpath:/config/secret.properties", ignoreResourceNotFound = false)
})
class ApplicationConfigJasypt {
}
