package com.shop.eunm;

import lombok.Getter;

public enum EnumResult {

    ERROR("-1", "执行失败"),

    SUCCESS("0", "执行成功");

    @Getter
    private String code;

    @Getter
    private String message;

    EnumResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
