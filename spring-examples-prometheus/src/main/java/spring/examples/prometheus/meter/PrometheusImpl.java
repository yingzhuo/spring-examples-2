package spring.examples.prometheus.meter;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

@Component
public class PrometheusImpl {

    @Autowired
    private MeterRegistry meterRegistry;

    @PostConstruct
    public void afterPropertiesSet() {
        Assert.notNull(this.meterRegistry, "meterRegistry is null.");
    }

}
