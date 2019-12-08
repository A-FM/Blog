package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.essay")
public class Essay extends BaseEntity {

    private static final long serialVersionUID = -4336556245017543634L;
    @ApiModelProperty(value = "随笔的标题, 标题长度应为 4 - 20 字符",required = true)
    @Length(min = 4,max = 20,message = "标题长度应为 4 - 20 字符")
    private String title;
    @ApiModelProperty(value = "随笔的内容",required = true)
    @NotNull(message = "随笔内容不可为空")
    private String content;

}