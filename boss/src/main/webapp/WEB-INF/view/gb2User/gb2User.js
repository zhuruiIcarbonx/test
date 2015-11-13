require.config({
    paths: {
        "jquery": "../lib/jquery-1.11.1.min",
        "jqpagination": "../lib/jquery.jqpagination.min"
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'jqpagination': {
            deps: ['jquery'],
            exports: 'jqpagination'
        }
    }
});

require(['jquery', 'jqpagination'], function ($, jqpagination) {

    $(document).ready(function () {
        $("#pagination_all").hide();
        $("#pagination_search").hide();

        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/gb2UserController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "userId asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                console.log(msg);
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }

                if (msg.page.list.length > 0) {
                    showPage(msg);
                    showData(msg);
                    $("#pagination_all").show();
                }
            }
        });

        $("#selectAll").on('click', function () {
            if (this.checked) {
                $("input:checkbox").prop('checked', true);
            } else {
                $("input:checkbox").prop('checked', false);
            }
        });

        //读取数据字典中所有性别类别
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/gb2DictController/list_ajax.do",
            data: {
                "orderBy": "dictId asc",
                "dictCode": "userSex",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                for (var i = 0; i < m.list.length; i++) {
                    $("#sex_gb2User").append("<option value='" + m.list[i].itemCode + "'>" + m.list[i].itemName + "</option>");
                }
            }
        });

    });

});

//查询方法
function search() {
    var blank = true;
    $("#search :text").each(function () {
        if ("" != $(this).val().trim())
            blank = false;
    });
    if("" == $("#sort_search").val()){
        alert("请选择搜索类别！");
        return;
    }
    if (blank) {
        alert("请输入搜索内容！");
        return;
    }

    var param = {
        "currentPage": "1",
        "visitKey": window.parent.getVisitKey()
    };
    param[$("#sort_search").val()] = $("#text_search").val();
    //将数据传给后台并获取相关信息

    console.log(param);
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/gb2UserController/page_ajax.do",
        data: param,
        success: function (msg) {
            console.log(msg);
            if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            //更新记录
            $("#pagination_all").hide();
            if (msg.page.list.length > 0) {
                showData(msg);
                $("#pagination_search").show();
            } else {
                alert("没有找到相关信息！");
            }
        }
    });
}

//修改方法
function modify(data) {
    $("#AMLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#AMLayer").show();
    // 显示遮罩层并禁用滚动条
//    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();

    var dataID = data.split(",")[0];
    var dataName = data.split(",")[1];
    var dataPhoneNum = data.split(",")[2];
    var dataSex = data.split(",")[3];

    $("#name_gb2User").val(dataName);
    $("#phoneNumber_gb2User").val(dataPhoneNum);
    $("#sex_gb2User").val(dataSex);
    $("#name_gb2User").select();

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").off('click');
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#name_gb2User").val() || "" == $("#phoneNumber_gb2User").val() || "" == $("#sex_gb2User").val()) {
            alert("请填写完整信息后提交！");
            return;
        }

        console.log(dataID);
        console.log($("#name_gb2User").val());
        console.log($("#phoneNumber_gb2User").val());
        console.log($("#sex_gb2User").val());
        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/gb2UserController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "userId asc",
                "userId": dataID,
                "userName": $("#name_gb2User").val(),
                "phoneNumber": $("#phoneNumber_gb2User").val(),
                "sex": $("#sex_gb2User").val(),
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                showData(msg);
            }
        });

        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#name_gb2User").val("");
        $("#phoneNumber_gb2User").val("");
        $("#sex_gb2User").val("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#name_gb2User").val("");
        $("#phoneNumber_gb2User").val("");
        $("#sex_gb2User").val("");
    });
}

//删除方法
function del(dataID) {
    //判断有没有选择要删除的选项
    var delete_IDs = [];

    //读取批量删除,check_IDs为被选择要删除的栏目
    $("#info_content input:checked").each(function () {
        delete_IDs.push(($(this).val()));
    });

    //弹出询问是否确认删除的对话框
    if (undefined != dataID || (undefined == dataID && delete_IDs.length > 0)) {
        $("#deleteLayer").css({
            "top": $(window.parent.document).scrollTop() + 50
        });
        $("#deleteLayer").show();
        // 显示遮罩层并禁用滚动条
        $("#shelterLayer").show();
        $("body").css({"overflow": "hidden"});
        $(window.parent.document).find("#shelterLayer_main").show();
    } else {
        alert("请选择要删除的栏目！");
        return;
    }

    //将要删除的记录ID全部放进一个数组中并转为字符串
    if (undefined != dataID && delete_IDs.length == 0)
        delete_IDs.push(dataID);

    var delete_IDs_string = delete_IDs.join(",");

    $("#ok_btn_deleteLayer").on('click', function () {
        //将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/gb2UserController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "userId asc",
                "deleteIds": delete_IDs_string,
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                //更新记录
                $("input:checkbox").prop('checked', false);
                showData(msg);
            }
        });

        $("#deleteLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
    });
    $("#cancel_btn_deleteLayer").on('click', function () {
        $("#deleteLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
    });
}

function showData(msg) {

    $("#dataTotalNum").text(msg.page.dataTotalNum);
    $("#info_content").children().remove();
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'><input type='checkbox' value='" + msg.page.list[i].userId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].userName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].phoneNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].sexName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder large_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].userId + "," + msg.page.list[i].userName + "," + msg.page.list[i].phoneNumber + "," + msg.page.list[i].sex + "')>修改</a>&nbsp;<a href='javascript:void(0);' onclick=del('" + msg.page.list[i].userId + "')>删除</a></li>");

    }

}

function showPage(msg) {

    var PageSize = msg.page.pageSize;
    var currentPage = msg.page.currentPage;
    var dataTotalNum = msg.page.dataTotalNum;

    $(".pagination").jqPagination({
        max_page: Math.ceil(dataTotalNum / PageSize),
        page_string: '{current_page} / {max_page}',
        paged: function (page) {
            console.log("当前为第" + page + "页");

            // 判断是否点击“最后一页”
            var isLastPage = false;
            if (page == Math.ceil(dataTotalNum / PageSize))
                isLastPage = true;

            //将数据传给后台并获取相关信息
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/gb2UserController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "userId asc",
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (msg) {
                    if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    //更新记录
                    showData(msg);
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    });
}

//重新排序
function reOrder(data, _li) {
    var order = " asc";
    if ($(_li).find("span").hasClass("ASC")) {
        $("#info_top li span").each(function () {
            $(this).removeClass();
        });
        order = " desc";
        $(_li).find("span").addClass("DESC");
    } else {
        $("#info_top li span").each(function () {
            $(this).removeClass();
        });
        $(_li).find("span").addClass("ASC");
    }

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/gb2UserController/page_ajax.do",
        data: {
            "orderBy": data + order,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
            if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(msg);
            showData(msg);
        }
    });
}

