package spring.examples.redisson.service;

import com.google.common.collect.Maps;
import lombok.val;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InformationServiceImpl implements InformationService {

    @Override
    @Cacheable(cacheNames = "info")
    public Map<String, Object> get() {
        System.out.println("查询数据");

        val map = Maps.<String, Object>newHashMap();
        map.put("author", "应卓");
        return map;
    }

}
