<!DOCTYPE html>
<html>
<head lang="zh">
    <title>快充商城-确认订单</title>
</head>
<body>
<div class="container">
    <div class="wrap relative">
        <div class="p-detail">
            <div class="buy-step-box">
                <ul class="clearfix">
                    <li class="buy-step buy-step-1">填写购买信息</li>
                    <li class="buy-step buy-step-2 current">确认订单</li>
                    <li class="buy-step buy-step-3">充值成功5分钟内到账</li>
                </ul>
            </div>
            <form id="payOrderForm" action="${absoluteContextPath}/item/payOrder" method="post">
                <input type="hidden" name="orderNumber" value="${orderNumber!}"/>
                <div class="p-detail-box clearfix">
                    <div class="p-detail-img left">
                        <img src="${absoluteContextPath}/images/products/${item.imageUrl}" alt="${item.name!}"/>
                        <p class="p-detail-title text-center">${item.name!}</p>
                    </div>
                    <div class="buy-affirm left">
                        <p class="buy-affirm-title">确认订单</p>
                        <ul class="buy-affirm-info">
                            <li>商品名称：${item.name!}</li>
                            <li>商品类型：直充商品</li>
                            <li>
                                <span>商品面值：</span>${itemPrice.faceValue?c}元
                            </li>
                            <li>
                                <span class="left">购买数量：</span>${count?c}
                            </li>
                            <li>订单号：${orderNumber!}<p>（请记好订单号，以备查询）</p></li>
                            <li class="buy-affirm-price">订单总价：<span>￥${total?c}</span></li>
                            <li class="buy-affirm-balance">您的余额：${member.balance?c}元</li>
                            <#if member.balance lt total><li class="balance-error">您的余额不够支付此订单，请点此<a href="${absoluteContextPath}/member/toDeposit">充值</a></li></#if>
                            <li class="buy-affirm-tips">请确认左边订单信息无误后，再进行支付</li>
                        </ul>
                        <div class="buy-btn-box clearfix">
                        <#if member.balance gte total>
                            <a class="buy-btn" onclick='$("#payOrderForm").submit()'>立即支付</a>
                        </#if>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>