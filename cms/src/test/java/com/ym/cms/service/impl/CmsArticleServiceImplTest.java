package com.ym.cms.service.impl;

import com.ym.cms.enums.ArticleStatusEnum;
import com.ym.cms.pojo.CmsArticle;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmsArticleServiceImplTest {

    @Autowired
    private CmsArticleServiceImpl articleService;

    @Test
    public void findOne() {
        CmsArticle article = articleService.findOne("123");
        System.out.println(article.getArticleDescription());
        Assert.assertNotNull(article);
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<CmsArticle> articlePage = articleService.findAll(request);
        System.out.println(articlePage.getTotalElements());

    }



    @Test
    public void save() {
        CmsArticle article = new CmsArticle();
        article.setArticleId("2354151");
        article.setCategoryType(2);
        article.setArticleTitle("10年经验 ，工资涨幅竟10%都不到");
        article.setArticleAuthor("于小戈");
        article.setArticleContent("123");
        article.setArticleImage("http://e.hiphotos.baidu.com/image/pic/item/dc54564e9258d1092f7663c9db58ccbf6c814d30.jpg");
        article.setArticleDescription("打工者心态和老板心态，就像两座对望的高山，站在自己的山头上，看到的所有风景都是反的。");
        articleService.save(article);
        Assert.assertNotNull(article);
    }

    @Test
    public void delete() {
    }
}