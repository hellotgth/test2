package com.ym.cms.service.impl;

import com.ym.cms.pojo.CmsCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception{
        CmsCategory category = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<CmsCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }



    @Test
    public void save() {
        CmsCategory category = new CmsCategory("自",4);
        CmsCategory cmsCategory = categoryService.Save(category);
        Assert.assertNotNull(cmsCategory);
    }
}