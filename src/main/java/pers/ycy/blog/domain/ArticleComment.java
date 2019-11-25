package pers.ycy.blog.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "blog.article_comment")
public class ArticleComment implements Serializable {
    private static final long serialVersionUID = 3679656710905149146L;
    /**
     * 主键, 长度为10 , 不为空, 自增, 唯一 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 所属文章ID
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 评论者的称呼
     */
    @Column(name = "comment_user_name")
    private String commentUserName;

    /**
     * 评论者的联系邮箱
     */
    @Column(name = "comment_user_email")
    private String commentUserEmail;

    /**
     * 评论创建时间, TIMESTAMP 默认为当前系统时间
     */
    @Column(name = "article_create_time")
    private Date articleCreateTime;

    /**
     * 评论修改时间, TIMESTAMP 默认为当前系统时间
     */
    @Column(name = "article_update_time")
    private Date articleUpdateTime;

    /**
     * 评论内容
     */
    @Column(name = "article_comment")
    private String articleComment;

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
     * 获取所属文章ID
     *
     * @return article_id - 所属文章ID
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置所属文章ID
     *
     * @param articleId 所属文章ID
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取评论者的称呼
     *
     * @return comment_user_name - 评论者的称呼
     */
    public String getCommentUserName() {
        return commentUserName;
    }

    /**
     * 设置评论者的称呼
     *
     * @param commentUserName 评论者的称呼
     */
    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    /**
     * 获取评论者的联系邮箱
     *
     * @return comment_user_email - 评论者的联系邮箱
     */
    public String getCommentUserEmail() {
        return commentUserEmail;
    }

    /**
     * 设置评论者的联系邮箱
     *
     * @param commentUserEmail 评论者的联系邮箱
     */
    public void setCommentUserEmail(String commentUserEmail) {
        this.commentUserEmail = commentUserEmail;
    }

    /**
     * 获取评论创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @return article_create_time - 评论创建时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getArticleCreateTime() {
        return articleCreateTime;
    }

    /**
     * 设置评论创建时间, TIMESTAMP 默认为当前系统时间
     *
     * @param articleCreateTime 评论创建时间, TIMESTAMP 默认为当前系统时间
     */
    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    /**
     * 获取评论修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @return article_update_time - 评论修改时间, TIMESTAMP 默认为当前系统时间
     */
    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    /**
     * 设置评论修改时间, TIMESTAMP 默认为当前系统时间
     *
     * @param articleUpdateTime 评论修改时间, TIMESTAMP 默认为当前系统时间
     */
    public void setArticleUpdateTime(Date articleUpdateTime) {
        this.articleUpdateTime = articleUpdateTime;
    }

    /**
     * 获取评论内容
     *
     * @return article_comment - 评论内容
     */
    public String getArticleComment() {
        return articleComment;
    }

    /**
     * 设置评论内容
     *
     * @param articleComment 评论内容
     */
    public void setArticleComment(String articleComment) {
        this.articleComment = articleComment;
    }
}