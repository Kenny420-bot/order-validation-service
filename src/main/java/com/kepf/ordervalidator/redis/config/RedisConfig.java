package com.kepf.ordervalidator.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {


    @Bean
    public JedisConnectionFactory connectionFactory(){
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return redisTemplate;
    }

    @Bean
    public ChannelTopic reportingTopic() {
        return new ChannelTopic("report");
    }

    @Bean
    public ChannelTopic tradingTopic() {
        return new ChannelTopic("trade");
    }

}
