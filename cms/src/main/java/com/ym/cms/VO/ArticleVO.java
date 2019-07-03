package com.ym.cms.VO;

import lombok.Data;

@Data
public class ArticleVO {

    private String articleId;

    /** 文章标题 */
    private String articleTitle;

    /** 文章作者 */
    private String articleAuthor;

    /** 文章图片 */
    private String articleImage;

    /** 文章摘要 */
    private String articleDescription;

}
