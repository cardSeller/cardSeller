<!DOCTYPE html>
<#assign shiro=JspTaglibs["/WEB-INF/taglib/shiro.tld"] />
<html>
<head lang="zh">
    <meta charset="UTF-8">
    <title>快充商城</title>
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css"/>
    <script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="${absoluteContextPath}/js/form.js"></script>
</head>
<body>
<div class="c-nav">
    <div class="wrap">
        <ul id="c-nav" class="clearfix">
            <li class="nav-hot selected">
                <a href="#">热卖产品</a>
            </li>
            <li>
                <a href="#">按字母检索 A--H</a>
                <div class="drop-menu clearfix">
                    <p class="drop-menu-item">
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                    </p>
                    <p class="drop-menu-item">
                        <span class="serial-num">D</span><a href="#">电魂一卡通</a>
                    </p>
                    <p class="drop-menu-item">
                        <span class="serial-num">E</span><a href="#">广游直充</a>
                        <span class="serial-num">F</span><a href="#">畅游直充</a>
                    </p>
                    <p class="drop-menu-item">
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                        <span class="serial-num">C</span><a href="#">畅游直充</a>
                    </p>
                </div>
            </li>
            <li>
                <a href="#">按字母检索 I--P</a>
                <div class="drop-menu clearfix">
                    <p class="drop-menu-item">
                        <span class="serial-num">C</span><a href="#">电魂一卡通</a>
                    </p>
                </div>
            </li>
            <li>
                <a href="#">按字母检索 Q--Z</a>
                <div class="drop-menu clearfix">
                    <p class="drop-menu-item">
                        <span class="serial-num">C</span><a href="#">广游直充</a>
                    </p>
                    <p class="drop-menu-item">
                        <span class="serial-num">C</span><a href="#">电魂一卡通</a>
                    </p>
                </div>
            </li>
        </ul>
    </div>
</div>
<div class="p-box">
    <div class="wrap relative">
        <ul class="p-list clearfix" id="p-list">
            <li class="p-item">
                <a class="p-url" href="http://www.baidu.com/">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/changyou.jpg" alt="畅游"/>
                    </div>
                    <p class="p-name">畅游直充</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="http://www.google.com/">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/qq.jpg" alt="腾讯QQ卡"/>
                    </div>
                    <p class="p-name">腾讯QQ卡</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="#">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/junwang.jpg" alt="骏网一卡通"/>
                    </div>
                    <p class="p-name">骏网一卡通</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="#">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/zgdx.jpg" alt="中国电信全国通用"/>
                    </div>
                    <p class="p-name">中国电信全国通用</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="#">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/zglt.jpg" alt="中国联通全国通用"/>
                    </div>
                    <p class="p-name">中国联通全国通用</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="#">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/juren.jpg" alt="巨人一卡通"/>
                    </div>
                    <p class="p-name">巨人一卡通</p>
                </a>
            </li>
            <li class="p-item">
                <a class="p-url" href="#">
                    <div class="p-pic">
                        <img src="${absoluteContextPath}/images/products/sdo.jpg" alt="盛大一卡通"/>
                    </div>
                    <p class="p-name">盛大一卡通</p>
                </a>
            </li>
        </ul>
        <div class="quick-buy" id="quick-buy">
            <p class="quick-buy-title">快速充值</p>
            <div class="quick-kind">
                <p class="quick-kind-btn" id="openbtn1">请选择游戏</p>
                <ul class="quick-kind-list">
                    <li>巨人一卡通</li>
                    <li>盛大一卡通</li>
                    <li>中国联通全国通用</li>
                    <li>中国电信全国通用</li>
                    <li>巨人一卡通</li>
                    <li>盛大一卡通</li>
                    <li>中国联通全国通用</li>
                    <li>中国电信全国通用</li>
                </ul>
            </div>
            <div class="quick-value">
                <p class="quick-value-btn" id="openbtn2">请选择面值</p>
                <ul class="quick-value-list">
                    <li>50元</li>
                    <li>100元</li>
                    <li>150元</li>
                    <li>200元</li>
                    <li>250</li>
                    <li>300</li>
                    <li>350</li>
                    <li>400</li>
                </ul>
            </div>
            <a class="quick-submit" href="#">购买</a>
        </div>
    </div>
</div>
<div class="bottom-banner wrap">
    <img src="${absoluteContextPath}/images/bottom-banner.jpg" alt="不刷信誉!!不招兼职!!"/>
</div>
<script type="text/javascript">
    var openbtn1 = document.getElementById("openbtn1");
    var openbtn2 = document.getElementById("openbtn2")
    document.onclick = function (event) {
        var e = event || window.event; //兼容ie和非ie的event
        var aim = e.srcElement || e.target; //兼容ie和非ie的事件源
        if (aim != openbtn1 && aim != openbtn2) {
            $(".quick-kind-list,.quick-value-list").hide();
        }
    }
    $(function(){
        $("#c-nav li").hover(function(){
            $("#c-nav .drop-menu").hide();
            $(this).find(".drop-menu").show();
        },function(){
            $("#c-nav .drop-menu").hide();
        });
        $("#p-list").find(".p-item").eq(2).css({"margin-right":"100px"});
        $(".quick-kind-btn").click(function(){
            $(".quick-value-list").hide();
            $(this).next().toggle();
        });
        $(".quick-value-btn").click(function(){
            $(".quick-kind-list").hide();
            $(this).next().toggle();
        });
        $(".quick-kind-list").find("li").click(function(){
            var thisVal = $(this).text();
            $(".quick-kind-btn").text(thisVal).addClass("selected");
            $(this).parent().hide();
        });
        $(".quick-value-list").find("li").click(function(){
            var thisVal = $(this).text();
            $(".quick-value-btn").text(thisVal).addClass("selected");
            $(this).parent().hide();
        });
        $(".p-item").hover(function(){
            var thisName = $(this).find(".p-name").text();
            var thisUrl = $(this).find(".p-url").attr("href");
            $(this).append("<div class=\"p-item-hover\" onclick="+"javascript:window.open("+"\""+thisUrl+""+"\")><p>"+thisName+"</p><p>查看详情</p></div>");
        },function(){
            $(this).find(".p-item-hover").remove();
        });
    });
</script>
</body>
</html>