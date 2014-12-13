﻿﻿<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head>
    <title>会员管理</title>
</head>
<body>
<div id="select-tab" data-selected-tab="tab_700">
    <div class="data-content breadcrumb">
        <h1>会员管理-会员信息</h1>
    </div>
    <div class="col-md-12">
        <div class="alert alert-yellow">
            <p  class="alert-text">总注册用户：<strong>${total!}</strong></p>
        </div>
        <div class="clearfix" id="membersList" style="<#if members?exists&&members?size!=0>display: block<#else>display: none</#if>">
            <div class="panel panel-default member-manager-list">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            注册日期
                        </th>
                        <th>
                            注册IP
                        </th>
                        <th>
                            会员名
                        </th>
                        <th>
                            真实姓名
                        </th>
                        <th>
                            手机号码
                        </th>
                        <th>
                            身份证号
                        </th>
                        <th>
                            余额
                        </th>
                        <th>
                            最后登录日期
                        </th>
                        <th>
                            最后登录IP
                        </th>
                    </tr>
                    </thead>
                    <tbody id="resultList">
                    <#list members as member>
                    <tr>
                        <td>
                        ${member.registerTime}
                        </td>
                        <td>
                        ${member.registerIp!}
                        </td>
                        <td>
                        ${member.name!}
                        </td>
                        <td>
                            <#if member.realName??>
                            ${member.realName!}
                            <#else>
                                /
                            </#if>
                        </td>
                        <td>
                            <#if member.phone??>
                            ${member.phone!}
                            <#else>
                                /
                            </#if>
                        </td>
                        <td>
                            ${member.identity!}
                        </td>
                        <td>
                            ${member.balance}
                        </td>
                        <td>
                            ${member.lastLoginTime}
                        </td>
                        <td>
                            ${member.lastLoginIp!}
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