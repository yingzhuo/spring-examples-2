package spring.examples.endpoint.actuator;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "project")
public class ProjectEndpoint {

    private static final Map<String, Object> INFO = ImmutableMap.of(
            "name", "demo",
            "version", "1.0.0",
            "author", "应卓");

    @ReadOperation
    public Map<String, Object> all() {
        return INFO;
    }

    @ReadOperation
    public Object prop(@Selector String name) {
        System.out.println("1111");
        return INFO.getOrDefault(name, "");
    }

}
