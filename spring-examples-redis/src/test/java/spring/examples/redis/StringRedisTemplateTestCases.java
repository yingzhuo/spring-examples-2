package spring.examples.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class StringRedisTemplateTestCases {

    @Autowired
    private StringRedisTemplate template;

    @Test
    public void test1() {
        Assert.assertNotNull(template);
    }

    @Test
    public void test2() {
        template.opsForValue().set("key", "value");

        String value = template.opsForValue().get("key");
        Assert.assertEquals("value", value);

        template.delete("key");

        value = template.opsForValue().get("key");
        Assert.assertNull(value);
    }

}
