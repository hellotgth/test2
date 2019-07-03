package com.ym.cms.service.impl;

import com.ym.cms.pojo.CmsCategory;
import com.ym.cms.repository.CmsCategoryRepository;
import com.ym.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CmsCategoryRepository repository;

    @Override
    public CmsCategory findOne(Integer categoryId) {
        return repository.findOne(categoryId);
    }

    @Override
    public List<CmsCategory> findAll() {
        return repository.findAll();
    }


    @Override
    public CmsCategory Save(CmsCategory cmsCategory) {
        return repository.save(cmsCategory);
    }
}
