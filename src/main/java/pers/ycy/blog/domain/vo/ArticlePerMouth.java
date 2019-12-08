package pers.ycy.blog.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.ycy.blog.abstractionlayer.BaseEntity;

/**
 * @author: 袁重阳
 * @description: 每月文章数量
 * @create: 2019-11-26 18:27
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-11-26 18:27
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "每月发表文章数量 模型")
@Data
public class ArticlePerMouth extends BaseEntity {
    private static final long serialVersionUID = -4977905863611536730L;

    @ApiModelProperty(value = "年-月")
    private String yearAndMouth;
    @ApiModelProperty(value = "文章数量")
    private String num;
}
