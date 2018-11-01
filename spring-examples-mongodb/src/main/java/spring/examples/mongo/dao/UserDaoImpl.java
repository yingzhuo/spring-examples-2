package spring.examples.mongo.dao;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import spring.examples.mongo.domain.User;

import java.util.List;

public class UserDaoImpl implements UserExtDao {

    private final MongoTemplate mongoTemplate;

    public UserDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<User> findCircleNear(Point point, double maxDistance) {
        return mongoTemplate.find(new Query(Criteria.where("coordinate").near(point).maxDistance(maxDistance)), User.class);
    }

}
