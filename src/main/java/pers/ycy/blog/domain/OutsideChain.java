package pers.ycy.blog.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import pers.ycy.blog.abstractionlayer.BaseEntity;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "blog.outside_chain")
public class OutsideChain extends BaseEntity {

    private static final long serialVersionUID = -3080057194358722791L;
    /**
     * 外链标题
     */
    @Length(min = 5,max = 20,message = "外链标题的长度在 5 - 20 个字符串之间")
    @ApiModelProperty(value = "外链的标题, 外链标题的长度在 5 - 20 个字符串之间",required = true)
    private String title;

    /**
     * 外链
     */
    @URL(message = "请输入合法的URL")
    @ApiModelProperty(value = "外链的URL",required = true)
    private String url;

    /**
     * 外链详情
     */
    @NotBlank(message = "外链信息不可为空.")
    @ApiModelProperty(value = "外链的备注信息",required = true)
    private String details;
}