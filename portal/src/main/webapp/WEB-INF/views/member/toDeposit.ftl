<!DOCTYPE html>
<html>
<head lang="zh">
    <title>会员中心-充值</title>
</head>
<body>
<div class="member-container left">
    <p class="member-title">
        用户充值
    </p>
    <div class="member-change">
        <form action="http://pay.coofun.cc/payment/deposit" method="post">
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
                    <td class="member-change-label" style="vertical-align: top;">
                        充值方式：
                    </td>
                    <td>
                        <div id="payTpe" class="pay-type clearfix">
                            <p class="selected">
                                <a href="javascript:void(0)" data-value="CHINAPAY" title="银行转账"><img src="${absoluteContextPath}/images/ylzf.jpg" alt="银联支付"></a>
                            </p>
                            <p>
                                <a href="javascript:void(0)" data-value="HCZF" title="汇潮支付"><img src="${absoluteContextPath}/images/hczf.jpg" alt="汇潮支付"></a><br/>
                                建设银行限额5000
                            </p>
                        </div>
                        <#--<select name="payType" id="payTpe">-->
                            <#--<option value="CHINAPAY">银行转账</option>-->
                            <#--<option value="HCZF">汇潮支付建设银行限额5000</option>-->
                        <#--</select>-->
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
<script type="text/javascript">
    $(function(){
        $(".pay-type").find("a").click(function(){
            $(this).parent().addClass("selected").siblings().removeClass("selected");
        });
    });
</script>
</body>