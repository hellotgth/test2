package com.ym.cms.service.impl;

import com.ym.cms.enums.ArticleStatusEnum;
import com.ym.cms.enums.ResultEnum;
import com.ym.cms.exception.CmsException;
import com.ym.cms.pojo.CmsArticle;
import com.ym.cms.repository.CmsArticleRepository;
import com.ym.cms.service.ArticleService;
import com.ym.cms.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.List;

@Service
public class CmsArticleServiceImpl implements ArticleService {

    @Autowired
    private CmsArticleRepository repository;

    //查找文章
    @Override
    public CmsArticle findOne(String articleId) {
        return repository.findOne(articleId);
    }

    //查找所有文章
    @Override
    public Page<CmsArticle> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    //保存文章
    @Override
    public CmsArticle save(CmsArticle cmsArticle) {
        return repository.save(cmsArticle);
    }

    //删除文章
    @Override
    public void delete(String articleId) {

        repository.delete(articleId);
    }
}
