package pers.ycy.blog.service;

import pers.ycy.blog.utils.BaseResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    BaseResult login(HttpServletRequest request, HttpServletResponse response, String loginCode, String plantPassword, int rememberTime);
    BaseResult loginOut(HttpServletRequest request, HttpServletResponse response);
}
