$(document).ready(function () {
    pagination(null, $("#total").val(), $("#pageSize").val());
});
function searchDeposits() {
    $("#pager").text("");
    $("#pageIndex").val("1");
    $('#searchDepositsForm').submitAjax({
        callback: function (data) {
            getDepositsCallBack(data);
        }
    });
}


function getDepositsCallBack(data) {
    $("#resultList").find("tr").remove();
    var resultList = data.deposits;
    if (resultList != null && resultList.length > 0) {
        $("#noDepositList").hide();
        $("#depositList").show();
        var resultReturnList = [];
        for (var i = 0; i < resultList.length; i++) {
            var result = [];
            result.push(resultList[i].id);
            result.push(resultList[i].total);
            result.push(format(new Date(resultList[i].depositDate), 'yyyy-MM-dd hh:mm:ss'));
            result.push(resultList[i].depositType);
            result.push("<p class=\"recharge-history-wait\">" + resultList[i].depositStatus + "</p>");
            if(resultList[i].depositStatus == "待付款") {
                result.push("<a href=\"javascript:pay('" + resultList[i].id + "','" + resultList[i].depositTypeEN + "','" + resultList[i].total + "');\">付款</a>");
            }
            resultReturnList.push(result);
        }
        pagination(resultReturnList, data.totalNumber, data.fetchSize);
    } else {
        $("#depositList").hide();
        $("#noDepositList").show();
    }
}

function search() {
    var data = {};
    data.memberId = $("#searchDepositsForm").find("input[name='memberId']").val();
    data.depositTimeFrom = $("#searchDepositsForm").find("input[name='depositTimeFrom']").val();
    data.depositTimeTo = $("#searchDepositsForm").find("input[name='depositTimeTo']").val();
    data.pageIndex = $("#pageIndex").val();
    data.pageSize = $("#pageSize").val();
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: golbalRootUrl + "/member/searchDeposit",
        data: JSON.stringify(data),
        success: function (result) {
            getDepositsCallBack(result);
        },
        error: function (xhr) {
            alertErrorMsgPopups("查询充值记录出错");
        }
    });
}

function pay(depositId,payType,total) {
    var data = {};
    data.depositId = depositId;
    data.payType = payType;
    data.total = total;
    postcall("http://pay.coofun.cc/payment/deposit", data);
}

function postcall(url,params){
    var tempform = document.createElement("form");
    tempform.action = url;
    tempform.method = "post";
    tempform.style.display="none";
    for (var x in params) {
        var opt = document.createElement("input");
        opt.name = x;
        opt.setAttribute("value",params[x]);
        tempform.appendChild(opt);
    }

    var opt = document.createElement("input");
    opt.type = "submit";
    opt.name = "postsubmit";
    tempform.appendChild(opt);
    document.body.appendChild(tempform);
    tempform.submit();
}