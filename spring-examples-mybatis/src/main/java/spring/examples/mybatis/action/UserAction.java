package spring.examples.mybatis.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.mybatis.dao.UserDao;
import spring.examples.mybatis.domain.User;

@RestController
@RequestMapping("user")
public class UserAction {

    @Autowired
    private UserDao userDao;

    @GetMapping("{id}")
    public User findOne(@PathVariable("id") String id) {
        return userDao.findById(id);
    }

}
