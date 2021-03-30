package com.kepf.ordervalidator.redis.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {

    @Value("${redis.hostname}")
    private String HOST_NAME;

    @Value("${redis.port}")
    private int PORT;

    @Value("${redis.username}")
    private String USERNAME;

    @Value("{redis.password}")
    private String PASSWORD;


    @Bean
    public JedisConnectionFactory connectionFactory(){
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("redis-14149.c258.us-east-1-4.ec2.cloud.redislabs.com", 14149);
        config.setUsername("Phelim");
        config.setPassword("Phelim@54");
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
    public ChannelTopic tradingTopic() {
        return new ChannelTopic("Incoming Orders");
    }

}
