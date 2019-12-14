package pers.ycy.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.ycy.blog.utils.BeanValidator;

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

    private final Validator validator;
    public AutoWired(Validator validator) {
        this.validator = validator;
    }

    @Bean(name="beanValidator")
    public BeanValidator getBeanValidator(){
        return new BeanValidator(validator);
    }

}
