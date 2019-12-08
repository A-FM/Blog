package pers.ycy.blog.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -1246447848398026996L;
    private Integer statusCode;
    private String message;
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
     * 不是我想要的文件类型.
     */
    public static final int STATUS_UNSUPPORTED = 415;



    public BaseResult(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
