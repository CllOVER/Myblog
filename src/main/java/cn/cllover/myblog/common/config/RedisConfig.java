package cn.cllover.myblog.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.net.UnknownHostException;


@Configuration
public class RedisConfig {


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        //注入数据源
        template.setConnectionFactory(redisConnectionFactory);
        //使用jackson序列化方式
        //springboot中默认的序列化方式是java的的jdk序列化方式
        //进行json 序列化操作
        Jackson2JsonRedisSerializer Jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //String序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //对获取的数据源进行相关序列化操作
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(Jackson2JsonRedisSerializer);

        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(Jackson2JsonRedisSerializer);
        //更改默认配置
        template.afterPropertiesSet();
        return template;
    }
}
