<!doctype html>
<head>
    <title>汇潮支付</title>
</head>
<body>
<div style="height: 40px;padding-top:200px;width: 330px;position: absolute;left:50%;top:160px; margin-left: -200px; background: url(${absoluteContextPath}/images/payingBg.png) no-repeat;">
</div>
<#if error??>
<#else>
<form name="payment" action="${hczfPaymentBean.paymentURL}" method="POST">
    <input type=hidden name="MerNo" value="${hczfPaymentBean.merNo}">
    <input type=hidden name="BillNo" value="${hczfPaymentBean.billNo}">
    <input type=hidden name="Amount" value="${hczfPaymentBean.amount}">
    <input type=hidden name="ReturnURL" value="${hczfPaymentBean.returnURL}">
    <input type=hidden name="AdviceURL" value="${hczfPaymentBean.adviceURL}">
    <input type=hidden name="SignInfo" value="${hczfPaymentBean.signInfo}">
    <input type=hidden name="orderTime" value="${hczfPaymentBean.orderTime}">
</form>
<script type="text/javascript">
    document.payment.submit();
</script>
</#if>
</body>
</html>