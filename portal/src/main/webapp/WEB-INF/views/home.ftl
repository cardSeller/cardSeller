<!DOCTYPE html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head lang="zh">
    <title>快充商城</title>
</head>
<body>
<div class="c-nav">
    <div class="wrap">
        <ul id="c-nav" class="clearfix">
            <li class="nav-hot selected">
                <a href="#">热卖产品</a>
            </li>
            <li>
                <a href="#">按字母检索 A--H</a>
                <div class="drop-menu clearfix">
                    <#list ahMap?keys as initial>
                        <p class="drop-menu-item">
                            <#list ahMap[initial] as item>
                                <span class="serial-num">${item.initial!}</span><a href="${absoluteContextPath}/item/detail/${item.id?c}">${item.name!}</a>
                            </#list>
                        </p>
                    </#list>
                </div>
            </li>
            <li>
                <a href="#">按字母检索 I--P</a>
                <div class="drop-menu clearfix">
                    <#list ipMap?keys as initial>
                        <p class="drop-menu-item">
                            <#list ipMap[initial] as item>
                                <span class="serial-num">${item.initial!}</span><a href="${absoluteContextPath}/item/detail/${item.id?c}">${item.name!}</a>
                            </#list>
                        </p>
                    </#list>
                </div>
            </li>
            <li>
                <a href="#">按字母检索 Q--Z</a>
                <div class="drop-menu clearfix">
                    <#list qzMap?keys as initial>
                        <p class="drop-menu-item">
                            <#list qzMap[initial] as item>
                                <span class="serial-num">${item.initial!}</span><a href="${absoluteContextPath}/item/detail/${item.id?c}">${item.name!}</a>
                            </#list>
                        </p>
                    </#list>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="p-box container">
    <div class="wrap relative">
        <ul class="p-list clearfix" id="p-list">
            <#list homeItems as item>
                <li class="p-item">
                    <a class="p-url" href="${absoluteContextPath}/item/detail/${item.id?c}">
                        <div class="p-pic">
                            <img src="${absoluteContextPath}/images/products/${item.imageUrl!}" alt="${item.name!}"/>
                        </div>
                        <p class="p-name">${item.name!}</p>
                    </a>
                </li>
            </#list>
        </ul>
    </div>
    <div class="bottom-banner wrap">
        <img src="${absoluteContextPath}/images/bottom-banner.jpg" alt="不刷信誉!!不招兼职!!"/>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".p-item").hover(function(){
            var thisName = $(this).find(".p-name").text();
            var thisUrl = $(this).find(".p-url").attr("href");
            $(this).append("<div class=\"p-item-hover\" onclick="+"javascript:window.open("+"\""+thisUrl+""+"\")><p>"+thisName+"</p><p>查看详情</p></div>");
        },function(){
            $(this).find(".p-item-hover").remove();
        });
    });
</script>
</body>
</html>