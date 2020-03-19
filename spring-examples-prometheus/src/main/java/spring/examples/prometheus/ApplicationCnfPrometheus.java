package spring.examples.prometheus;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterFilter;
import lombok.val;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationCnfPrometheus {

    private static final String ACTUATOR_BASE_PATH = "/actuator";

    @Bean
    public TimedAspect timedAspect() {
        return new TimedAspect();
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> meterRegistryCustomizer() {
        return it -> it.config()
                .commonTags("app", "spring-examples")
                .commonTags("tier", "core")
                .meterFilter(MeterFilter.deny(id -> {
                    val uri = id.getTag("uri");
                    return uri != null && uri.startsWith(ACTUATOR_BASE_PATH);
                }))
                .meterFilter(MeterFilter.deny(id -> {
                    val uri = id.getTag("uri");
                    return uri != null && uri.contains("favicon");
                }));
    }

}
