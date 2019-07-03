<html>

    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <#--边栏-->
        <#include  "../common/nav.ftl">

        <#--主要内容-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row-fluid">
                    <div class="span12">
                        <table class="table table-bordered table-condensed">
                            <thead>
                            <tr>
                                <th>文章ID</th>
                                <th>视图</th>
                                <th>标题</th>
                                <th>分类</th>
                                <th>作者</th>
                                <th>摘要</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list articlePage.content as cmsArticle>

                                <tr>
                                    <td>${cmsArticle.articleId}</td>
                                    <td><img src="${cmsArticle.articleImage}"  width="50" height="50"/></td>
                                    <td><a href="/cms/operator/articleContent?articleId=${cmsArticle.articleId}">${cmsArticle.articleTitle}</a></td>
                                    <td>${cmsArticle.categoryType}</td>
                                    <td>${cmsArticle.articleAuthor}</td>
                                    <td>${cmsArticle.articleDescription}</td>
                                    <td>${cmsArticle.createTime}</td>
                                    <td>${cmsArticle.updateTime}</td>
                                    <td>
                                        <a href="/cms/operator/articleIndex?articleId=${cmsArticle.articleId}"><button type="button">修改</button></td></a>
                                    <td>
                                        <a href="/cms/operator/articleDelete?articleId=${cmsArticle.articleId}"><button type="button">删除</button></a>
                                    </td>


                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                    <#--分页-->
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                            <#if currentPage lte 1>
                                <li class="disabled"><a href="#">上一页</a></li>
                            <#else>
                                <li><a href="/cms/operator/articleList?page=${currentPage - 1}&size=${size}">上一页</a></li>
                            </#if>

                            <#list 1..articlePage.getTotalPages() as index>
                                <#if currentPage == index>
                                    <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                    <li><a href="/cms/operator/articleList?page=${index}&size=${size}">${index}</a></li>
                                </#if>

                            </#list>

                            <#if currentPage gte articlePage.getTotalPages()>
                                <li class="disabled"><a href="#">下一页</a></li>
                            <#else>
                                <li><a href="/cms/operator/articleList?page=${currentPage + 1}&size=${size}">下一页</a></li>
                            </#if>

                        </ul>
                    </div>

                </div>
            </div>
        </div>

    </div>

    </body>

</html>


