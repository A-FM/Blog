package pers.ycy.blog.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.naming.Name;
import java.io.Serializable;

/**
 * @author: 袁重阳
 * @description: 统一的返回类
 * @create: 2019-12-08 02:45
 * @modifyBy: 袁重阳
 * @modifyAt: 2019-12-08 02:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BaseResult",description = "为了方便前端操作和规范制定的统一返回类型类")
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -1246447848398026996L;
    @ApiModelProperty(value = "代表操作状态的返回码")
    private Integer statusCode;
    @ApiModelProperty(value = "备注信息")
    private String message;
    @ApiModelProperty(value = "返回的内容在该属性类中",allowEmptyValue = true)
    private Object object;

    /**
     * 正常情况
     */
    public static final int STATUS_SUCCESS = 200;
    /**
     * 安装客户端请求创建了一个新资源
     */
    public static final int STATUS_CREATE = 201;
    /**
     * 权限不足
     */
    public static final int STATUS_NO_AUTHORITY = 401;
    /**
     * 我知道你想要什么, 但是我不想给你.
     */
    public static final int STATUS_FORBIDDEN = 403;
    /**
     * 没找到你想要的东西
     */
    public static final int STATUS_NOTFOUND = 404;
    /**
     * 不是我想要的文件类型.
     */
    public static final int STATUS_UNSUPPORTED = 415;
    /**
     * 不是我想要的文件类型.
     */
    public static final int STATUS_ERROR_PARAM = 499;



    public BaseResult(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
