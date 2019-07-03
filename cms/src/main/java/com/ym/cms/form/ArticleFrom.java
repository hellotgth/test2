package com.ym.cms.form;

import lombok.Data;

/**
 * 表单提交实体类
 */

@Data
public class ArticleFrom {

    /** 类目编号 */
    private Integer categoryType;

    /** 文章标题 */
    private String articleTitle;

    /** 文章作者 */
    private String articleAuthor;

    /** 文章内容 */
    private String articleContent;

    /** 文章图片 */
    private String articleImage;

    /** 文章摘要 */
    private String articleDescription;


}
