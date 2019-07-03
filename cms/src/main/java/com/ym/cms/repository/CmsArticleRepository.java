package com.ym.cms.repository;

import com.ym.cms.pojo.CmsArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmsArticleRepository extends JpaRepository<CmsArticle,String> {
}
