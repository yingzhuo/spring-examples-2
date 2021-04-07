package spring.examples.ehcache.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

    @Override
    @CacheEvict(allEntries = true,
            cacheNames = {
                    "default"
            })
    public void evictAll() {
        log.debug("清除所有缓存");
    }

}
