package spring.examples.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.examples.mybatis.domain.User;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public User findById(String id) {
        return sqlSession.selectOne("User.findById", id);
    }

}
