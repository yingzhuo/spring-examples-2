package spring.examples.mongo;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Component;
import spring.examples.mongo.dao.UserDao;
import spring.examples.mongo.domain.Coordinate;
import spring.examples.mongo.domain.User;

@Component
public class TestApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MongoTemplate template;



    @Override
    public void run(ApplicationArguments args) {

        template.indexOps(User.class).ensureIndex(new GeospatialIndex("coordinate"));

        val u1 = new User(1L, "应卓", "男", new Coordinate(100D, 100D));
        val u2 = new User(1L, "文晶晶", "女", new Coordinate(1D, 1D));


        userDao.save(u1);
        userDao.save(u2);

        val list = userDao.findCircleNear(new Point(0.99, 0.99), 5);
        list.forEach(System.out::println);
    }

}
