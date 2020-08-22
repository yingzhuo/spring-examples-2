package spring.examples.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.Collections;

@Configuration
@EnableCaching
@AutoConfigureAfter(ApplicationCnfRedis.class)
public class ApplicationCnfCache extends CachingConfigurerSupport {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            sb.append("#");
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    @Override
    public CacheManager cacheManager() {
        final RedisCacheConfiguration cnf =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofSeconds(3600))
                        .disableCachingNullValues()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));

        final RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
                .RedisCacheManagerBuilder
                .fromConnectionFactory(redisConnectionFactory);

        return builder
                .withInitialCacheConfigurations(Collections.emptyMap()) // 不同的cache-name可以有不同的配置，我这里不需要
                .cacheDefaults(cnf)
                .build();
    }

}
