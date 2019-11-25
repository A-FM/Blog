package pers.ycy.blog.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "blog.category_to_article")
public class CategoryToArticle implements Serializable {
    private static final long serialVersionUID = -6817813344585705131L;
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
     * 获取分类的ID
     *
     * @return category_id - 分类的ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类的ID
     *
     * @param categoryId 分类的ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取文章的ID
     *
     * @return article_id - 文章的ID
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置文章的ID
     *
     * @param articleId 文章的ID
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}