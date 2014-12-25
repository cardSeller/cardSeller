<!DOCTYPE html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>快充商城</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css"/>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
</head>
<body>
<#include "head.ftl"/>
<#include "menu.ftl">
<sitemesh:write property="body"/>
<#include "menu_bottom.ftl">
<#include "footer.ftl"/>
</body>
</html>