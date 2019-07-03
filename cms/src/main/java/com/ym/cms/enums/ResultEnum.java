package com.ym.cms.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
