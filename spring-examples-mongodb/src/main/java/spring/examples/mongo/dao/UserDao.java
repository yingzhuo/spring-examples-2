package spring.examples.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.examples.mongo.domain.User;

import java.util.List;
import java.util.Set;

public interface UserDao extends MongoRepository<User, Long>, UserExtDao {

    public List<User> findByGender(String gender);

    public List<User> findByGenderIn(Set<String> gender);

}
