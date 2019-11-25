package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@ApiModel(description = "文章的Model")
@Table(name = "blog.blog_article")
public class BlogArticle implements Serializable {
    private static final long serialVersionUID = -3750019342764346120L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    @Id
    @ApiModelProperty(value = "文章的api Id",example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 评论数量
     */
    @ApiModelProperty(value = "评论的数量",example = "0")
    @Column(name = "comment_number")
    private Integer commentNumber;

    /**
     * 博客标题, utf-8的话能存储50个字
     */
    @ApiModelProperty(value = "文章的标题",example = "标题")
    @Column(name = "blog_title")
    private String blogTitle;

    /**
     * 博文创建时间, TIMESTAMP 默认为当前系统时间
     */
    @ApiModelProperty(value = "文章的创建时间")
    @Column(name = "article_create_time")
    private Date articleCreateTime;

    /**
     * 博文修改时间, TIMESTAMP 默认为当前系统时间
     */
    @ApiModelProperty(value = "文章的更新时间")
    @Column(name = "article_update_time")
    private Date articleUpdateTime;

    /**
     * 浏览量
     */
    @ApiModelProperty(value = "浏览量",example = "0")
    @Column(name = "page_view")
    private Integer pageView;

    /**
     * 博客文章
     */
    @ApiModelProperty(value = "文章的内容",example = "博文内容")
    @Column(name = "blog_content")
    private String blogContent;

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
     * 获取评论数量
     *
     * @return comment_number - 评论数量
     */
    public Integer getCommentNumber() {
        return commentNumber;
    }

    /**
     * 设置评论数量
     *
     * @param commentNumber 评论数量
     */
    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    /**
     * 获取博客标题, utf-8的话能存储50个字
     *
     * @return blog_title - 博客标题, utf-8的话能存储50个字
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * 设置博客标题, utf-8的话能存储50个字
     *
     * @param blogTitle 博客标题, utf-8的话能存储50个字
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    /**
     * 获取博文创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @return article_create_time - 博文创建时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    /**
     * 设置博文创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @param articleCreateTime 博文创建时间, TIMESTAMP 默认为当前系统时间
     */
    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    /**
     * 获取博文修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @return article_update_time - 博文修改时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    /**
     * 设置博文修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @param articleUpdateTime 博文修改时间, TIMESTAMP 默认为当前系统时间
     */
    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    /**
     * 获取浏览量
     *
     * @return page_view - 浏览量
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * 设置浏览量
     *
     * @param pageView 浏览量
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * 获取博客文章
     *
     * @return blog_content - 博客文章
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * 设置博客文章
     *
     * @param blogContent 博客文章
     */
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}