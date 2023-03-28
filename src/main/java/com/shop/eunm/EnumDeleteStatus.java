package com.shop.eunm;

import lombok.Getter;

public enum EnumDeleteStatus {

    NOT_DELETE(0, "未删除"),

    DELETE(1, "已删除");

    @Getter
    private Integer status;

    @Getter
    private String text;

    EnumDeleteStatus(Integer status, String text) {
        this.status = status;
        this.text = text;
    }

}
