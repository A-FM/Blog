package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.article_comment")
public class ArticleComment extends BaseEntity {

    private static final long serialVersionUID = 6512105352911515516L;
    /**
     * 所属文章ID
     */
    @NotBlank(message = "评论所属文章ID不可为空")
    @ApiModelProperty(value = "评论所属文章ID",required = true)
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 父评论ID, 用于评论的楼中楼
     */
    @NotNull(message = "父评论id不可为空")
    @ApiModelProperty(value = "父评论id不可为空",required = true)
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 评论者的称呼
     */
    @NotBlank(message = "评论者名称不可为空")
    @ApiModelProperty(value = "评论者名称",required = true)
    @Column(name = "comment_user_name")
    private String commentUserName;

    /**
     * 评论者的联系邮箱
     */
    @Email(message = "请输入正确的邮箱")
    @ApiModelProperty(value = "评论者邮箱",required = true)
    @Column(name = "comment_user_email")
    private String commentUserEmail;

    /**
     * 评论内容
     */
    @NotBlank(message = "评论内容不可为空")
    @ApiModelProperty(value = "评论内容",required = true)
    @Column(name = "article_comment")
    private String articleComment;
}