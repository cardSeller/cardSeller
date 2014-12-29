function saveProfile() {
    $("#profileErrorIdentity").html("");
    $("#profileErrorPhone").html("");
    var realName = $("#realName").val();
    var identity = $("#identity").val();
    var phone = $("#phone").val();
    var checkIdentity = new clsIDCard(identity);
    var checkPhone = isPhone(phone);
    if(!checkIdentity.IsValid()) {
        $("#profileErrorIdentity").html("请输入正确的身份证号码");
    }
    if(!checkPhone) {
        $("#profileErrorPhone").html("请输入正确的手机号码");
    }
    if(checkIdentity.IsValid() && checkPhone) {
        $("#profileErrorIdentity").html("");
        $("#profileErrorPhone").html("");
        var data = {};
        data.realName = realName;
        data.identity = identity;
        data.phone = phone;
        $.ajax({
            type: "POST",
            url: golbalRootUrl + "/member/saveProfile",
            data: data,
            async: false,
            success: function (data) {
                if (data == "0") {
                    $("#profileMessage").html("修改个人信息成功");
                } else {
                    $("#profileMessage").html("修改个人信息失败");
                }
            },
        error: function (xhr) {
            if (xhr.status == 401) {
                location.href = xhr.responseText + "?redirectUrl=" + window.location.href;
            }
            $("#profileMessage").html("修改个人信息失败");
        }
        });
    }
}