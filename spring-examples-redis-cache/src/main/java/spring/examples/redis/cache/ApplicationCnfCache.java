package spring.examples.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@EnableCaching
@Configuration
public class ApplicationCnfCache {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean(name = {"cacheKeyGenerator", "kg"})
    public KeyGenerator cacheKeyGenerator() {
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

    @Bean
    RedisCacheWriter redisCacheWriter() {
        return RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
    }

    @Bean
    public CacheManager cacheManager() {
        final RedisCacheConfiguration defaults = createConfiguration(Duration.ofSeconds(3600L));

        final Map<String, RedisCacheConfiguration> configs = new HashMap<>();
        configs.put("cacheName", createConfiguration(Duration.ofSeconds(7200L)));

        return new RedisCacheManager(redisCacheWriter(), defaults, configs);
    }

    private RedisCacheConfiguration createConfiguration(Duration ttl) {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Objects.requireNonNull(ttl))
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json())
                );
    }

}
