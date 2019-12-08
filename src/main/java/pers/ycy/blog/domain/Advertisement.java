package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author: 袁重阳
 * @description: 每月文章数量
 * @create: 2019-11-26 18:27
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-11-26 18:27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.advertisement")
public class Advertisement extends BaseEntity {

    private static final long serialVersionUID = -2844623727241651391L;
    /**
     * 广告标题
     */
    @Length(min = 5,max = 20,message = "请输入标题长度在 5 - 20个字符之间")
    @ApiModelProperty(value = "标题",required = true)
    private String title;

    /**
     * 广告图
     */
    @URL(message = "请输入合法的URL")
    @ApiModelProperty(value = "广告图URL",required = true)
    private String url;

    /**
     * 备注
     */
    @NotBlank(message = "备注信息不可以为空")
    @ApiModelProperty(value = "备注信息",required = true)
    private String remarks;
}