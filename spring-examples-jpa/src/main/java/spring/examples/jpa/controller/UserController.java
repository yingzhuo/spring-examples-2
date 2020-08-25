package spring.examples.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.examples.jpa.dao.UserDao;
import spring.examples.jpa.domain.User;

@RestController
class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    User findById(@RequestParam(name = "userId", required = false, defaultValue = "1") String userId) {
        return userDao.findById(userId).orElse(null);
    }

}
