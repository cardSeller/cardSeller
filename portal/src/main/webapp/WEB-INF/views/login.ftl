<!DOCTYPE html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css"/>
</head>
<script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
<body>
<#include "decorators/head.ftl"/>
<div class="container">
<div class="wrap">
    <div class="login-box clearfix">
        <form id='login-form' class="login-form left" action='${absoluteContextPath}/login' method='post'>
            <fieldset>
                <legend class="hide">登录</legend>
                <p class="login-title"><span>*</span>账号</p>
                <div class="login-user">
                    <input type="text" id='username' name='username' placeholder="请输入邮箱" class="long-text-input" value='<#if username?exists>${username}</#if>'>
                    <div id='loginErrorUserName' class="prompt-msg"></div>
                </div>
                <p class="login-title"><span>*</span>密码</p>
                <div class="login-password">
                    <input onkeypress="passwordEnter();" type="password" id='password' name='password' placeholder="密码" class="long-text-input" value='<#if password?exists>${password}</#if>'>
                    <div id='loginErrorPwd' class="prompt-msg"></div>
                </div>
                <div class="clearfix">
                    <div class="login-submit left">
                        <a href="javascript:validateLoginSubmit();">登&nbsp;录</a>
                    </div>
                    <a class="login-forget left" href="#">忘记密码?</a>
                </div>
            </fieldset>
        </form>
        <div class="login-reg left">
            <p>还没有账号？<a href="${absoluteContextPath}/toRegister">立即注册</a></p>
        </div>
    </div>
</div>
</div>
<#include "decorators/footer.ftl"/>
<script type="text/javascript">
	var golbalRootUrl = "${absoluteContextPath}";
	$("#password").focus(function () {
		$("#loginErrorPwd").html("");
	}).blur(function () {
        if (this.value === '') {
            $("#loginErrorPwd").html("<p>请输入密码</p>");
        }
    });
	$('#username').focus(function () {
		if (this.value == "邮箱或手机号") {
			this.value = "";
		}
		$("#loginErrorUserName").html("");
	}).blur(function () {
        if (this.value === '') {
            $("#loginErrorUserName").html("<p>请输入邮箱</p>");
        }
    });
        <#if shiroLoginFailure??>
            <#if shiroLoginFailure?contains('UnknownAccountException')>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName').html("<p>用户不存在</p>");
			$("#password").val("");
            <#elseif shiroLoginFailure?contains("IncorrectCredentialsException")>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName').html("<p>用户名密码不正确</p>");
			$("#password").val("");
            <#elseif shiroLoginFailure?contains("DisabledAccountException")>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName').html("<p>你的账户未激活,点此<a href='javascript:activeEmail();'>激活</a></p>");
			$("#password").val("");
            </#if>
        </#if>
	function passwordEnter(){
		if(event.keyCode==13) {
			validateLoginSubmit();
			return false;
		}
	}
    function validateLogin() {
        if ($('#username').val() == "" || $('#username').val() == "请输入邮箱") {
            $('#loginErrorUserName').html("");
            $('#loginErrorUserName').html("<p>请输入邮箱</p>");
            return false;
        } else {
            $('#loginErrorUserName').html("");
        }
        if ($('#password').val() == "" || $("#password").val() == "请输入密码") {
            $('#loginErrorPwd').html("");
            $('#loginErrorPwd').html("<p>请输入密码</p>");
            return false;
        } else {
            $('#loginErrorPwd').html("");
        }
        return true;
    }
    function validateLoginSubmit() {
        if (validateLogin()) {
            $('#login-form').submit();
        }
    }
</script>
</body>
</html>