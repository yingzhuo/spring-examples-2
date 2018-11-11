package spring.examples.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableEncryptableProperties
@EncryptablePropertySource({"classpath:/enc.properties"})
public class ApplicationCnfJasypt implements ApplicationRunner {

    @Autowired
    private StringEncryptor stringEncryptor;


    @Value("${enc.password}")
    private String password;


    @Override
    public void run(ApplicationArguments args) {
        log.debug("jasypt-encryption: 'root' => {}", stringEncryptor.encrypt("root"));
        log.debug("password => {}", password);
    }

}
