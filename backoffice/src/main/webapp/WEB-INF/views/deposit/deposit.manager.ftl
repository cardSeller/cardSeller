﻿﻿<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head>
    <title>充值纪录管理</title>
</head>
<body>
<div id="select-tab" data-selected-tab="tab_700">
    <div class="data-content breadcrumb">
        <h1>充值纪录管理-充值纪录信息</h1>
    </div>
    <div class="col-md-12">
        <div class="alert alert-yellow">
            <input type="hidden" id="total" value="${total?c}"/>
            <p  class="alert-text">总充值纪录数：<strong>${total!}</strong></p>
        </div>
        <div class="search-options-box">
            <div class="custom-top-search">
                <form id="searchDepositsForm" class="search-providers-form clearfix" method="POST" action="${absoluteContextPath}/deposit/search" data-callback="getDepositsCallBack">
                    <div class="form-group left order-time">
                        <label>充值时间：</label>
                        <div class="clearfix">
                            <div class="datepickerBox left">
                                <input class="form-control" type="text" readonly name="depositTimeFrom" id="depositTimeFrom"/>
                            </div>
                            <span class="dateTo center-block">-</span>
                            <div class="datepickerBox left">
                                <input class="form-control" type="text" readonly name="depositTimeTo" id="depositTimeTo"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group col-xs-2">
                        <label>会员名：</label>
                        <input class="form-control" type="text" id="memberName" name="memberName"/>
                    </div>
                    <input type="hidden" id="pageIndex" name="pageIndex" value="1"/>
                    <input type="hidden" id="pageSize" name="pageSize" value="8"/>

                    <div class="btn-group search-btn-box">
                        <a href="javascript:searchDeposits();" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查&nbsp;找</a>
                    </div>
                </form>
            </div>
        </div>
        <div class="clearfix" id="depositsList" style="<#if deposits?exists&&deposits?size!=0>display: block<#else>display: none</#if>">
            <div class="alert alert-success displayNone" id="totalNumberMsg">总条数：<strong id="totalNumber">${totalNumber!}</strong></div>
            <div class="panel panel-default member-manager-list">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            充值纪录ID
                        </th>
                        <th>
                            会员名
                        </th>
                        <th>
                            充值金额
                        </th>
                        <th>
                            充值日期
                        </th>
                        <th>
                            充值状态
                        </th>
                    </tr>
                    </thead>
                    <tbody id="resultList">
                    <#list deposits as deposit>
                    <tr>
                        <td>
                            ${deposit.id?c}
                        </td>
                        <td>
                            ${deposit.member.name!}
                        </td>
                        <td>
                            ${deposit.total?c}
                        </td>
                        <td>
                            ${deposit.depositDate}
                        </td>
                        <td>
                            ${deposit.depositStatus!}
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
        <div id="noDepositsList" class="alert alert-danger displayNone">
            没有符合条件的记录，请重试。
        </div>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/pagination.js"></script>
<script type="text/javascript" src="${absoluteContextPath}/js/deposit.manage.js"></script>
</body>
</html>