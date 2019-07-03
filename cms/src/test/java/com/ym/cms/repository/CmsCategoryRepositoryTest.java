package com.ym.cms.repository;

import com.ym.cms.pojo.CmsCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsCategoryRepositoryTest {
    @Autowired
    private CmsCategoryRepository cmsCategoryRepository;

    @Test
    public void findOneTest(){
        CmsCategory cmsCategory = cmsCategoryRepository.findOne(1);
        System.out.println(cmsCategory);
    }

    @Test
    public void saveTest(){
        CmsCategory cmsCategory = new CmsCategory();
        cmsCategory.setCategoryName("段子");
        cmsCategory.setCategoryType(3);
        cmsCategoryRepository.save(cmsCategory);
    }

    @Test
    public void updateTest(){
        CmsCategory cmsCategory = cmsCategoryRepository.findOne(1);
        cmsCategory.setCategoryName("干货");
        cmsCategoryRepository.save(cmsCategory);
    }
}