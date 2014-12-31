<!DOCTYPE html>
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>会员中心-充值</title>
</head>
<body>
<div class="member-container left">
    <p class="member-title">
        用户充值
    </p>
    <div class="member-change">
        <form action="${absoluteContextPath}/payment/deposit" method="post">
            <table>
                <tr>
                    <td class="member-change-label">
                        充值金额（元）：
                    </td>
                    <td>
                        <input name="total" type="text"/>&nbsp;最多输入两位小数
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label">
                        充值方式：
                    </td>
                    <td>
                        <select name="payType" id="payTpe">
                            <option value="CHINAPAY">银行转账</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="member-change-label"></td>
                    <td>
                        <input class="member-change-save" type="submit" value="充值"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>