package spring.examples.redis.cache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import spring.examples.redis.cache.domain.Name;
import spring.examples.redis.cache.domain.User;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(cacheNames = {"users"}, key = "#p0")
    public User findUserById(String id) {
        if (id == null) return null;

        log.info("执行SQL");

        if ("1".equalsIgnoreCase(id)) {
            User user = new User();
            user.setId(id);
            user.setName(Name.of("Bill", "Gates"));
            return user;
        }

        return null;
    }

    @Override
    @CacheEvict(cacheNames = "users", key = "#p0")
    public void deleteUserById(String id) {

    }

}
