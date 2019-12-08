package pers.ycy.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import pers.ycy.blog.abstractionLayer.BaseEntity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.advertisement")
public class Advertisement extends BaseEntity {

    private static final long serialVersionUID = -2844623727241651391L;
    /**
     * 广告标题
     */
    @Length(min = 5,max = 20,message = "请输入标题长度在 5 - 20个字符之间")
    private String title;

    /**
     * 广告图
     */
    @URL(message = "请输入合法的URL")
    private String url;

    /**
     * 备注
     */
    @NotBlank(message = "备注信息不可以为空")
    private String remarks;
}