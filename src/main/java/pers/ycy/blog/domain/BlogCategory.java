package pers.ycy.blog.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog.blog_category")
public class BlogCategory implements Serializable {
    private static final long serialVersionUID = 3109177959465043340L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * 分类创建时间, TIMESTAMP 默认为当前系统时间
     */
    @Column(name = "category_create_time")
    private Date categoryCreateTime;

    /**
     * 分类修改时间, TIMESTAMP 默认为当前系统时间
     */
    @Column(name = "category_update_time")
    private Date categoryUpdateTime;

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
     * 获取分类内文章的数量
     *
     * @return category_article_number - 分类内文章的数量
     */
    public Integer getCategoryArticleNumber() {
        return categoryArticleNumber;
    }

    /**
     * 设置分类内文章的数量
     *
     * @param categoryArticleNumber 分类内文章的数量
     */
    public void setCategoryArticleNumber(Integer categoryArticleNumber) {
        this.categoryArticleNumber = categoryArticleNumber;
    }

    /**
     * 获取分类名称, utf-8的话能存储50个字
     *
     * @return category_name - 分类名称, utf-8的话能存储50个字
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置分类名称, utf-8的话能存储50个字
     *
     * @param categoryName 分类名称, utf-8的话能存储50个字
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 获取分类创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @return category_create_time - 分类创建时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getCategoryCreateTime() {
        return categoryCreateTime;
    }

    /**
     * 设置分类创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @param categoryCreateTime 分类创建时间, TIMESTAMP 默认为当前系统时间
     */
    public void setCategoryCreateTime(Date categoryCreateTime) {
        this.categoryCreateTime = categoryCreateTime;
    }

    /**
     * 获取分类修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @return category_update_time - 分类修改时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getCategoryUpdateTime() {
        return categoryUpdateTime;
    }

    /**
     * 设置分类修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @param categoryUpdateTime 分类修改时间, TIMESTAMP 默认为当前系统时间
     */
    public void setCategoryUpdateTime(Date categoryUpdateTime) {
        this.categoryUpdateTime = categoryUpdateTime;
    }
}