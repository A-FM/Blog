package pers.ycy.blog.abstractionLayer;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: 袁重阳
 * @description: 抽象实体类
 * @create: 2019-12-08 01:44
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-08 01:44
 */
@Data
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 7372332241293244447L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Past
    @Column(name = "create_time")
    private Date createTime;

    @Past
    @Column(name = "update_time")
    private Date updateTime;
}
