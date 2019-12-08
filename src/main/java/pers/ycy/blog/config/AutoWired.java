package pers.ycy.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pers.ycy.blog.utils.BeanValidator;
import pers.ycy.blog.utils.RedisUtils;

import javax.validation.Validator;

/**
 * @author: 袁重阳
 * @description: 自动注入类
 * @create: 2019-12-07 20:02
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-07 20:02
 */
@Configuration
public class AutoWired {

    private final RedisTemplate redisTemplate;
    public AutoWired(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 下面的两个方法都是为了实现JSR-303
     * @return
     */
    private Validator getValidator(){
        return new LocalValidatorFactoryBean();
    }
    @Bean(name="beanValidator")
    public BeanValidator getBeanValidator(){
        return new BeanValidator(getValidator());
    }


    private RedisTemplate<String,Object> getRedisTemplate(){
        return new RedisTemplate<>();
    }
    @Bean(name="redisUtils")
    public RedisUtils getRedisUtils(){
        return new RedisUtils(redisTemplate);
    }
}
