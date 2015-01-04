<!DOCTYPE html>
<html>
<head lang="zh">
    <title>会员中心-订单记录</title>
    <script type="text/javascript" src="${absoluteContextPath}/js/datepicker-cn.js"></script>
</head>
<body>
<div class="member-container left">
    <p class="member-title">
        购买记录
    </p>
    <div class="select-time clearfix">
        <form id="searchOrdersForm" class="search-providers-form clearfix" method="POST" action="${absoluteContextPath}/member/searchOrder" data-callback="getOrdersCallBack">
            <label for="from">时间区间</label>
            <input class="time-form" type="text" id="from" name="orderTimeFrom" placeholder="选择时间">
            <label for="to">-</label>
            <input class="time-to" type="text" id="to" name="orderTimeTo" placeholder="选择时间">
            <input type="hidden" id="pageIndex" name="pageIndex" value="1"/>
            <input type="hidden" id="pageSize" name="pageSize" value="8"/>
            <input type="hidden" id="memberId" name="memberId" value="<#if Session["sv"]??>${Session["sv"].id!}</#if>">
            <input type="hidden" id="total" value="${total?c}"/>
            <a href="javascript:searchOrders();" class="search-btn" href="#">搜索</a>
        </form>
    </div>
    <div id="orderList">
        <table class="w100 recharge-history">
            <thead>
            <tr>
                <th>订单号</th>
                <th>商品名称</th>
                <th>面值(￥)</th>
                <th>商品单价</th>
                <th>数量</th>
                <th>实付总金额(￥)</th>
                <th>交易日期</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="resultList">
            <#list orders as order>
            <tr>
                <td>${order.orderNumber!}</td>
                <td>${order.item.name!}</td>
                <td>${order.itemPrice.faceValue?c}</td>
                <td>${order.itemPrice.price?c}</td>
                <td>${order.itemCount?c}</td>
                <td>${order.total?c}</td>
                <td>${order.orderDate}</td>
                <td><p class="recharge-history-wait">${order.orderStatus!}</p></td>
                <#if order.orderStatus == '待付款'>
                    <td><a href="javascript:payOrder('${order.orderNumber!}','${order.item.id?c}','${order.itemPrice.id?c}','${order.total?c}','${order.itemCount?c}');">付款</a></td>
                </#if>
            </tr>
            </#list>
            </tbody>
        </table>
        <div class="pager-box">
            <div id="pager" class="right"></div>
        </div>
    </div>
    <div id="noOrdersList" class="alert alert-danger displayNone">
        没有符合条件的记录，请重试。
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/pagination.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/order.manage.js"></script>
<script type="text/javascript">
    $(function() {
        $( "#from" ).datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 1,
            onClose: function( selectedDate ) {
                $( "#to" ).datepicker( "option", "minDate", selectedDate );
            }
        });
        $( "#to" ).datepicker({
            defaultDate: "+1w",
            changeMonth: true,
            numberOfMonths: 1,
            onClose: function( selectedDate ) {
                $( "#from" ).datepicker( "option", "maxDate", selectedDate );
            }
        });
    });
</script>
</body>
</html>