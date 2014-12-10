<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<!--[if IE 7]>
<html class="ie ie7" lang="zh-CN" xmlns:sitemesh>
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8" lang="zh-CN" xmlns:sitemesh>
<![endif]-->
<!--[if !(IE 7) | !(IE 8)]>
<html lang="zh-CN" xmlns:sitemesh>
<![endif]-->
<head>
    <title><sitemesh:write property="title"/></title>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://www.chuguoqu.com/css/common.css" type="text/css" media="all">
    <!--[if lt IE 9]>
    <link rel="stylesheet" href="http://www.chuguoqu.com/css/ie.css" type="text/css" media="all"/>
    <script type="text/javascript" src="http://www.chuguoqu.com/js/html5.js"></script>
    <script type="text/javascript" src="http://www.chuguoqu.com/js/respond.min.js"></script>
    <![endif]-->
    <link rel="shortcut icon" href="http://www.chuguoqu.com/images/favicon.ico" type="image/x-icon" />
    <!--[if IE 8]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <!--[if lt IE 8]>
    <script type="text/javascript" src="http://www.chuguoqu.com/js/json2.js"></script>
    <![endif]-->
    <script type="text/javascript" src="http://www.chuguoqu.com/js/jquery-1.11.0.min.js"></script>
    <sitemesh:write property="head"/>
    <script language="JavaScript">
        var golbalRootUrl = "${absoluteContextPath}";
    </script>
</head>
<body>
<#include "head.ftl"/>
<sitemesh:write property="body"/>

<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.form.min.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.extends.min.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.dropDown.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/popups.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/common.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/form.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/jquery.jscrollpane.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/regexpCommon.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/cookie.js"></script>
<script type="text/javascript" src="http://www.chuguoqu.com/js/journey.common.js"></script>
<#include "footer.ftl"/>
</body>
</html>
