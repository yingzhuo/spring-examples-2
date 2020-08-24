package spring.examples.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.examples.jpa.dao.UserDao;
import spring.examples.jpa.domain.User;

@SpringBootTest(classes = ApplicationBoot.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DaoTestCases {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        User user = userDao.findById("1").orElse(null);
        System.out.println(user.getId());
        System.out.println(user.getRole());
    }

}
