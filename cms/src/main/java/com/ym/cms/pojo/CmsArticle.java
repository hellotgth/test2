package com.ym.cms.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.util.Date;

@DynamicUpdate
@Entity
@Data
public class CmsArticle {

    @Id
    private String articleId;

    /** 类目编号 */
    @NotNull(message = "类目必填")
    private Integer categoryType;

    /** 文章标题 */
    @NotEmpty(message = "标题必填")
    private String articleTitle;

    /** 文章作者 */
    @NotEmpty(message = "作者必填")
    private String articleAuthor;

    /** 文章内容 */
    @NotEmpty(message = "内容必填")
    private String articleContent;

    /** 文章图片 */
//    @NotEmpty(message = "图片必填")
    private String articleImage;

    /** 文章摘要 */
    @NotEmpty(message = "摘要必填")
    private String articleDescription;

    private Date createTime;

    private Date updateTime;
}
