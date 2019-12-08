package pers.ycy.blog.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.category_to_article")
public class CategoryToArticle extends BaseEntity {

    private static final long serialVersionUID = -374314842459340326L;
    /**
     * 分类的ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 文章的ID
     */
    @Column(name = "article_id")
    private Integer articleId;
}