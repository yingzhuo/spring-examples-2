package spring.examples.mongo;

import com.google.common.collect.Sets;
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
import spring.examples.mongo.domain.Level;
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
        userDao.save(new User(1L, "应卓", "男", Level.LEVEL_1, new Coordinate(1D, 1D)));
        userDao.save(new User(2L, "文晶晶", "女", Level.LEVEL_3, new Coordinate(1D, 1D)));

        val list = userDao.find(Sets.newHashSet("男"), null, new Point(1D, 1D), 55);
        list.forEach(System.out::println);
    }

}
