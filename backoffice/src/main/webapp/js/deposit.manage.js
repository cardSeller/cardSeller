$(document).ready(function () {
    pagination(null, $("#total").val(), $("#pageSize").val());
});
$(function () {
    $("#depositTimeFrom").blur();
    $("#depositTimeFrom").datepicker({
        onSelect: function (dateText, inst) {
            $("#depositTimeTo").datepicker("option", "minDate", new Date(dateText.replace('/', ',')));
            $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        },
        showButtonPanel: true,
        changeMonth: true,
        changeYear: true
    });
    $("#depositTimeTo").datepicker({
        onSelect: function (dateText, inst) {
            $("#depositTimeFrom").datepicker("option", "maxDate", new Date(dateText.replace('/', ',')));
            $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        },
        defaultDate: "+1w",
        showButtonPanel: true,
        changeMonth: true,
        changeYear: true
    });
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
    var resultList = data.depositList;
    if (resultList != null && resultList.length > 0) {
        $("#noDepositsList").hide();
        $("#depositsList").show();
        $("#totalNumber").html(data.totalNumber);
        var resultReturnList = [];
        for (var i = 0; i < resultList.length; i++) {
            var result = [];
            result.push(resultList[i].id);
            result.push(resultList[i].member.name);
            result.push(resultList[i].total);
            result.push(format(new Date(resultList[i].depositDate), 'yyyy-MM-dd hh:mm:ss'));
            result.push(resultList[i].depositStatus);
            resultReturnList.push(result);
        }
        pagination(resultReturnList, data.totalNumber, data.fetchSize);
        $('.icon-sale').tooltip({
            html: true
        });
    } else {
        $("#depositsList").hide();
        $("#noDepositsList").show();
    }
}

function search() {
    var data = {};
    data.memberName = $("#searchDepositsForm").find("input[name='memberName']").val();
    data.depositTimeFrom = $("#searchDepositsForm").find("input[name='depositTimeFrom']").val();
    data.depositTimeTo = $("#searchDepositsForm").find("input[name='depositTimeTo']").val();
    data.pageIndex = $("#pageIndex").val();
    data.pageSize = $("#pageSize").val();
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: golbalRootUrl + "/deposit/search",
        data: JSON.stringify(data),
        success: function (result) {
            getDepositsCallBack(result);
        },
        error: function (xhr) {
            alertErrorMsgPopups("查询充值记录出错");
        }
    });
}