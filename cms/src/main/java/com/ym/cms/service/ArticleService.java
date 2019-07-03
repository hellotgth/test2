package com.ym.cms.service;

import com.ym.cms.pojo.CmsArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 文章
 */

public interface ArticleService {


    CmsArticle findOne(String articleId);

    Page<CmsArticle> findAll(Pageable pageable);

    CmsArticle save(CmsArticle cmsArticle);

    void delete(String articleId);

}
