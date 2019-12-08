package pers.ycy.blog.controller.v1;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pers.ycy.blog.service.UserService;
import pers.ycy.blog.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "登录控制器")
@RestController
@RequestMapping(value = "v1/controller")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "登录")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResult login(HttpServletRequest request,HttpServletResponse response,String loginCode, String password, int rememberTime){
        return userService.login(request,response,loginCode,password,rememberTime);
    }

    @ApiOperation(value = "登出")
    @ApiImplicitParams({})
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public BaseResult logout(HttpServletRequest request, HttpServletResponse response){
        return userService.loginOut(request, response);
    }
}
