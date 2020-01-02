package spring.examples.https;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/META-INF/http.properties")
public class ApplicationConfigTomcat {

    @Value("${http.port}")
    private int httpPort;

    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        final TomcatServletWebServerFactory bean = new TomcatServletWebServerFactory();
        bean.addAdditionalTomcatConnectors(connector());
        return bean;
    }

    private Connector connector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");
        connector.setPort(httpPort);
        return connector;
    }

}
