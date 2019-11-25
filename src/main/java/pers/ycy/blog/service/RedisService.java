package pers.ycy.blog.service;

public interface RedisService {
	/**
	 *
	 * @param key 键
	 * @param value 值
	 * @param second 超时时间
	 */
	public void put(String key, Object value, long second);
	public String get(String key);
}
