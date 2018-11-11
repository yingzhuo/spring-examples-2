package spring.examples.webflux.dao;

import org.springframework.stereotype.Repository;
import spring.examples.webflux.domain.City;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {

    @Override
    public List<City> findAll() {
        return _LazyHolder.DATA;
    }


    private static class _LazyHolder {
        private static final List<City> DATA;
        static {
            List<City> list = new LinkedList<>();
            list.add(new City(1L, "上海", "老子上班的地方"));
            list.add(new City(2L, "杭州", "旅游的好地方"));
            DATA = Collections.unmodifiableList(list);
        }
    }

}
