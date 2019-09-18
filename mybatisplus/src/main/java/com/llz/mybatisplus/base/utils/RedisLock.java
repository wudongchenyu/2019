package com.llz.mybatisplus.base.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.mysql.cj.util.StringUtils;

@Component
public class RedisLock {
	
	private static final String PREX = "REDISLOCK_";
	
	private @Autowired StringRedisTemplate redisTemplate;
	
	private long timeout = 3000;
	
	/** * 加锁 * * @auther itw_lilz * @date @time 2019年8月15日上午11:05:39 * @param key * @return */ 
	public boolean lock(String key) { 
		key = PREX + key; 
		long currentTime = System.currentTimeMillis(); 
		// 直接加锁 
		Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(currentTime)); 
		if (absent) { return true; } 
		// 加锁不成功，获取锁的值 
		String keyTime = redisTemplate.boundValueOps(key).get(); 
		// 判断有没有值，没值则加锁 
		if (StringUtils.isEmptyOrWhitespaceOnly(keyTime)) { 
			if (redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(currentTime))) { 
				return true; 
			} else { 
				return false;
			} 
		} 
		// 判断但前时间与锁的时间相差是否大于超时时间 
		if (currentTime - Long.parseLong(keyTime) > timeout) { 
			// 大于则删除锁 
			redisTemplate.delete(key); 
			// 重新加锁 
			if (redisTemplate.opsForValue().setIfAbsent(key, String.valueOf(currentTime))) { 
				return true; 
			} 
		} 
		return false; 
	}
	

/** * 解锁 * * @auther itw_lilz * @date @time 2019年8月15日上午11:05:16 * @param key */ 
	public void unlock(String key) {
		key = PREX + key;
		redisTemplate.delete(key);
	} 

}
