<html>
<script>
    function showImg(thisimg) {
        var file = thisimg.files[0];
        if(window.FileReader) {
            var fr = new FileReader();

            var showimg = document.getElementById('showimg');
            fr.onloadend = function(e) {
                showimg.src = e.target.result;
            };
            fr.readAsDataURL(file);
            showimg.style.display = 'block';
        }
    }



</script>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
    <#--边栏-->
    <#include  "../common/nav.ftl">

    <#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" enctype="multipart/form-data" method="post" action="/cms/operator/articleSave">

                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (article.categoryType)?? && article.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                    >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>文章标题</label>
                            <input name="articleTitle" type="text" class="form-control" required="required"  value="${(article.articleTitle)!''}"/>
                        </div>

                        <div class="form-group">
                            <label>主题图片</label>
                            <img height="100" width="100" id="showimg" src="${(article.articleImage)!''}" alt="">

                            <input type="hidden" name="articleImage" value="${(article.articleImage)!''}"/>
                            <#if (article.articleId) ??>
                                <input name="pic" type="file" onchange="showImg(this)"  />
                            <#else>
                                <input name="pic" type="file" onchange="showImg(this)" required="required" />
                            </#if>

                        </div>
                            <div>请上传图片</div>




                        <div class="form-group">
                            <label>文章摘要</label>
                            <input name="articleDescription" type="text" class="form-control" required="required"  value="${(article.articleDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>文章作者</label>
                            <input name="articleAuthor" type="text" class="form-control" required="required"  value="${(article.articleAuthor)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>内容</label>
                            <textarea name="articleContent" required="required" rows="10" cols="100" placeholder="" >${(article.articleContent)!''}</textarea>
                            <#--<input name="articleContent" type="text" class="form-control" required="required"  value="${(article.articleContent)!''}"/>-->
                        </div>


                        <input hidden type="text" name="articleId" value="${(article.articleId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>

</body>

</html>


