<!DOCTYPE html>
<html>
<head lang="zh">
    <title>快充商城-商品详情</title>
</head>
<body>
<div class="container">
    <div class="wrap relative">
        <div class="p-detail">
            <div class="buy-step-box">
                <ul class="clearfix">
                    <li class="buy-step buy-step-1">填写购买信息</li>
                    <li class="buy-step buy-step-2">确认订单</li>
                    <li class="buy-step buy-step-3">充值成功5分钟内到账</li>
                </ul>
            </div>
            <div class="p-detail-box clearfix">
                <div class="p-detail-img left">
                    <img src="${absoluteContextPath}/images/products/${item.imageUrl}" alt="${item.name!}"/>
                </div>
                <form id="submitOrderForm" action="${absoluteContextPath}/item/submitOrder" method="post">
                    <input type="hidden" id="itemId" name="itemId" value="${item.id}">
                    <input type="hidden" id="itemPriceId" name="itemPriceId" value="${priceId?c}">
                    <input type="hidden" id="total" name="total" value="${price?c}">
                    <input type="hidden" id="price" value="${price?c}">
                    <div class="p-detail-content left">
                        <p class="p-detail-title">${item.name!}</p>
                        <div class="p-detail-describe">
                            <p>商品名称：${item.name!} <#if item.description??>点卡描述：${item.description}</#if></p>
                        </div>
                        <p id="priceP" class="p-detail-price">￥${price?c}</p>
                        <ul class="p-options">
                            <li class="p-detail-type">商品类型：直充商品</li>
                            <li id="p-value" class="p-detail-value clearfix">
                                <span class="left">商品面值：</span>
                                <#list item.itemPriceList as itemPrice>
                                    <a <#if itemPrice.id == priceId>class="selected"</#if> href="javascript:changePrice('${itemPrice.id}','${itemPrice.price}');">${itemPrice.faceValue?c}元</a>
                                </#list>
                            </li>
                            <li class="p-detail-num clearfix">
                                <span class="left">购买数量：</span>
                                <a href="javascript:void(0);" class="minus-buy">-</a><input class="buy-num" name="count" type="text" value="1" /><a href="javascript:void(0);" class="add-buy">+</a>
                            </li>
                        </ul>
                        <div class="buy-btn-box clearfix">
                            <a href="javascript:void(0);" class="buy-btn" onclick='$("#submitOrderForm").submit()'>立即充值</a>
                            <p id="totalP" class="p-total">合计：￥${price?c}</p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/item.js"></script>
<script type="text/javascript">
    $(function(){
        $("#c-nav li").hover(function(){
            $("#c-nav .drop-menu").hide();
            $(this).find(".drop-menu").show();
        },function(){
            $("#c-nav .drop-menu").hide();
        });
        $("#p-value").find("a").click(function(){
            $(this).addClass("selected").siblings().removeClass("selected");
        });
        $(".minus-buy").click(function(){
            var buyNum = $(".buy-num").val();
            var priceMinus = $("#price").val();
            if(buyNum>=2){
                var countMinus = parseInt(buyNum)-1;
                $(".buy-num").val(countMinus);
                priceMinus = parseFloat(priceMinus);
                $("#totalP").html("合计：￥" + countMinus*priceMinus);
                $("#total").val(countMinus*priceMinus);
            }else{
                return false;
            }
        });
        $(".add-buy").click(function(){
            var buyNum = $(".buy-num").val();
            var priceAdd = $("#price").val();
            var countAdd = parseInt(buyNum)+1;
            $(".buy-num").val(parseInt(countAdd));
            priceAdd = parseFloat(priceAdd);
            $("#totalP").html("合计：￥" + countAdd*priceAdd);
            $("#total").val(countAdd*priceAdd);
        });
    });
</script>
</body>