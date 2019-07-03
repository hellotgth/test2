package com.ym.cms.exception;

import com.ym.cms.enums.ResultEnum;

/**
 * 自定义异常
 */

public class CmsException extends RuntimeException{

    private Integer code;

    public CmsException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
