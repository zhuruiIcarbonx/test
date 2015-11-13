require.config({
    paths: {
        "jquery": "../lib/jquery-1.11.1.min",
        "jqpagination": "../lib/jquery.jqpagination.min",
        "easyui": "../lib/jquery.easyui.min"
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'jqpagination': {
            deps: ['jquery'],
            exports: 'jqpagination'
        },
        'easyui': {
            deps: ['jquery'],
            exports: 'easyui'
        }
    }
});

require(['jquery', 'easyui', 'jqpagination'], function ($, easyui, jqpagination) {

    $(document).ready(function () {

        $("#pagination_all").hide();
        $("#pagination_search").hide();
        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemUnitController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemUnitName asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
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
    });

});

//查询方法
function search() {
    var blank = true;
    $("#search :text").each(function(){
        if(""!=$(this).val().trim())
            blank = false;
    });
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemUnitController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "physicalExaminationItemUnitName asc",
            "physicalExaminationItemUnitName": $("#search_name").val(),
            "physicalExaminationItemUnitDescription": $("#search_des").val(),
            "maximumValue": $("#search_max").val(),
            "minimumValue": $("#search_min").val(),
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
            if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }

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
//增加方法
function add() {
    $("#AMLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#AMLayer").show();
    // 显示遮罩层并禁用滚动条
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();

    //移除点击事件，否则会重复
    $("#ok_btn_AMLayer").off('click');
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#physicalExaminationItemUnitName_AMLayer").val() || "" == $("#physicalExaminationItemUnitDescription_AMLayer").val() || "" == $("#maximumValue_AMLayer").val() || "" == $("#minimumValue_AMLayer").val() || "" == $("#physicalExaminationItemId_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }

        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemUnitController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemUnitName asc",
                "physicalExaminationItemUnitName": $("#physicalExaminationItemUnitName_AMLayer").val(),
                "physicalExaminationItemUnitDescription": $("#physicalExaminationItemUnitDescription_AMLayer").val(),
                "maximumValue": $("#maximumValue_AMLayer").val(),
                "minimumValue": $("#minimumValue_AMLayer").val(),
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

        $("#physicalExaminationItemUnitName_AMLayer").val("");
        $("#physicalExaminationItemUnitDescription_AMLayer").val("");
        $("#maximumValue_AMLayer").val("");
        $("#minimumValue_AMLayer").val("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();

        $("#physicalExaminationItemUnitName_AMLayer").val("");
        $("#physicalExaminationItemUnitDescription_AMLayer").val("");
        $("#maximumValue_AMLayer").val("");
        $("#minimumValue_AMLayer").val("");
    });

}

//修改方法
function modify(data) {
    $("#AMLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#AMLayer").show();
    // 显示遮罩层并禁用滚动条
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();

    $("#ok_btn_AMLayer").off('click');

    var dataID = data.split(",")[0];

    var physicalExaminationItemUnitName = data.split(",")[1];
    var physicalExaminationItemUnitDescription = data.split(",")[2];
    var maximumValue = data.split(",")[3];
    var minimumValue = data.split(",")[4];

    $("#physicalExaminationItemUnitName_AMLayer").val(physicalExaminationItemUnitName);
    $("#physicalExaminationItemUnitDescription_AMLayer").val(physicalExaminationItemUnitDescription);
    $("#maximumValue_AMLayer").val(maximumValue);
    $("#minimumValue_AMLayer").val(minimumValue);
    $("#physicalExaminationItemUnitName_AMLayer").select();

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#physicalExaminationItemUnitName_AMLayer").val() || "" == $("#physicalExaminationItemUnitDescription_AMLayer").val() || "" == $("#maximumValue_AMLayer").val() || "" == $("#minimumValue_AMLayer").val() || "" == $("#physicalExaminationItemId_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemUnitController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemUnitName asc",
                "physicalExaminationItemUnitId": dataID,
                "physicalExaminationItemUnitName": $("#physicalExaminationItemUnitName_AMLayer").val(),
                "physicalExaminationItemUnitDescription": $("#physicalExaminationItemUnitDescription_AMLayer").val(),
                "maximumValue": $("#maximumValue_AMLayer").val(),
                "minimumValue": $("#minimumValue_AMLayer").val(),
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
        $("#physicalExaminationItemName_AMLayer").val("");
        $("#physicalExaminationItemType_AMLayer").val("");
        $("#physicalExaminationItemDescription_AMLayer").val("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#physicalExaminationItemUnitName_AMLayer").val("");
        $("#physicalExaminationItemUnitDescription_AMLayer").val("");
        $("#maximumValue_AMLayer").val("");
        $("#minimumValue_AMLayer").val("");
        $("#physicalExaminationItemId_AMLayer").val("");
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
            url: $("#path").val() + "/physicalExaminationItemUnitController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemUnitName asc",
                "deleteIds": delete_IDs_string,
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }

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
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'><input type='checkbox' value='" + msg.page.list[i].physicalExaminationItemUnitId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].physicalExaminationItemUnitName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].physicalExaminationItemUnitDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].maximumValue + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].minimumValue + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder more_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].physicalExaminationItemUnitId + "," + msg.page.list[i].physicalExaminationItemUnitName + "," + msg.page.list[i].physicalExaminationItemUnitDescription + "," + msg.page.list[i].maximumValue + "," + msg.page.list[i].minimumValue + "')>修改</a>&nbsp;<a href='javascript:void(0);' onclick=del('" + msg.page.list[i].physicalExaminationItemUnitId + "')>删除</a></li>");

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
                url: $("#path").val() + "/physicalExaminationItemUnitController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "physicalExaminationItemUnitName asc",
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (msg) {
                    if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }

                    showData(msg);
                },
                error: function (error) {
                    console.log(error);
                }
            });
        }
    });
}

// 清空所有搜索框里的内容
function clear_search(){
    $("#search :text").each(function(){
        $(this).val("");
    });
}

//重新排序
function reOrder(data,_li){
    var order = " asc";
    if($(_li).find("span").hasClass("ASC")){
        $("#info_top li span").each(function(){
            $(this).removeClass();
        });
        order = " desc";
        $(_li).find("span").addClass("DESC");
    }else{
        $("#info_top li span").each(function(){
            $(this).removeClass();
        });
        $(_li).find("span").addClass("ASC");
    }

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemUnitController/page_ajax.do",
        data: {
            "orderBy": data+order,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
            if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(msg);
            showData(msg);
        }
    });
}

