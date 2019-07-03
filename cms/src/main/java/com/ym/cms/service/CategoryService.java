package com.ym.cms.service;

import com.ym.cms.pojo.CmsCategory;

import java.util.List;

/**
 * 文章类目
 */

public interface CategoryService {

    CmsCategory findOne(Integer categoryId);

    List<CmsCategory> findAll();

    CmsCategory Save(CmsCategory cmsCategory);

}
