package pers.ycy.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.ycy.blog.domain.User;
import pers.ycy.blog.mapper.UserMapper;
import pers.ycy.blog.service.UserService;
import pers.ycy.blog.utils.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public BaseResult login(HttpServletRequest request, HttpServletResponse response, String loginCode, String plantPassword, int rememberTime) {
        User user = (User) RedisUtils.get(loginCode);
        // 用户没有登录的时候
        if (user == null) {
            User record = new User();
            record.setUsername(loginCode);
            user = userMapper.selectOne(record);
            String enCodePassWord = EnCodeAlgorithm.enCodePassWord(plantPassword);
            // 密码校验成功 将用户信息放置到redis中, 并利用Cookie做用户登录持久化.
            if (user != null && StringUtils.isNotBlank(enCodePassWord) && enCodePassWord.equals(user.getPassword())) {
                String uuid = UUID.randomUUID().toString();
                RedisUtils.put(uuid, user, rememberTime);
                CookieUtils.setCookie(request, response, ConstantUtils.SESSION_TOKEN, uuid, rememberTime);
            } else {
                return new BaseResult(BaseResult.STATUS_ERROR_PARAM, "账号或密码错误");
            }
        }
        return new BaseResult(200, "OK");
    }

    @Override
    public BaseResult loginOut(HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = CookieUtils.getCookieValue(request, ConstantUtils.SESSION_TOKEN);
        RedisUtils.delete(cookieValue);
        CookieUtils.deleteCookie(request, response, ConstantUtils.SESSION_TOKEN);
        return new BaseResult(BaseResult.STATUS_SUCCESS, "OK");
    }
}
