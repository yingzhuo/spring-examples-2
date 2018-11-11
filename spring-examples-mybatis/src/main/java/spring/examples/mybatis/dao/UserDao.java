package spring.examples.mybatis.dao;

import spring.examples.mybatis.domain.User;

public interface UserDao {

    public User findById(String id);

}
