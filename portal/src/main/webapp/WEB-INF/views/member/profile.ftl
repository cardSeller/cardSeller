<!DOCTYPE html>
<html>
<head lang="zh">
    <title>会员中心-修改个人信息</title>
</head>
<body>
<div class="member-container left">
    <p class="member-title">
        修改个人信息
    </p>
    <div class="member-change">
        <form action="${absoluteContextPath}/member/saveProfile" method="post">
            <table>
                <tr>
                    <td class="member-change-label">
                        会员名：
                    </td>
                    <td>
                    <#if member??>${member.name!}</#if>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        真实姓名：
                    </td>
                    <td>
                        <input id="realName" name="realName" type="text" value="<#if member??>${member.realName!}</#if>"/>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        身份证：
                    </td>
                    <td>
                        <input id="identity" name="identity" type="text" value="<#if member??>${member.identity!}</#if>"/>
                        <div id="profileErrorIdentity"></div>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        手机号码：
                    </td>
                    <td>
                        <input id="phone" name="phone" type="text" value="<#if member??>${member.phone!}</#if>"/>
                        <div id="profileErrorPhone"></div>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label"></td>
                    <td>
                        <a class="member-change-save" href="javascript:saveProfile();">保存</a>
                        <div id="profileMessage"></div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/profile.js"></script>
</body>