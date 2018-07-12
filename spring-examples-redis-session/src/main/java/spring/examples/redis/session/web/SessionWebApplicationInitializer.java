package spring.examples.redis.session.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Slf4j
public class SessionWebApplicationInitializer extends AbstractHttpSessionApplicationInitializer {

    public SessionWebApplicationInitializer() {
        log.info("{} 初始化", SessionWebApplicationInitializer.class.getName());
    }

}
