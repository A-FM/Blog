package pers.ycy.blog.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: 袁重阳
 * @description: Redis操作工具类
 * @create: 2019-12-06 15:31
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-06 15:31
 */
public class RedisUtils {

    private static RedisTemplate<String,Object> redisTemplate;

    public RedisUtils() {
    }

    public RedisUtils(RedisTemplate<String,Object> redisTemplate) {
        RedisUtils.redisTemplate=redisTemplate;
    }



    /**
     * 带有过期时间的键值对设置
     * @param key 键
     * @param value 值
     * @param second 过期时间(/SECONDS)
     */
    public static void put(String key, Object value, long second) {
        RedisUtils.redisTemplate.opsForValue().set(key,value,second, TimeUnit.SECONDS);
    }

    /**
     * 获取对应键的值
     * @param key 键
     * @return Object对象
     */
    public static Object get(String key) {

        return RedisUtils.redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取当前键的过期时间
     * @param key 键
     * @return 过期时间(/SECONDS)
     */
    public static Long getExpire(String key){
        return RedisUtils.redisTemplate.getExpire(key);
    }

    /**
     * 判断键是否存在
     * @param key 键
     * @return 是否存在
     */
    public static Boolean hasKey(String key){
        return RedisUtils.redisTemplate.hasKey(key);
    }

    /**
     * 设置当前键的过期时间
     * @param key 键
     * @param timeout 过期时间
     * @param unit 单位
     * @return 是否成功
     */
    public static Boolean expire(String key,Long timeout,TimeUnit unit){
        return RedisUtils.redisTemplate.expire(key,timeout,unit);
    }

    /**
     * 设置当前键在 Date时 过期
     * @param key 键
     * @param date Date 类
     * @return 是否成功
     */
    public static Boolean expireAt(String key, Date date){
        return RedisUtils.redisTemplate.expireAt(key,date);
    }

    /**
     * 移除当前键的过期时间, 持久存储该键值对.
     * @param key 键
     * @return 是否成功
     */
    public static Boolean persist(String key){
        return RedisUtils.redisTemplate.persist(key);
    }

    /**
     * 删除给定的 {@code key}
     * @param key 键
     * @return 是否成功
     */
    public static Boolean delete(String key){
        return RedisUtils.redisTemplate.delete(key);
    }

    /**
     * 重命名key键, 只有当 {@code newKey} 不存在的时候.
     * @param oldKey 旧键
     * @param newKey 新键
     * @return 是否成功
     */
    public static Boolean renameIfAbsent(String oldKey,String newKey){
        return RedisUtils.redisTemplate.renameIfAbsent(oldKey,newKey);
    }
}
