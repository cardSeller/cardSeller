<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
<body class="transparent">
<form id='login-form' class="login-form left pl67" action='${absoluteContextPath}/login' method='post'>
    <fieldset>
        <legend class="hide">登录</legend>
        <p class="login-form-title yahei"><span>*</span>账号</p>
        <div class="login-form-userID clearfix">
            <input type="text" id='username' name='username' placeholder="请输入邮箱" class="long-text-input left" value='<#if username?exists>${username}</#if>'>
            <div id='loginErrorUserName' class="prompt-box left">
                <span class="triangle-left left"></span>
                <div class="prompt-msg left"></div>
            </div>
        </div>
        <p class="login-form-title yahei"><span>*</span>密码</p>
        <div class="login-form-pw relative clearfix">
            <input onkeypress="passwordEnter();" type="password" id='password' name='password' placeholder="密码" class="password-value-tip long-text-input left" value='<#if password?exists>${password}</#if>'>
            <div id='loginErrorPwd' class="prompt-box left">
                <span class="triangle-left left"></span>
                <div class="prompt-msg left"></div>
            </div>
        </div>
        <div class="clearfix">
            <div class="login-form-submit yahei left">
                <a href="javascript:validateLoginSubmit();">登&nbsp;录</a>
            </div>
        </div>
    </fieldset>
</form>
<script type="text/javascript">
	var golbalRootUrl = "${absoluteContextPath}";
	$("body").removeClass("transparent");
	$("#password").focus(function () {
        $(this).removeClass("password-value-tip");
		$("#loginErrorPwd").hide();
	}).blur(function () {
				if (this.value === '') {
                    $(this).addClass("password-value-tip");
				}
			});
	$('#username').focus(function () {
		if (this.value == "邮箱或手机号") {
			this.value = "";
		}
		$("#loginErrorUserName").hide();
	});
        <#if shiroLoginFailure??>
            <#if shiroLoginFailure?contains('UnknownAccountException')>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName .prompt-msg').html("<p>用户不存在</p>");
			$("#password").val("");
            <#elseif shiroLoginFailure?contains("IncorrectCredentialsException")>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName .prompt-msg').html("<p>用户名密码不正确</p>");
			$("#password").val("");
            <#elseif shiroLoginFailure?contains("DisabledAccountException")>
			$('#loginErrorUserName').show();
			$('#loginErrorUserName .prompt-msg').html("<p>你的账户未激活,点此<a href='javascript:activeEmail();'>激活</a></p>");
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
            $('#loginErrorUserName').html("<p class=\"popups-login-prompt-msg left\">请输入邮箱</p>");
            return false;
        } else {
            $('#loginErrorUserName').html("");
        }
        if ($('#password').val() == "" || $("#password").val() == "请输入密码") {
            $('#loginErrorPwd').html("");
            $('#loginErrorPwd').html("<p class=\"popups-login-prompt-msg left\">请输入密码</p>");
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