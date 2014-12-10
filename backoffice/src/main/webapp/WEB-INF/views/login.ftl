<html>
<head>
    <title>快充商城后台</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>

    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${absoluteContextPath}/css/layout.min.css"/>

    <!--[if IE 8]>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<script type="text/javascript" src="${absoluteContextPath}/js/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery.form.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery.validate.min.js"></script>

    <script type="text/javascript" src="${absoluteContextPath}/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
		<#if shiroLoginFailure??>
			<#if shiroLoginFailure?contains('UnknownAccountException')>
                $('#message').html("");
                $('#message').html("用户不存在");
			<#elseif shiroLoginFailure?contains("IncorrectCredentialsException")>
                $('#message').html("");
                $('#message').html("用户名密码不正确");
			<#elseif shiroLoginFailure?contains("DisabledAccountException")>
                $('#message').html("");
                $('#message').html("你的账户已被禁用,请联系管理员开通.");
			</#if>
		</#if>
            $("body").addClass("login-box");
        })
    </script>
</head>
<body>
<div class="data-content">
    <div class="login-container">
        <div class="panel panel-default">
            <div class="login-system">
                <h1>快充商城-后台管理系统</h1>
            </div>
            <div class="panel-heading">
                <h3 class="panel-title">
                    <sapn class="glyphicon glyphicon-lock"></sapn>
                    用户登录
                </h3>
            </div>
            <form id="login-form" action="${absoluteContextPath}/login" method="post">

                <div class="panel-body">

				<#if shiroLoginFailure?has_content>
                    <div class="alert alert-danger fade in">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <span class="glyphicon glyphicon-remove"></span> <span id="message"></span>
                    </div>
				</#if>

                    <div class="form-group">
                        <label for="username">登录帐号:</label>
                        <input type="text" class="form-control required" name="username" id="username">
                    </div>
                    <div class="form-group">
                        <label for="password">登录密码:</label>
                        <input type="password" class="form-control required" name="password" id="password">
                    </div>
                    <div class="checkbox">
                        <input type="checkbox" name="rememberMe" id="rememberMe">
                        <label for="rememberMe">记住我</label>
                    </div>
                    <div class="panel-footer text-center">
                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-ok-sign"></span>&nbsp;登&nbsp;录</button>
                        <button type="reset" class="btn btn-danger"><span class="glyphicon glyphicon-refresh"></span>&nbsp;重&nbsp;置</button>
                    </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>