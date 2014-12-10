<footer class="footer yahei">
    <div class="wrap clearfix relative">
        <div class="footer-box footer-box-left left">
            <ul class="footer-site-map clearfix">
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/aboutus.html">关于出国去</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/conviction.html">加入我们</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/contactus.html">联系我们</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/help.html">帮助中心</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/declare.html">法律声明</a>
                </li>

                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/link.html">友情链接</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/feedback.html">意见反馈</a>
                </li>
                <li>
                    <a target="_blank" href="http://www.chuguoqu.com/business.html">Business Cooperation</a>
                </li>
            </ul>
            <div class="copyrights footer-box">
                <p>Copyright &#169; 2013 出国去chuguoqu.com All rights reserved 厦门寰联网络科技有限公司 闽ICP备12023338号-1</p>
                <p>出国去网站独家内容运营商：厦门寰远信息咨询有限公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;唯一指定的境外旅游服务策供商：厦门博游旅行社有限公司</p>
                <div class="footer-contact">
                    <p class="footer-contact-phone">400-812-5161</p>
                    <p>周一至周日：08:00-23:00</p>
                </div>
            </div>
            <div class="certifications">
                <a href="http://search.cxwz.org/cert/l/CX20121219002106002161" target="_blank" rel="nofollow"><img
                        src="http://www.chuguoqu.com/images/certifications/1.gif" alt="诚信网站"></a>
                <a href="https://ss.cnnic.cn/verifyseal.dll?sn=e12121235020037608000000" target="_blank" rel="nofollow"><img
                        src="http://www.chuguoqu.com/images/certifications/2.gif" alt="可信网站"></a>
                <a href="http://pinggu.zx110.org/review_url_chuguoqu.com" target="_blank" title="可信评估"
                   rel="nofollow"><img src="http://www.chuguoqu.com/images/certifications/3.gif" alt="可信评估"></a>
                <a href="http://www.itrust.org.cn/yz/pjwx.asp?wm=1051185455" target="_blank" rel="nofollow"><img
                        src="http://www.chuguoqu.com/images/certifications/4.gif" alt="网信网站"></a>
                <a href="http://www.chuguoqu.com/auth_pata.html" target="_blank" rel="nofollow"><img
                        src="http://www.chuguoqu.com/images/certifications/5.gif" alt="PATA亚太旅游协会"></a>
                <a href="http://si.trustutn.org/info?sn=821140221001660467290" target="_blank" rel="nofollow"><img
                        src="http://www.chuguoqu.com/images/certifications/7.gif" alt="360认证联盟"></a>
            </div>
        </div>
        <a id="feedBackBtn" target="_blank" class="footer-feedback" href="http://www.chuguoqu.com/feedback.html">
            <span>意见反馈</span>
        </a>
        <a id="goToTop" class="footer-to-top hide" href="javascript:;">
            <span>返回顶部</span>
        </a>
    </div>
</footer>
<script type="text/javascript">
    $(function () {
        var currentTab = $("#select-tab").attr("data-selected-tab");
        $("#" + currentTab).addClass("selected");

        function userControlHide(){
            $("#headerUserControl,.header-user-arrow").hide();
        }
        var hoverTimer, outTimer;
        $("#headerUserInfo,#headerUserArrow,#headerUserControl").hover(function(){
            clearTimeout(outTimer);
            $("#headerUserControl,.header-user-arrow").show();
        },function(){
            clearTimeout(hoverTimer);
            outTimer = setTimeout(userControlHide, 300);
        });
        $("#headerUserControl").find("li:first").hover(function(){
            $("#headerUserInfo").find(".header-user-arrow").addClass("header-user-arrow-hover");
        },function(){
            $("#headerUserInfo").find(".header-user-arrow").removeClass("header-user-arrow-hover");
        });
        $('#headerSearch').focus(function () {
            if (this.value == "目的地/行程/产品名称") {
                this.value = "";
            }
            $(this).addClass("focus");
        });
        $('#headerSearch').blur(function () {
            if (this.value == "目的地/行程/产品名称" || this.value == "") {
                this.value = "目的地/行程/产品名称";
                $(this).removeClass("focus");
            }
        });
        $("#goToTop").click(function(){
            $("body,html").animate({scrollTop:0},500);
            return false;
        });
    });
</script>
