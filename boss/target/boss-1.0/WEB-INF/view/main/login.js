require.config({
    paths: {
        "jquery": "../lib/jquery-1.11.1.min",
        "jqCook": "../lib/jquery.cookie"
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'jqCook': {
            deps: ['jquery'],
            exports: 'jqCook'
        }
    }
});

require(['jquery', 'jqCook'], function ($, jqCook) {

    $(document).ready(function () {
        //检测是否已经记住用户名
        //cookie存储在域名下，chrome下测试无效，其他有效
        if ($.cookie("isRemember") == "true") {
            $("#isRemember").attr("checked", true);
            $("#username").val($.cookie("username"));
        }

        $(document).keyup(function(event){
            if(event.keyCode ==13){
                $("#submit_btn").trigger("click");
            }
        });
    });
});

function check() {
    var username = $("#username").val();
    var userpwd = $("#userpwd").val();
    var isRemember = $("#isRemember").is(":checked");

    if ("" != username && "" != userpwd) {
        if (isRemember) {
            $.cookie("isRemember", "true", {expires: 7});
            $.cookie("username", username, {expires: 7});
            $.cookie("userpwd", userpwd, {expires: 7});
        } else {
            //删除cookie
            $.cookie("isRemember", "false", {expires: -1});
            $.cookie("username", "", {expires: -1});
            $.cookie("userpwd", "", {expires: -1});
        }

        $("#login_form").submit();
    } else {
        alert("请输入用户名和密码！")
    }
}


