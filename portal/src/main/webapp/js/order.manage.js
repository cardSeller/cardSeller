$(document).ready(function () {
    pagination(null, $("#total").val(), $("#pageSize").val());
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
        $("#orderList").show();
        var resultReturnList = [];
        for (var i = 0; i < resultList.length; i++) {
            var result = [];
            result.push(resultList[i].orderNumber);
            result.push(resultList[i].item.name);
            result.push(resultList[i].itemPrice.faceValue);
            result.push(resultList[i].itemPrice.price);
            result.push(resultList[i].itemCount);
            result.push(resultList[i].total);
            result.push(format(new Date(resultList[i].orderDate), 'yyyy-MM-dd hh:mm:ss'));
            result.push("<p class=\"recharge-history-wait\">" + resultList[i].orderStatus + "</p>");
            if(resultList[i].orderStatus == "待付款") {
                result.push("<a href=\"javascript:payOrder('" + resultList[i].orderNumber + "','" +resultList[i].item.id + "','" + resultList[i].itemPrice.id + "','" + resultList[i].total + "','" + resultList[i].itemCount + "');\">付款</a>");
            }
            resultReturnList.push(result);
        }
        pagination(resultReturnList, data.totalNumber, data.fetchSize);
    } else {
        $("#orderList").hide();
        $("#noOrdersList").show();
    }
}

function search() {
    var data = {};
    data.memberId = $("#searchOrdersForm").find("input[name='memberId']").val();
    data.orderTimeFrom = $("#searchOrdersForm").find("input[name='orderTimeFrom']").val();
    data.orderTimeTo = $("#searchOrdersForm").find("input[name='orderTimeTo']").val();
    data.pageIndex = $("#pageIndex").val();
    data.pageSize = $("#pageSize").val();
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: golbalRootUrl + "/member/searchOrder",
        data: JSON.stringify(data),
        success: function (result) {
            getOrdersCallBack(result);
        },
        error: function (xhr) {
            alertErrorMsgPopups("查询订单出错");
        }
    });
}

function payOrder(orderNumber,itemId,itemPriceId,total,count) {
    var data = {};
    data.orderNumber = orderNumber;
    data.itemId = itemId;
    data.itemPriceId = itemPriceId;
    data.total = total;
    data.count = count;
    postcall(golbalRootUrl + "/item/submitOrder", data);
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