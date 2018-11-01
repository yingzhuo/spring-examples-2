package spring.examples.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.examples.mongo.domain.User;

public interface UserDao extends MongoRepository<User, Long>, UserExtDao {
}
