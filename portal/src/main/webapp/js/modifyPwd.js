function savePwd() {
    $("#errorPwd").html("");
    $("#errorNewPwd").html("");
    $("#errorConfirmNewPwd").html("");
    var pwd = $("#pwd").val();
    var newPwd = $("#newPwd").val();
    var confirmNewPwd = $("#confirmNewPwd").val();
    var checkPwd = true;
    var checkNewPwd = true;
    var checkConfirmNewPwd = true;
    var checkNewAndConfirm = true;
    var checkPwdAjaxCode;
    if(pwd == "" || pwd == undefined) {
        $("#errorPwd").html("请输入密码");
        checkPwd = false;
    }
    if(newPwd == "" || newPwd == undefined) {
        $("#errorNewPwd").html("请输入新密码");
        checkNewPwd = false;
    }
    if(!(newPwd == confirmNewPwd)) {
        $("#errorConfirmNewPwd").html("两次输入密码不一致");
        checkNewAndConfirm = false;
    }
    if(confirmNewPwd == "" || confirmNewPwd == undefined) {
        $("#errorConfirmNewPwd").html("请再次输入新密码");
        checkConfirmNewPwd = false;
    }
    if(checkPwd && checkNewPwd && checkConfirmNewPwd && checkNewAndConfirm) {
        checkPwdAjaxCode = checkPwdAjax(pwd,newPwd,confirmNewPwd);
        if(checkPwdAjaxCode != 0) {
            if(checkPwdAjaxCode == -12) {
                $("#errorPwd").html("原始密码不正确");
            }
            if(checkPwdAjax == -11) {
                $("#errorConfirmNewPwd").html("两次输入密码不一致");
            }
        } else {
            $("#modifyPwdForm").submit();
        }
    }
}

function checkPwdAjax(pwd,newPwd,confirmNewPwd) {
    var iRet = -1;
    $.ajax({
        type: "POST",
        url: golbalRootUrl + "/member/checkPwd",
        data: "pwd=" + pwd + "&newPwd=" + newPwd + "&confirmNewPwd=" + confirmNewPwd,
        async: false,
        success: function (data) {
            iRet = data;
        }
    });
    return iRet;
}