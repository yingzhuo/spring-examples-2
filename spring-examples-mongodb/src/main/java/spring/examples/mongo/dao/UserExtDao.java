package spring.examples.mongo.dao;

import org.springframework.data.geo.Point;
import spring.examples.mongo.domain.Level;
import spring.examples.mongo.domain.User;

import java.util.List;
import java.util.Set;

interface UserExtDao {

    public List<User> find(Set<String> genderSet, Set<Level> levelSet, Point point, double maxDistance);

}
