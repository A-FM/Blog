package pers.ycy.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ycy.blog.abstractionLayer.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.blog_category")
public class BlogCategory extends BaseEntity {

    private static final long serialVersionUID = -1404335539321579939L;
    /**
     * 分类内文章的数量
     */
    @Column(name = "category_article_number")
    private Integer categoryArticleNumber;

    /**
     * 分类名称, utf-8的话能存储50个字
     */
    @Column(name = "category_name")
    private String categoryName;
}