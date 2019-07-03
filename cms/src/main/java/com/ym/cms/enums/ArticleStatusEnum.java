package com.ym.cms.enums;

import lombok.Getter;

/**
 * 文章状态
 */
@Getter
public enum ArticleStatusEnum {
    UP(0,"在线"),
    DOWN(1,"删除")
    ;
    private Integer code;

    private String message;

    ArticleStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
