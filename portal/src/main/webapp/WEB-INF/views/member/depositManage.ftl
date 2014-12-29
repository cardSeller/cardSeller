<div class="member-container left">
    <p class="member-title">
        充值记录
    </p>
    <div class="select-time clearfix">
        <form id="searchDepositsForm" class="search-providers-form clearfix" method="POST" action="${absoluteContextPath}/member/searchDeposit" data-callback="getDepositsCallBack">
            <label for="from">时间区间</label>
            <input class="time-form" type="text" id="from" name="depositTimeFrom" placeholder="选择时间">
            <label for="to">-</label>
            <input class="time-to" type="text" id="to" name="depositTimeTo" placeholder="选择时间">
            <input type="hidden" id="pageIndex" name="pageIndex" value="1"/>
            <input type="hidden" id="pageSize" name="pageSize" value="2"/>
            <input type="hidden" id="memberId" name="memberId" value="<#if Session["sv"]??>${Session["sv"].id!}</#if>">
            <input type="hidden" id="total" value="${total?c}"/>
            <a class="search-btn" href="javascript:searchDeposits();">搜索</a>
        </form>
    </div>
    <div id="depositList">
        <table class="w100 recharge-history">
            <thead>
            <tr>
                <th>订单号</th>
                <th>充值金额（元）</th>
                <th>交易日期</th>
                <th>状态</th>
            </tr>
            </thead>
            <tbody id="resultList">
            <#list deposits as deposit>
            <tr>
                <td>${deposit.id?c}</td>
                <td>${deposit.total?c}</td>
                <td>${deposit.depositDate}</td>
                <td><p class="recharge-history-wait">${deposit.depositStatus}</p></td>
            </tr>
            </#list>
            </tbody>
        </table>
        <div class="pager-box right">
            <div id="pager" class="pager-control"></div>
        </div>
    </div>
    <div id="noDepositList" class="alert alert-danger displayNone">
        没有符合条件的记录，请重试。
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/pagination.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/deposit.manage.js"></script>
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