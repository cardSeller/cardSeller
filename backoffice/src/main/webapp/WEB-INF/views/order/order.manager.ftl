﻿﻿<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head>
    <title>订单管理</title>
</head>
<body>
<div id="select-tab" data-selected-tab="tab_700">
    <div class="data-content breadcrumb">
        <h1>订单管理-订单信息</h1>
    </div>
    <div class="col-md-12">
        <div class="alert alert-yellow">
            <p  class="alert-text">总订单数：<strong>${total!}</strong></p>
        </div>
        <div class="search-options-box">
            <div class="custom-top-search">
                <form id="searchOrdersForm" class="search-providers-form clearfix" method="POST" action="${absoluteContextPath}/order/search" data-callback="getOrdersCallBack">
                    <div class="form-group left order-time">
                        <label>订单时间：</label>
                        <div class="clearfix">
                            <div class="datepickerBox left">
                                <input class="form-control" type="text" readonly name="orderTimeFrom" id="orderTimeFrom"/>
                            </div>
                            <span class="dateTo center-block">-</span>
                            <div class="datepickerBox left">
                                <input class="form-control" type="text" readonly name="orderTimeTo" id="orderTimeTo"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-xs-2">
                        <label>会员名：</label>
                        <input class="form-control" type="text" id="memberName" name="memberName"/>
                    </div>
                    <input type="hidden" id="pageIndex" name="pageIndex" value="1"/>
                    <input type="hidden" id="pageSize" name="pageSize" value="20"/>

                    <div class="btn-group search-btn-box">
                        <a href="javascript:searchOrders();" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查&nbsp;找</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="clearfix" id="ordersList" style="<#if orderses?exists&&orderses?size!=0>display: block<#else>display: none</#if>">
            <div class="alert alert-success displayNone" id="totalNumberMsg">总条数：<strong id="totalNumber">${totalNumber!}</strong></div>
            <div class="panel panel-default member-manager-list">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            订单号
                        </th>
                        <th>
                            会员名
                        </th>
                        <th>
                            产品名
                        </th>
                        <th>
                            产品面值
                        </th>
                        <th>
                            产品数量
                        </th>
                        <th>
                            总金额
                        </th>
                        <th>
                            订单日期
                        </th>
                        <th>
                            订单状态
                        </th>
                        <th>
                            操作
                        </th>
                    </tr>
                    </thead>
                    <tbody id="resultList">
                    <#list orderses as orders>
                    <tr>
                        <td>
                        ${orders.orderNumber!}
                        </td>
                        <td>
                        ${orders.member.name!}
                        </td>
                        <td>
                        ${orders.item.name!}
                        </td>
                        <td>
                        ${orders.itemPrice.faceValue?c}
                        </td>
                        <td>
                        ${orders.itemCount?c}
                        </td>
                        <td>
                        ${orders.total?c}
                        </td>
                        <td>
                        ${orders.orderDate}
                        </td>
                        <td>
                        ${orders.orderStatus!}
                        </td>
                        <td>
                            <#if orders.orderStatus == "已付款">
                                <a href="${absoluteContextPath}/order/process/${orders.orderNumber}" onclick="if(confirm('确定已经发货了给${orders.member.name!}?')==false)return false;">交易完成</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="pager-box right">
                <div id="pager" class="pager-control"></div>
            </div>
        </div>
        <div id="noOrdersList" class="alert alert-danger displayNone">
            没有符合条件的记录，请重试。
        </div>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/pagination.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/order.manage.js"></script>
</body>
</html>