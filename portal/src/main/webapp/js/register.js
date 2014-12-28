$(function(){
    $(".register-username input").focus(function(){
        $(this).val("");
        $("#regErrorUserName").html("");
    }).blur(function () {
        if (this.value === '') {
            $(this).val("邮箱/手机号");
            $("#regErrorUserName").html("<p>请输入邮箱</p>");
        }
        if(!isEmail(this.value)) {
            $("#regErrorUserName").html("<p>请输入正确的邮箱地址</p>");
        }
    });
    $(".register-password input").focus(function(){
        $("#regErrorUserPW").html("");
    }).blur(function () {
        if (this.value === '') {
            $("#regErrorUserPW").html("<p>请输入密码</p>");
        }
    });
    $(".register-password-affirm input").focus(function(){
        $("#regErrorUserAffirm").html("");
    }).blur(function () {
        if (this.value === '') {
            $("#regErrorUserAffirm").html("<p>请输入密码</p>");
        }
        var newPwd = $("#pwd").val();
        var confirmNewPwd = $("#confirmPwd").val();
        if (newPwd != confirmNewPwd) {
            $("#regErrorUserAffirm").html("<p>两次输入密码不一致</p>");
        }
    });
});

function reloadCaptcha() {
    $("#captchaImg").attr("src", golbalRootUrl + "/getCaptcha?date=" + new Date() + Math.floor(Math.random() * 24));
}

function saveRegisterInfo() {
    var regName = $("#regName").val();
    var imageCode = $("#imageCode").val();
    var checkRegNameCode;
    var checkImageCode;
    if(regName == "" || regName == undefined) {
        $("#regErrorUserName").html("<p>请输入邮箱</p>");
    } else {
        checkRegNameCode = checkRegNameAjax(regName);
        if(checkRegNameCode != 0) {
            $("#regErrorUserName").html("<p>此邮箱已经被注册过</p>");
        }
    }
    if(imageCode == "" || imageCode == undefined) {
        $("#regErrorCaptcha").html("<p>请输入验证码</p>");
    } else {
        checkImageCode = checkImageCodeAjax(imageCode);
        if(checkImageCode != 0) {
            $("#regErrorCaptcha").html("<p>验证码错误，请重新输入</p>");
        }
    }
    if(checkRegNameCode == 0 && checkImageCode == 0) {
        alert("success");
        $("#register-form").submitAjax({
            callback: function (data) {
                if(data == 0) {
                    window.location.href = golbalRootUrl + "/";
                }
            }
        });
    }
}

function checkRegNameAjax(input) {
    var iRet = -1;
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/checkRegName",
        data: "regName=" + input,
        async: false,
        success: function (data) {
            iRet = data;
        }
    });
    return iRet;
}

function checkImageCodeAjax(imageCode) {
    var iRet = -1;
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/checkCaptcha",
        data: "imageCode=" + imageCode,
        async: false,
        success: function (data) {
            iRet = data;
        }
    });
    return iRet;
}

function isEmail(input) {
    var emailRegex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    return emailRegex.test(input);
}