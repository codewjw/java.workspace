package cn.tedu.redis.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface RedisDao {
	 String get(String key);
}
