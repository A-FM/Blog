package pers.ycy.blog.service;

import pers.ycy.blog.domain.User;

public interface LoginService {
    public User login(String loginCode, String plantPassword,int rememberTime);
}
