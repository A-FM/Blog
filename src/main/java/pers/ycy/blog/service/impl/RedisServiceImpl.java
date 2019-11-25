package pers.ycy.blog.service.impl;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import pers.ycy.blog.service.RedisService;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

	private final RedisTemplate redisTemplate;

	public RedisServiceImpl(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void put(String key, Object value, long second) {
		redisTemplate.opsForValue().set(key,value,second, TimeUnit.SECONDS);
	}

	public String get(String key) {
		return String.valueOf(redisTemplate.opsForValue().get(key));
	}
}
