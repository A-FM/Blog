package pers.ycy.blog.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResult implements Serializable {
    private int statue;
    private String message;
    private Object data;

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAILED = 499;
    public static final int LoginCodeORPassWord_Error = 503;

    public BaseResult(int statue, String message) {
        this.statue = statue;
        this.message = message;
    }

    public BaseResult(int statue, String message, Object data) {
        this.statue = statue;
        this.message = message;
        this.data = data;
    }
}