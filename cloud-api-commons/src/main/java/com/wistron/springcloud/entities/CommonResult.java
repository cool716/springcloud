package com.wistron.springcloud.entities;

import lombok.Data;

/**
 * @program: cloud2020
 * @description: 返回json
 * @author: Cool
 * @create: 2020-12-28 19:37
 **/
@Data
public class CommonResult<T> {
    private int code;
    private String message;
    private T  data;

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult() {
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
