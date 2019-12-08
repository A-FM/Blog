package pers.ycy.blog.abstractionlayer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @ApiModelProperty(value = "唯一标识码, 数据库自动生成, 如果是修改则需要上传id, 如果是新建的话则不需要上传id, 此处通过id的有无,判断是新建还是修改.")
    private Integer id;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间, 不需要上传后台自动生成")
    private Date createTime;

    @Column(name = "update_time")
    @ApiModelProperty(value = "修改时间, 不需要上传后台自动生成")
    private Date updateTime;
}
