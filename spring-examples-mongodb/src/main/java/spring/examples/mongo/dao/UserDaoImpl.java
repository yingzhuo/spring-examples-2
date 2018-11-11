package spring.examples.mongo.dao;

import com.google.common.collect.Sets;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import spring.examples.mongo.domain.Level;
import spring.examples.mongo.domain.User;

import java.util.List;
import java.util.Set;

public class UserDaoImpl implements UserExtDao {

    private static final Set<String> ALL_GENDERS = Sets.newHashSet("男", "女");

    private static final Set<Level> ALL_LEVELS = Sets.newHashSet(Level.LEVEL_1, Level.LEVEL_2, Level.LEVEL_3);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> find(Set<String> genderSet, Set<Level> levelSet, Point point, int maxDistanceInKilometres) {

        if (genderSet == null || genderSet.isEmpty()) {
            genderSet = ALL_GENDERS;
        }

        if (levelSet == null || levelSet.isEmpty()) {
            levelSet = ALL_LEVELS;
        }

        val md = (double) maxDistanceInKilometres / 111.2;
        val c = Criteria
                .where("gender").in(genderSet)
                .and("level").in(levelSet)
                .and("coordinate").near(point).maxDistance(md);

        val q = new Query(c);

        return mongoTemplate.find(q, User.class);
    }

}
