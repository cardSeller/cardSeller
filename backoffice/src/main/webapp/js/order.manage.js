$(document).ready(function () {
    pagination(null, $("#total").val(), $("#pageSize").val());
});
$(function () {
    $("#orderTimeFrom").blur();
    $("#orderTimeFrom").datepicker({
        onSelect: function (dateText, inst) {
            $("#orderTimeTo").datepicker("option", "minDate", new Date(dateText.replace('/', ',')));
            $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        },
        showButtonPanel: true,
        changeMonth: true,
        changeYear: true
    });
    $("#orderTimeTo").datepicker({
        onSelect: function (dateText, inst) {
            $("#orderTimeFrom").datepicker("option", "maxDate", new Date(dateText.replace('/', ',')));
            $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
        },
        defaultDate: "+1w",
        showButtonPanel: true,
        changeMonth: true,
        changeYear: true
    });
});

function searchOrders() {
    $("#pager").text("");
    $("#pageIndex").val("1");
    $('#searchOrdersForm').submitAjax({
        callback: function (data) {
            getOrdersCallBack(data);
        }
    });
}

function getOrdersCallBack(data) {
    $("#resultList").find("tr").remove();
    var resultList = data.ordersList;
    if (resultList != null && resultList.length > 0) {
        $("#noOrdersList").hide();
        $("#ordersList").show();
        $("#totalNumber").html(data.totalNumber);
        var resultReturnList = [];
        for (var i = 0; i < resultList.length; i++) {
            var result = [];
            result.push(resultList[i].orderNumber);
            result.push(resultList[i].member.name);
            result.push(resultList[i].item.name);
            result.push(resultList[i].itemPrice.faceValue);
            result.push(resultList[i].itemPrice.price);
            result.push(resultList[i].itemCount);
            result.push(resultList[i].total);
            result.push(format(new Date(resultList[i].orderDate), 'yyyy-MM-dd hh:mm:ss'));
            result.push(resultList[i].orderStatus);
            if(resultList[i].orderStatus == '已付款') {
                result.push("<a href='" + golbalRootUrl + "/order/process/" + resultList[i].orderNumber + "' onclick=\"if(confirm('确定已经发货了给" + resultList[i].member.name + "?')==false)return false;\">交易完成</a>");
            } else {
                result.push("");
            }
            resultReturnList.push(result);
        }
        pagination(resultReturnList, data.totalNumber, data.fetchSize);
        $('.icon-sale').tooltip({
            html: true
        });
    } else {
        $("#ordersList").hide();
        $("#noOrdersList").show();
    }
}

function search() {
    var data = {};
    data.memberName = $("#searchOrdersForm").find("input[name='memberName']").val();
    data.orderTimeFrom = $("#searchOrdersForm").find("input[name='orderTimeFrom']").val();
    data.orderTimeTo = $("#searchOrdersForm").find("input[name='orderTimeTo']").val();
    data.pageIndex = $("#pageIndex").val();
    data.pageSize = $("#pageSize").val();
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: golbalRootUrl + "/order/search",
        data: JSON.stringify(data),
        success: function (result) {
            getOrdersCallBack(result);
        },
        error: function (xhr) {
            alertErrorMsgPopups("查询订单出错");
        }
    });
}