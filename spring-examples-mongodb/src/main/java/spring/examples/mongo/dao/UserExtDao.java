package spring.examples.mongo.dao;

import org.springframework.data.geo.Point;
import spring.examples.mongo.domain.User;

import java.util.List;

interface UserExtDao {

    public List<User> findCircleNear(Point point, double maxDistance);

}
