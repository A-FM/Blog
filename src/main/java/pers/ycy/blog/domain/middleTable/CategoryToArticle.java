package pers.ycy.blog.domain.middleTable;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "blog.category_to_article")
public class CategoryToArticle {
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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