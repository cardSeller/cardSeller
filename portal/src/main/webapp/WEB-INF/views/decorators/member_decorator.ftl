<!DOCTYPE html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>快充商城</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css"/>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/form.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/common.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/validator.js"></script>
    <script language="JavaScript">
        var golbalRootUrl = "${absoluteContextPath}";
        Array.prototype.contains = function(item){
            return RegExp(item).test(this);
        };
        if (window != top)
            top.location.href = location.href;
    </script>
</head>
<body>
<#include "head.ftl"/>
<#include "menu.ftl">
<sitemesh:write property="body"/>
<#include "menu_bottom.ftl">
<#include "footer.ftl"/>
</body>
</html>