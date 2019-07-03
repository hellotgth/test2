package com.ym.cms.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 文章类目
 */
@DynamicUpdate
@Entity
@Data
public class CmsCategory {

    /** 类目id*/
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字*/
    private String categoryName;

    /** 类目编号*/
    private int categoryType;

    private Date createTime;

    private Date updateTime;

    public CmsCategory() {
    }

    public CmsCategory(String categoryName, int categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
