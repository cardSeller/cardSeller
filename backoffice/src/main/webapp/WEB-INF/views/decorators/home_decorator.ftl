<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html xmlns:sitemesh>
<head>
    <title>快充商城后台-
        <sitemesh:write property="title"/>
    </title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/layout.min.css"/>
	<link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/jquery.ui.1.10.4.custom.css"/>
    <!--[if lt IE 9]>
    <script src="${absoluteContextPath}/js/html5.js" type="text/javascript"></script>
    <![endif]-->
    <link rel="shortcut icon" href="${absoluteContextPath}/images/favicon.ico" type="image/x-icon"/>
    <!--[if IE 8]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script type="text/javascript" src="${absoluteContextPath}/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
    <!--[if lt IE 9]>
    <script type="text/javascript">
        $(function () {
            $(".main-container").html(
                    '<div class="server-exception" style="color:#aaaaaa;margin-top:80px">' +
                            '<p><center><img class="" src="${absoluteContextPath}/img/ie.png"></center></p>' +
                            '<p>&nbsp;</p>' +
                            '<h3>浏览器不兼容</h3>' +
                            '<p>您的刘浏览器版本过低！<a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie">请升级IE到最新版本</a></p>' +
                            '<p style="color:#d44950">推荐使用chrome浏览器！<a target="_blank" href="https://www.google.com/intl/zh-CN/chrome/browser/">下载最新版Chrome浏览器</a></p>' +
                            '</div>'
            );
        });
    </script>
    <![endif]-->
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery.form.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-ui-1.10.4.custom.js"></script>
    <script language="JavaScript">
        var golbalRootUrl = "${absoluteContextPath}";
        var golbalPerssions =[];
        <#list Session['sv'].permissionList as permission>
        golbalPerssions.push('${permission!}');
        </#list>
        Array.prototype.contains = function(item){
            return RegExp(item).test(this);
        };
        if (window != top)
            top.location.href = location.href;
    </script>

    <script language="JavaScript">
        $(document).ready(function () {
            var currentTab = $("#select-tab").attr("data-selected-tab");
            $("#" + currentTab).addClass("selected");
            var subCurrentTab = $("#sub-select-tab").attr("data-selected-tab");
            $("#" + subCurrentTab).addClass("active");

			var liBox = $("#navigation dd");
			liBox.find(".selected").parent().parent().prev().addClass("open-list");
            for(var i= 0;i<liBox.length;i++){
				if($(liBox[i]).find("li").length>1 && !$(liBox[i]).find("li").hasClass("selected")){
					$(liBox[i]).hide();
                }
                if($(liBox[i]).find("li").length<=1){
					$(liBox[i]).prev().find("span:eq(2)").remove();
                }
            }
            $("#navigation dt").click(function(){
                if($(this).next().find("li").length>1){
                    if($(this).next().is(":visible")){
						$(this).removeClass("open-list");
						$(this).next().slideUp();
                    }else{
						$(this).addClass("open-list");
						$(this).next().slideDown();
                    }
                }
            });
        });
    </script>

    <sitemesh:write property="head"/>
</head>
<body>
<#include "head.ftl"/>
<#include "footer.ftl"/>
</body>
</html>
