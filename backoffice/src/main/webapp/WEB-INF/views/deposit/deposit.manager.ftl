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
            <p  class="alert-text">总充值纪录数：<strong>${total!}</strong></p>
        </div>
        <div class="clearfix" id="membersList" style="<#if deposits?exists&&deposits?size!=0>display: block<#else>display: none</#if>">
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
                            ${deposit.depositStatus.chineseDescription!}
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
    </div>
</div>
</body>
</html>