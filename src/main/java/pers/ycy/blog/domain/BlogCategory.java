package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.blog_category")
public class BlogCategory extends BaseEntity {

    private static final long serialVersionUID = -1404335539321579939L;
    /**
     * 分类内文章的数量
     */
    @ApiModelProperty(value = "该分类下文章的数量",example = "0",required = true)
    @NotNull
    @Column(name = "category_article_number")
    private Integer categoryArticleNumber;

    /**
     * 分类名称, utf-8的话能存储50个字
     */
    @Length(min = 4,max = 20,message = "分类名称长度规定在 4 - 20 之间")
    @ApiModelProperty(value = "分类名称, 分类名称长度规定在 4 - 20 之间",required = true)
    @Column(name = "category_name")
    private String categoryName;
}