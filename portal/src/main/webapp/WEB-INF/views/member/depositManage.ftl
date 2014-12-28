<div class="member-container left">
    <p class="member-title">
        充值记录
    </p>
    <div class="select-time clearfix">
        <label for="from">时间区间</label>
        <input class="time-form" type="text" id="from" name="from" placeholder="选择时间">
        <label for="to">-</label>
        <input class="time-to" type="text" id="to" name="to" placeholder="选择时间">
        <a class="search-btn" href="#">搜索</a>
    </div>
    <table class="w100 recharge-history">
        <thead>
        <tr>
            <th>订单号</th>
            <th>充值金额（元）</th>
            <th>交易日期</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1412131725122219</td>
            <td>108.00</td>
            <td>2014-12-20</td>
            <td><p class="recharge-history-wait">已完成</p></td>
        </tr>
        <tr>
            <td>1412131725122219</td>
            <td>108.00</td>
            <td>2014-12-20</td>
            <td><p class="recharge-history-wait">已完成</p></td>
        </tr>
        <tr>
            <td>1412131725122219</td>
            <td>108.00</td>
            <td>2014-12-20</td>
            <td><p class="recharge-history-wait">已完成</p></td>
        </tr>
        </tbody>
    </table>
    <div class="pager-box">
        <div class="right" id="pager">
            <ul class="pagination-list left">
                <li class="selected"><a href="javascript:void(0)">1</a></li>
                <li><a href="javascript:void(0)" onclick="currentPage(2)">2</a></li>
                <li><a href="javascript:void(0)" onclick="currentPage(3)">3</a></li>
                <li><a href="javascript:void(0)" onclick="currentPage(4)">4</a></li>
                <li class="pagination-disabled"><a href="javascript:void(0)">···</a></li>
                <li><a href="javascript:void(0)" onclick="currentPage(10)">10</a></li>
                <li class="pagination-list-next"><a href="javascript:void(0)" onclick="next()"><span class="pagination-list-next"></span></a></li>
            </ul>
            <div class="pagination-jump left">
                <input class="yahei" type="text" id="inputSearchNumber">
                <a class="btn btn-primary" href="javascript:inputSearch(10);">确&nbsp;定</a>
            </div>
        </div>
    </div>
</div>
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