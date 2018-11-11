package spring.examples.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.examples.jpa.dao.UserDao;
import spring.examples.jpa.domain.User;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class DaoTestCases {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        Optional<User> uop = userDao.findById("1");
        System.out.println(uop);
    }

}
