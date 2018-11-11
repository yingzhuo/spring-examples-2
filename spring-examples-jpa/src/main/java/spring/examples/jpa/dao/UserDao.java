package spring.examples.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.examples.jpa.domain.User;

public interface UserDao extends JpaRepository<User, String> {
}
