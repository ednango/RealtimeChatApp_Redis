package com.doancuoimon.realtimechat.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.time.Duration;

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer<String> valueSerializer = new Jackson2JsonRedisSerializer<>(String.class);

        template.setValueSerializer(valueSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration defaultConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10))
                .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(defaultConfig)
                .transactionAware()
                .withInitialCacheConfigurations(java.util.Map.of(
                        "chatrooms", RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(15))
                                .disableCachingNullValues(),
                        "messages", RedisCacheConfiguration.defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(5))
                                .disableCachingNullValues()
                ))
                .build();
    }
}
