package pers.ycy.blog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog.user")
public class User implements Serializable {
    private static final long serialVersionUID = -7964131534328058386L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 获取主键, 长度为10 , 不为空, 自增, 唯一 
     *
     * @return id - 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键, 长度为10 , 不为空, 自增, 唯一 
     *
     * @param id 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }
}