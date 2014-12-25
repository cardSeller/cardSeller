<div class="member-container left">
    <p class="member-title">
        购买充值记录
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
        <tbody>
        <tr>
            <td>1412131725122219</td>
            <td>盛大直冲</td>
            <td>100</td>
            <td>108.00</td>
            <td>1</td>
            <td>108.00</td>
            <td>2014-12-20</td>
            <td><p class="recharge-history-wait">未支付</p></td>
            <td><a class="recharge-history-pay" href="#">付款</a></td>
        </tr>
        <tr>
            <td>1412131725122200</td>
            <td>盛大直冲</td>
            <td>500</td>
            <td>508.00</td>
            <td>5</td>
            <td>108.00</td>
            <td>2014-12-21</td>
            <td><p class="recharge-history-success">已支付</p></td>
            <td></td>
        </tr>
        <tr>
            <td>1412131725122219</td>
            <td>盛大直冲</td>
            <td>100</td>
            <td>108.00</td>
            <td>1</td>
            <td>108.00</td>
            <td>2014-12-20</td>
            <td><p class="recharge-history-wait">未支付</p></td>
            <td><a class="recharge-history-pay" href="#">付款</a></td>
        </tr>
        <tr>
            <td>1412131725122200</td>
            <td>盛大直冲</td>
            <td>500</td>
            <td>508.00</td>
            <td>5</td>
            <td>108.00</td>
            <td>2014-12-21</td>
            <td><p class="recharge-history-success">已支付</p></td>
            <td></td>
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