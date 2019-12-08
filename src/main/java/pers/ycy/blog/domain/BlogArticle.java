package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.blog_article")
public class BlogArticle extends BaseEntity {

    private static final long serialVersionUID = -7945009420196352436L;
    /**
     * 博客标题, utf-8的话能存储50个字
     */
    @Length(min = 5,max = 20,message = "文章的长度在5 - 20 个字符之间")
    @ApiModelProperty(value = "文章的标题, 长度在5 - 20 个字符之间",required = true)
    @Column(name = "blog_title")
    private String blogTitle;

    /**
     * 评论数量
     */
    @ApiModelProperty(value = "评论数量, 最少评论数量为0",required = true)
    @Min(value = 0,message = "最少评论数量为0")
    @Column(name = "comment_number")
    private Integer commentNumber;

    /**
     * 浏览量
     */
    @Min(value = 0,message = "最少浏览量应大于0")
    @ApiModelProperty(value = "浏览量, 最少浏览量应大于0",required = true)
    @Column(name = "page_view")
    private Integer pageView;

    /**
     * 博客文章
     */
    @NotBlank(message = "文章内容不可为空")
    @ApiModelProperty(value = "博文内容",required = true)
    @Column(name = "blog_content")
    private String blogContent;

}