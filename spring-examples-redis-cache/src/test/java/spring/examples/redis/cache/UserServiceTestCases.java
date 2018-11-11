package spring.examples.redis.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.examples.redis.cache.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class UserServiceTestCases {

    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        userService.findUserById("1");
    }

    @Test
    public void test2() {
        userService.deleteUserById("1");
    }

}
