package com.ym.cms.controller.operatorController;

import com.ym.cms.pojo.CmsArticle;
import com.ym.cms.pojo.CmsCategory;
import com.ym.cms.service.ArticleService;
import com.ym.cms.service.CategoryService;
import com.ym.cms.utils.KeyUtil;
import com.ym.cms.utils.SaveFileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文章
 */
@Slf4j
@Controller
@RequestMapping("/operator")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询
     * @param page 第几页 从第一页开始
     * @param size 每页显示多少条数据
     * @param map
     * @return
     */

    @GetMapping("/articleList")
    public ModelAndView articleList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String,Object> map){
        PageRequest request = new PageRequest(page-1,size);
        Page<CmsArticle> articlePage = articleService.findAll(request);
        map.put("articlePage",articlePage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("operator/list",map);
    }

    /**
     * 删除文章
     * @param articleId
     * @return
     */
    @GetMapping("/articleDelete")
    public String articleDelete(@RequestParam("articleId") String articleId){
        articleService.delete(articleId);
        return "redirect:/operator/articleList";
    }

    /**
     * 页面（保存/修改）
     * @param articleId
     * @param map
     */
    @GetMapping("/articleIndex")
    public ModelAndView articleIndex(@RequestParam(value = "articleId", required = false) String articleId,
                        Map<String,Object> map){
        //返回要修改的文章数据
        if(!StringUtils.isEmpty(articleId)){
            CmsArticle article = articleService.findOne(articleId);
            map.put("article",article);
        }

        //查询所有类目
        List<CmsCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("article/index",map);
    }

    /**
     * 文章（新增/修改）
     * @param cmsArticle
     * @return
     */
    @PostMapping("/articleSave")
    public ModelAndView articleSave(@Valid CmsArticle cmsArticle, MultipartFile pic,
                                    BindingResult bindingResult,
                                    Map<String,Object>map){
        //判断前端的数据是否缺少
        if(bindingResult.hasErrors()){
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/cms/operator/articleIndex");
            return new ModelAndView("common/error",map);
        }
        //判断是新增还是修改
        if(!StringUtils.isEmpty(cmsArticle.getArticleId())){
            //判断是否修改图片
            if(pic.getSize()>0){
                String Imageurl = SaveFileUtil.saveFile(pic);
                cmsArticle.setArticleImage(Imageurl);
            }
            //修改
           articleService.save(cmsArticle);
        }else {
            //新增
            String Imageurl = SaveFileUtil.saveFile(pic);
            cmsArticle.setArticleImage(Imageurl);
            cmsArticle.setArticleId(KeyUtil.genUniquekey());
            articleService.save(cmsArticle);
        }
        return new ModelAndView("redirect:/operator/articleList");
    }

    /**
     * 文章内容
     * @param articleId
     * @param map
     * @return
     */
    @GetMapping("/articleContent")
    public ModelAndView articleContent(@RequestParam("articleId") String articleId,
                                       Map<String,Object> map){
        CmsArticle article = articleService.findOne(articleId);
        map.put("articleContent",article.getArticleContent());
        map.put("articleImage",article.getArticleImage());
        return new ModelAndView("/article/content",map);
    }


}
