package spring.examples.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import spring.examples.mybatis.dao.UserDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class DaoTestCases {

    @Autowired
    private UserDao userDao;

    @Test
    public void test1() {
        userDao.findById("1");
    }

}
