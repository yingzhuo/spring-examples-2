package spring.examples.redis.cache.service;

import spring.examples.redis.cache.domain.User;

public interface UserService {

    public User findUserById(String id);

    public void deleteUserById(String id);

}
