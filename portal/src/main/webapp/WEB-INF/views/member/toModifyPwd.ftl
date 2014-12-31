<!DOCTYPE html>
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>会员中心-修改密码</title>
</head>
<body>
<div class="member-container left">
    <p class="member-title">
        修改密码
    </p>
    <div class="member-change">
        <form id="modifyPwdForm" action="${absoluteContextPath}/member/modifyPwd" method="post">
            <table>
                <tr>
                    <td class="member-change-label">
                        原始密码：
                    </td>
                    <td>
                        <input id="pwd" name="pwd" type="password"/>
                        <div id="errorPwd"></div>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        新密码：
                    </td>
                    <td>
                        <input id="newPwd" name="newPwd" type="password"/>
                        <div id="errorNewPwd"></div>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        密码确认：
                    </td>
                    <td>
                        <input id="confirmNewPwd" name="confirmNewPwd" type="password"/>
                        <div id="errorConfirmNewPwd"></div>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label"></td>
                    <td>
                        <a class="member-change-save" href="javascript:savePwd();">保存</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/modifyPwd.js"></script>
</body>