package spring.examples.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class RedisTemplateTestCases {

    @Autowired
    private RedisTemplate<String, Object> template;

    @Test
    public void test1() {
        Assert.assertNotNull(template);
    }

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", "应卓");
        map.put("password", "12345");
        map.put("age", 36);
        template.opsForValue().set("key", map, 1, TimeUnit.HOURS);
        Map<String, Object> cached = (Map<String, Object>) template.opsForValue().get("key");
        Assert.assertNotNull(cached);

        template.delete(Collections.singletonList("key"));
        cached = (Map<String, Object>) template.opsForValue().get("key");
        Assert.assertNull(cached);
    }

}
