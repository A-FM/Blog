package pers.ycy.blog.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.ycy.blog.domain.User;
import pers.ycy.blog.mapper.UserMapper;
import pers.ycy.blog.service.LoginService;
import pers.ycy.blog.service.RedisService;
import pers.ycy.blog.utils.ConstantUtils;
import pers.ycy.blog.utils.EnCodeAlgorithm;
import pers.ycy.blog.utils.MapperUtils;
import tk.mybatis.mapper.entity.Example;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String loginCode, String plantPassword, int rememberTime) {
        User user = null;
        String json = redisService.get(loginCode);
        /* 缓存中没有该用户登录的信息. */
        if("null".equals(json)){
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo(ConstantUtils.SESSION_USER,loginCode);
            user = userMapper.selectOneByExample(example);
            String password = EnCodeAlgorithm.enCodePassWord(plantPassword);
            /* 如果传过来的密码不为空, 并且和根据loginCode得到的用户的密码一致的话 */
            if(password!=null&&password.equals(user.getPassword())){
                try {
                    redisService.put(loginCode,MapperUtils.obj2json(user),rememberTime);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Json2Pojo失败. 将用户信息放入缓存失败. ");
                }
                return user;
            }
        }
        /* 缓存中有数据的话. */
        else{
            try {
                user = MapperUtils.json2pojo(json, User.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
        return null;
    }
}
