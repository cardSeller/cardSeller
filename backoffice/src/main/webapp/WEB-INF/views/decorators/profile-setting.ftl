<script type="text/javascript">

    function uploadEvent(status) {
        if (status === "success") {
            return;
        }

        return 1;
    }

    function validatePwd() {
        if($("#newPassword").val() != $("#confirmPassword").val()) {
            alert("新密码不一致");
        }else{
            $("#change-password-form").submit();
        }
    }

</script>
<div class="modal fade" id="profile-seeting" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><span class="glyphicon glyphicon-file"></span> 系统设置</h4>
            </div>

            <div class="modal-body">

                <ul class="nav nav-tabs tabs-left">
                    <li class="active"><a href="#password-seeting" data-toggle="tab">修改密码</a></li>
                </ul>

                <div class="tab-content">

                    <div class="tab-pane fade in active" id="password-seeting">
                        <form action="${absoluteContextPath}/change-pwd" id="change-password-form" method="post">

                            <div class="form-group">
                                <label for="oldPassword">旧密码:</label>
                                <input type="password" class="form-control required" name="oldPassword" id="oldPassword">
                            </div>

                            <div class="form-group">
                                <label for="newPassword">新密码:</label>
                                <input type="password" class="form-control required" name="newPassword" id="newPassword">
                            </div>

                            <div class="form-group">
                                <label for=confirmPassword>确认新密码:</label>
                                <input type="password" class="form-control required" name="confirmPassword" equalTo="#newPassword" id="confirmPassword">
                            </div>

                            <hr>

                            <div class="text-right">
                                <button type="button" onclick="validatePwd();" class="btn btn-success">
                                    <span class="glyphicon glyphicon-ok"></span> 保存
                                </button>

                                <button type="reset" class="btn btn-danger">
                                    <span class="glyphicon glyphicon-trash"></span> 重置
                                </button>
                            </div>

                        </form>

                    </div>
                </div>

            </div>

        </div>
    </div>
</div>
