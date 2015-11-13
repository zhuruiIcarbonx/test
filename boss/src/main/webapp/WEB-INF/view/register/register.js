$(document).ready(function () {
    $(document).keyup(function(event){
        if(event.keyCode ==13){
            $("#btn_register").trigger("click");
        }
    });
});

function registerCheck(){
    var username = $("#username").val();
    var email = $("#email").val();
    var userpwd = $("#userpwd").val();
    var userpwd_confirm = $("#userpwd_confirm").val();

    if ("" == username || "" == email || "" == userpwd || "" == userpwd_confirm) {
        alert("请填写完整信息！");
        return;
    } else if (userpwd != userpwd_confirm) {
        alert("两次密码输入不同！");
        return;
    }

    $("#register_form").submit();
}