package com.ym.cms.controller.PortalController;

import com.ym.cms.VO.ArticleVO;
import com.ym.cms.VO.ResultVO;
import com.ym.cms.pojo.CmsArticle;
import com.ym.cms.pojo.CmsCategory;
import com.ym.cms.service.ArticleService;
import com.ym.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * PC端
 */

@RestController
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;



    /** 查找所有类目*/
    @GetMapping("/categoryList")
    public List<CmsCategory> categoryList(){
        System.out.println("222222222222");
        List<CmsCategory> categoryList = categoryService.findAll();
        System.out.println(categoryList);
        return categoryList;
    }
}
