package com.enhinck.demo.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPoolConfig;


@Slf4j
@Configuration
public class RedisConfig {

	@Value("${redis.pool.maxActive}")
	private int maxTotal;
	@Value("${redis.pool.maxIdle}")
	private int maxIdle;
	@Value("${redis.pool.minIdle}")
	private int minIdle;
	@Value("${redis.pool.maxWait}")
	private long maxWaitMillis;
	@Value("${redis.host}")
	private String hostName;
	@Value("${redis.port}")
	private int port;
	@Value("${redis.password}")
	private String password;
	@Value("${redis.timeout}")
	private int timeout;
	@Value("${redis.default.db}")
	private int db;

	@Bean
	public JedisPoolConfig getRedisConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(maxIdle);
		config.setMinIdle(minIdle);
		config.setMaxWaitMillis(maxWaitMillis);
		return config;
	}

	@Bean
	public JedisConnectionFactory getConnectionFactory() {
		RedisStandaloneConfiguration clientConfig = new RedisStandaloneConfiguration();
		clientConfig.setHostName(hostName);
		clientConfig.setPort(port);
		clientConfig.setPassword(RedisPassword.of(password));
		clientConfig.setDatabase(db);
		JedisPoolConfig poolConfig = getRedisConfig();
		JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
		jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout)).usePooling().poolConfig(poolConfig);
		JedisConnectionFactory factory = new JedisConnectionFactory(clientConfig, jedisClientConfiguration.build());

		log.info("JedisConnectionFactory bean init success.");
		return factory;
	}

	@Bean
	public RedisTemplate<?, ?> getRedisTemplate() {

		RedisTemplate<?, ?> template = new RedisTemplate<>();
		RedisSerializer<String> stringSerializer = new StringRedisSerializer();
		template.setEnableTransactionSupport(false);
		template.setEnableDefaultSerializer(false);
		template.setConnectionFactory(getConnectionFactory());
		template.setKeySerializer(stringSerializer);
		template.setValueSerializer(new FastJsonRedisSerializer<>(String.class));
		template.setHashKeySerializer(stringSerializer);
		template.setHashValueSerializer(new FastJsonRedisSerializer<>(String.class));
		return template;
	}

}
