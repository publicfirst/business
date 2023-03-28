package com.shop.entity;

import com.shop.eunm.EnumResult;
import lombok.Data;

@Data
public class Result<T> {

    private T data;

    private String message;

    private String code;

    public Result() {
        this.code = EnumResult.SUCCESS.getCode();
        this.message = EnumResult.SUCCESS.getMessage();
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public Result(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public Result(T data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }
}
