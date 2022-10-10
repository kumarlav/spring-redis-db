package com.lk.config;

import com.lk.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * The type Redis config.
 *
 * @author LavKumar
 */
@Configuration
public class RedisConfig {

	/**
	 * Redis connection factory redis connection factory.
	 *
	 * @return the redis connection factory
	 */
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory();
	}

	/**
	 * Redis template redis template.
	 *
	 * @return the redis template
	 */
	@Bean
	public RedisTemplate<String, Person> redisTemplate(){
		RedisTemplate<String, Person> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory());
		return template;
	}
}