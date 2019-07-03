package com.ym.cms.VO;

import com.ym.cms.pojo.CmsArticle;
import com.ym.cms.pojo.CmsCategory;
import lombok.Data;

import java.util.List;

/**
 * 返回对象
 * @param <T>
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO() {
    }
}
