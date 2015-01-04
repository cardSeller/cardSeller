<!doctype html>
<head>
    <title>网银支付</title>
</head>
<body>
<div class="container" style="min-height: 600px; background-color: #fff;">
    <div style="height:320px;padding-top:300px;width:400px;position: absolute;left:50%;top:200px; margin-left: -200px; background:url(${absoluteContextPath}/images/paying.jpg) no-repeat;"></div>
</div>
<#if error??>
<#else>
<form name="payment" action="${paymentBean.paymentUrl }" method="POST">
    <input type=hidden name="MerId" value="${paymentBean.merId}">
    <input type=hidden name="OrdId" value="${paymentBean.ordId}">
    <input type=hidden name="TransAmt" value="${paymentBean.transAmt}">
    <input type=hidden name="CuryId" value="${paymentBean.curyId}">
    <input type=hidden name="TransDate" value="${paymentBean.transDate}">
    <input type=hidden name="TransType" value="${paymentBean.transType}">
    <input type=hidden name="Version" value="${paymentBean.version}">
    <input type=hidden name="BgRetUrl" value="${paymentBean.bgRetUrl}">
    <input type=hidden name="PageRetUrl" value="${paymentBean.pageRetUrl}">
    <input type=hidden name="ChkValue" value="${paymentBean.chkValue}">
    <input type=hidden name="ClientIp" value="${paymentBean.clientIP}">
</form>
<script type="text/javascript">
    document.payment.submit();
</script>
</#if>
</body>
</html>