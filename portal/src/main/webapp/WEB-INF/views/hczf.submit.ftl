<!doctype html>
<head>
    <title>汇潮支付</title>
</head>
<body>
<div class="container" style="min-height: 600px; background-color: #fff;">
    <div style="height:320px;padding-top:300px;width:400px;position: absolute;left:50%;top:160px; margin-left: -200px; background:url(${absoluteContextPath}/images/paying.jpg) no-repeat;"></div>
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