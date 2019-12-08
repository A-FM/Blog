package pers.ycy.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import pers.ycy.blog.abstractionLayer.BaseEntity;

import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.user")
public class User extends BaseEntity {

    private static final long serialVersionUID = -7251378058580159362L;
    /**
     * 用户名
     */
    @Length(min = 6,max = 20,message = "用户名长度在 6 - 20 之间")
    private String username;

    /**
     * 密码
     */
    @Length(min=6,max=20,message = "用户密码长度在 6 - 20 之间")
    private String password;

}