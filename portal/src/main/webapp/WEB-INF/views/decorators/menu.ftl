<div class="container">
<div class="wrap">
    <div class="member clearfix">
        <div class="member-nav left">
            <div class="member-info">
                <div class="member-avatar">
                    <img src="${absoluteContextPath}/images/avatar.jpg" alt=""/>
                </div>
                <p class="member-id"><#if Session["sv"]??>${Session["sv"].name!}</#if></p>
                <p class="member-balance">我的余额：<strong><#if member??>${member.balance?c}</#if></strong>元</p>
                <p class="member-nav-recharge">
                    <a href="${absoluteContextPath}/member/toDeposit">充值</a>
                </p>
            </div>
            <ul>
                <li>
                    <a href="${absoluteContextPath}/member/orderManage">购买记录查询</a>
                </li>
                <li>
                    <a href="${absoluteContextPath}/member/profile">修改个人信息</a>
                </li>
                <li>
                    <a href="${absoluteContextPath}/member/toModifyPwd">修改密码</a>
                </li>
                <li>
                    <a href="${absoluteContextPath}/member/toDeposit">用户充值</a>
                </li>
                <li>
                    <a href="${absoluteContextPath}/member/depositManage">充值记录</a>
                </li>
            </ul>
        </div>