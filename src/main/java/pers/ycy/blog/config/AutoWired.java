package pers.ycy.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pers.ycy.blog.utils.BeanValidator;
import pers.ycy.blog.utils.RedisUtils;
import sun.plugin2.main.client.PrintBandDescriptor;

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

    private final Validator Validator;
    private final RedisTemplate redisTemplate;
    public AutoWired(RedisTemplate redisTemplate, Validator Validator) {
        this.redisTemplate = redisTemplate;
        this.Validator = Validator;
    }


    @Bean(name="beanValidator")
    public BeanValidator getBeanValidator(){
        return new BeanValidator(Validator);
    }


    @Bean(name="redisUtils")
    public RedisUtils getRedisUtils(){
        return new RedisUtils(redisTemplate);
    }
}
