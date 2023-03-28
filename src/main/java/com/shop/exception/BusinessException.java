package com.shop.exception;

import com.shop.eunm.EnumResult;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException{

    private String message;

    private String code;

    public BusinessException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public BusinessException() {
        this.message = EnumResult.ERROR.getMessage();
        this.code = EnumResult.ERROR.getCode();
    }

    public BusinessException(String message) {
        this.message = message;
        this.code = EnumResult.ERROR.getCode();
    }
}
