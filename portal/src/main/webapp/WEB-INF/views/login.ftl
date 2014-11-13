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
            <input type="text" id='username' name='username' placeholder="邮箱或手机号" class="long-text-input left" value='<#if username?exists>${username}<#else>邮箱或手机号</#if>'>
            <div id='loginErrorUserName' class="prompt-box left">
                <span class="triangle-left left"></span>
                <div class="prompt-msg left"></div>
            </div>
        </div>
        <p class="login-form-title yahei"><span>*</span>密码</p>
        <div class="login-form-pw relative clearfix">
            <input type="password" id='password' name='password' placeholder="密码" class="password-value-tip long-text-input left" value='<#if password?exists>${password}</#if>'>
            <div id='loginErrorPwd' class="prompt-box left">
                <span class="triangle-left left"></span>
                <div class="prompt-msg left"></div>
            </div>
        </div>
        <div class="clearfix">
            <div class="login-form-submit yahei left">
                <input type="submit" value="登录"/>
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
	$(function () {
		var currentTab = $("#select-tab").attr("data-selected-tab");
		$("#" + currentTab).addClass("selected");

		function userControlHide(){
			$("#headerUserControl,.header-user-arrow").hide();
		}
		var hoverTimer, outTimer;
		$("#headerUserInfo,#headerUserArrow,#headerUserControl").hover(function(){
			clearTimeout(outTimer);
			$("#headerUserControl,.header-user-arrow").show();
		},function(){
			clearTimeout(hoverTimer);
			outTimer = setTimeout(userControlHide, 300);
		});
		$("#headerUserControl").find("li:first").hover(function(){
			$("#headerUserInfo").find(".header-user-arrow").addClass("header-user-arrow-hover");
		},function(){
			$("#headerUserInfo").find(".header-user-arrow").removeClass("header-user-arrow-hover");
		});
		$('#headerSearch').focus(function () {
			if (this.value == "目的地/行程/产品名称") {
				this.value = "";
			}
			$(this).addClass("focus");
		});
		$('#headerSearch').blur(function () {
			if (this.value == "目的地/行程/产品名称" || this.value == "") {
				this.value = "目的地/行程/产品名称";
				$(this).removeClass("focus");
			}
		});
		$(".footer-to-top").click(function(){
			$("body,html").animate({scrollTop:0},500);
			return false;
		});
	});
</script>
</body>
</html>