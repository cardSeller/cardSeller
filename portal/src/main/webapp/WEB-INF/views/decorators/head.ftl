<@shiro.guest>
<div class="top-bar">
    <div class="wrap">
        <a class="sign-up" href="${absoluteContextPath}/toRegister">注册</a>
        <a class="sign-in" href="${absoluteContextPath}/login">登录</a>
        <a class="deter-fraud" href="#">防骗指南</a>
    </div>
</div>
</@shiro.guest>
<@shiro.user>
<div class="top-bar">
    <div class="wrap">
        <p><span class="member-mail"><#if Session["sv"]??>${Session["sv"].name!}</#if></span> ，您好！</p>
        <a class="top-bar-member" href="${absoluteContextPath}/member/orderManage">用户中心</a>
        <a class="top-bar-quit" href="${absoluteContextPath}/logout">退出</a>
        <a class="deter-fraud" href="#">防骗指南</a>
    </div>
</div>
</@shiro.user>
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