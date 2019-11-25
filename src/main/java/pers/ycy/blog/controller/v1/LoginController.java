package pers.ycy.blog.controller.v1;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.blog.domain.User;
import pers.ycy.blog.service.LoginService;
import pers.ycy.blog.service.RedisService;
import pers.ycy.blog.utils.BaseResult;
import pers.ycy.blog.utils.ConstantUtils;
import pers.ycy.blog.utils.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Api(value = "v1/controller",tags = "登录控制器")
@RestController
@RequestMapping(value = "v1/controller")
public class LoginController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,String loginCode, String password, int rememberTime){
        User user = loginService.login(loginCode, password,rememberTime);
        if(user == null){
            return new BaseResult(BaseResult.LoginCodeORPassWord_Error,"账号或密码错误!");
        }else{
            String token = UUID.randomUUID().toString();
            redisService.put(token,loginCode,rememberTime+1111);
            CookieUtils.setCookie(httpServletRequest,httpServletResponse,ConstantUtils.SESSION_TOKEN,token,rememberTime);
            return new BaseResult(BaseResult.STATUS_SUCCESS,"登录成功");
        }
    }

    @ApiOperation(value = "登出")
    @ApiImplicitParams({})
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        CookieUtils.deleteCookie(httpServletRequest,httpServletResponse,ConstantUtils.SESSION_TOKEN);
        return "ok";
    }
}
