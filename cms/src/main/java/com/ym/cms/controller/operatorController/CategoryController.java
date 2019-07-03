package com.ym.cms.controller.operatorController;

import com.ym.cms.pojo.CmsCategory;
import com.ym.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 文章类目
 */

@Controller
@RequestMapping("/operator")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有类目
     * @param map
     * @return
     */
    @GetMapping("/categoryList")
    public ModelAndView categoryList(Map<String,Object> map){
        List<CmsCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("operator/categoryList",map);
    }
}
