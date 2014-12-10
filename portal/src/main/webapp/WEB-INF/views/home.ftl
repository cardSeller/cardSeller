<div class="c-nav">
    <div class="wrap">
        <ul id="c-nav" class="clearfix">
            <li class="hot">
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
<script type="text/javascript" src="${absoluteContextPath}/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#c-nav li").hover(function(){
            $("#c-nav .drop-menu").hide();
            $(this).find(".drop-menu").show();
        },function(){
            $("#c-nav .drop-menu").hide();
        });
    });
</script>