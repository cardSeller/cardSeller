<div class="container">
    <div class="wrap">
        <div class="register-box clearfix">
            <form id='register-form' class="register-form left" action='${absoluteContextPath}/regist' method='post'>
                <fieldset>
                    <legend class="hide">注册</legend>
                    <p class="reg-title"><span>*</span>用户名</p>
                    <div class="register-username">
                        <input class="long-text-input" id="regName" name="regName" type="text" placeholder="请输入邮箱"/>
                        <div id="regErrorUserName" class="prompt-msg"></div>
                    </div>
                    <p class="reg-title"><span>*</span>密码</p>
                    <div class="register-password">
                        <input class="long-text-input" id="pwd" name="pwd" type="password" placeholder="请输入密码"/>
                        <div id="regErrorUserPW" class="prompt-msg"></div>
                    </div>
                    <p class="reg-title"><span>*</span>确认密码</p>
                    <div class="register-password-affirm">
                        <input class="long-text-input" id="confirmPwd" type="password" placeholder="请输入确认密码"/>
                        <div id="regErrorUserAffirm" class="prompt-msg"></div>
                    </div>
                    <p class="reg-title"><span>*</span>验证码</p>
                    <div class="register-captcha clearfix">
                        <img class="login-verification-img" id="captchaImg" src="${absoluteContextPath}/getCaptcha" alt="imageCode">&nbsp;看不清？<a href="javascript:reloadCaptcha();">换一张</a>
                        <input class="input-captcha left" id="imageCode" placeholder="请输入验证码"/>
                        <div id="regErrorCaptcha" class="prompt-msg"></div>
                    </div>
                    <div class="register-btn">
                        <a href="javascript:saveRegisterInfo();">注&nbsp;册</a>
                    </div>
                </fieldset>
            </form>
            <div class="login-reg left">
                <p>已有账号？<a href="${absoluteContextPath}/login">立即登录</a></p>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${absoluteContextPath}/js/register.js"></script>