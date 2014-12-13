﻿﻿<!doctype html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head>
    <title>产品管理</title>
</head>
<body>
<div id="select-tab" data-selected-tab="tab_700">
    <div class="data-content breadcrumb">
        <h1>产品管理-产品信息</h1>
    </div>
    <div class="col-md-12">
        <div class="alert alert-yellow">
            <p  class="alert-text">总产品数：<strong>${total!}</strong></p>
        </div>
        <div class="clearfix" id="membersList" style="<#if items?exists&&items?size!=0>display: block<#else>display: none</#if>">
            <div class="panel panel-default member-manager-list">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>
                            产品ID
                        </th>
                        <th>
                            产品名
                        </th>
                        <th>
                            产品图片
                        </th>
                        <th>
                            产品面值及价格
                        </th>
                        <th>
                            产品描述
                        </th>
                    </tr>
                    </thead>
                    <tbody id="resultList">
                    <#list items as item>
                    <tr>
                        <td>
                            ${item.id?c}
                        </td>
                        <td>
                            ${item.name!}
                        </td>
                        <td>
                            <img width="40" height="40" src="${absoluteContextPath}/img/card/${item.imageUrl!}" alt="${item.name!}">
                        </td>
                        <td>
                            <#list item.itemPriceList as itemPrice>
                            面值:${itemPrice.faceValue} 价格:${itemPrice.price} <br>
                            </#list>
                        </td>
                        <td>
                            ${item.description!}
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