<div class="top-bar">
    <div class="wrap">
        <a class="sign-up" href="#">注册</a>
        <a class="sign-in" href="#">登录</a>
        <a class="deter-fraud" href="#">防骗指南</a>
    </div>
</div>
<div class="header">
    <div class="wrap clearfix">
        <h1 class="logo-box">
            <a href="#" class="logo">快充商城</a>
        </h1>
        <ul class="header-nav right">
            <li>
                <a href="${absoluteContextPath}">首页</a>
            </li>
            <li>
                <a href="#">订单查询</a>
            </li>
            <li>
                <a href="#">网站声明</a>
            </li>
            <li>
                <a href="#">常见问题</a>
            </li>
            <li>
                <a href="#">联系我们</a>
            </li>
        </ul>
    </div>
</div>
<div class="login-popup" id="login-popup">
    <div class="login-shade"></div>
    <div class="login-box sign-up-pop">
        <p class="login-box-title">注册<a class="login-close" href="javascript:;">关闭</a></p>
        <div class="login-content clearfix">
            <form action="">
                <div class="register-username clearfix">
                    <label>用户名：</label>
                    <input type="text" value="请输入常用邮箱"/>
                    <p class="reg-error">格式错误，请输入常用邮箱</p>
                </div>
                <div class="register-password clearfix">
                    <label for="">密码：</label>
                    <input type="password" placeholder="密码"/>
                    <p class="reg-error">请输入密码</p>
                </div>
                <div class="register-password-affirm clearfix">
                    <label for="">确认密码：</label>
                    <input type="password" placeholder="确认密码"/>
                    <p class="reg-error">请输入密码</p>
                </div>
                <input type="submit" class="register-btn" value="注册"/>
            </form>
        </div>
    </div>
    <div class="login-box sign-in-pop">
        <p class="login-box-title">登录<a class="login-close" href="javascript:;">关闭</a></p>
        <div class="login-content clearfix">
            <form action="">
                <div class="login-username clearfix">
                    <label>用户名：</label>
                    <input type="text" value="请输入用户邮箱"/>
                    <p class="reg-error">请输入用户邮箱</p>
                </div>
                <div class="login-password clearfix">
                    <label for="">密码：</label>
                    <input type="password" placeholder="密码"/>
                    <p class="reg-error">请输入密码</p>
                </div>
                <input type="submit" class="register-btn" value="登录"/>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $(".sign-up").click(function(){
            $(".login-popup,.sign-up-pop").show();
        });
        $(".sign-in").click(function(){
            $(".login-popup,.sign-in-pop").show();
        });
        $(".login-close").click(function(){
            $("#login-popup,.sign-up-pop,.sign-in-pop").hide();
        });
        $(".register-username input").focus(function(){
            $(this).val("");
            $(this).next().hide();
        }).blur(function () {
            if (this.value === '') {
                $(this).val("请输入常用邮箱");
                $(this).next().show();
            }
        });
        $(".register-password input,.register-password-affirm input,.login-password input").focus(function(){
            $(this).next().hide();
        }).blur(function () {
            if (this.value === '') {
                $(this).next().show();
            }
        });
        $(".login-username input").focus(function(){
            $(this).val("");
            $(this).next().hide();
        }).blur(function () {
            if (this.value === '') {
                $(this).val("请输入常用邮箱");
                $(this).next().show();
            }
        });
    });
</script>