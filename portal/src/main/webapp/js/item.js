function changePrice(priceId,price) {
    $("#itemPriceId").val(priceId);
    $("#price").val(price);
    $("#priceP").html("￥" + price);
    var buyNum = $(".buy-num").val();
    $("#totalP").html("合计：￥" + buyNum*price);
    $("#total").val(buyNum*price);
}