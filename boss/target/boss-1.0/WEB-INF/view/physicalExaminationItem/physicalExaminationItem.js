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
            url: $("#path").val() + "/physicalExaminationItemController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
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

        // 获取体检项目类型的树
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/commonController/getJsonFile_ajax.do",
            data: {
                "visitKey": window.parent.getVisitKey(),
                "jsonFileName": "physicalExaminationItemType.json"
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                getItemTypeTree(m);
            }
        });

        // 获取所有体检项目单位
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemUnitController/list_ajax.do",
            data: {
                "orderBy": "physicalExaminationItemUnitName asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                for (var i = 0; i < m.list.length; i++) {
                    $("#listLayer_left_content").append("<li id='" + m.list[i].physicalExaminationItemUnitId + "'>" + m.list[i].physicalExaminationItemUnitName + "</li>");
                }
            }
        });

        //    多选框中的关键字搜索框
        $("#listLayer_search").keyup(function () {
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/physicalExaminationItemUnitController/list_ajax.do",
                data: {
                    "searchChildKey": $("#listLayer_search").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
                    if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    $("#listLayer_left_content").empty();
                    for (var i = 0; i < m.list.length; i++)
                        $("#listLayer_left_content").append("<li id='" + m.list[i].physicalExaminationItemUnitId + "'>"  + " (" + m.list[i].physicalExaminationItemUnitName + ")</li>");

                }
            });
        });

        $("#clearSearch").on('click', function () {
            //模拟keyup事件
            $("#listLayer_search").val("");
            e = $.Event("keyup");
            e.which = 13 //enter key
            $("#listLayer_search").trigger(e);
        });

        //    选择基因解读单元多选框中的li点击事件
        $("#listLayer_left_content").on('click', 'li', function () {
            var this_left_li = $(this).text();
            var right_isExist = false;

            $("#listLayer_right_content li").each(function () {
                if (this_left_li == $(this).text())
                    right_isExist = true;
            });
            if (!right_isExist)
                $("#listLayer_right_content").append("<li id='" + $(this).attr('id') + "'>" + $(this).text() + "<img class='rightX' src='../img/remove.png'></li>");

        });

        //多选框右部分li事件绑定
        $("#listLayer_right_content").on({
            mouseenter: function () {
                $(this).find("img").show();
            },
            mouseleave: function () {
                $(this).find("img").hide();
            }
        }, 'li');

        // 多选框右部分li里的关闭按钮点击事件绑定
        $("#listLayer_right_content").on('click', 'li img', function () {
            $(this).closest("li").remove();
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
    if("" != $("#search_type").val())
        blank = false;
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "physicalExaminationItemName asc",
            "physicalExaminationItemName": $("#search_name").val(),
            "physicalExaminationItemDescription": $("#search_des").val(),
            "physicalExaminationItemType": $("#search_type").val(),
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
        if ("" == $("#physicalExaminationItemType_AMLayer").val() || "" == $("#physicalExaminationItemDescription_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择体检项目单位！");
            return;
        }

        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
                "physicalExaminationItemName": $("#physicalExaminationItemName_AMLayer").val(),
                "physicalExaminationItemType": $("#itemTypeResult").val(),
                "physicalExaminationItemDescription": $("#physicalExaminationItemDescription_AMLayer").val(),
                "physicalExaminationItemUnitIds": $("#right_results").val(),
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
        $("#itemTypeResult").val("");
        $("#physicalExaminationItemDescription_AMLayer").val("");
        $("#showAboutType").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#physicalExaminationItemName_AMLayer").val("");
        $("#itemTypeResult").val("");
        $("#physicalExaminationItemDescription_AMLayer").val("");
        $("#showAboutType").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
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
    var dataName = data.split(",")[1];
    var dataType = data.split(",")[2];
    var dataDes = data.split(",")[3];

    $("#physicalExaminationItemName_AMLayer").val(dataName);
    $("#itemTypeResult").val(dataType);
    $("#physicalExaminationItemDescription_AMLayer").val(dataDes);
    $("#physicalExaminationItemName_AMLayer").select();
    $("#showAboutType").text(dataType);
    var right_results = [];
    var right_results_name = [];

    //查询该PEItemId对应的PEIUnitId
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemController/listMap_ajax.do",
        data: {
            "physicalExaminationItemId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            for (var i = 0; i < m.list.length; i++) {
                right_results.push(m.list[i].physicalExaminationItemUnitId);
                right_results_name.push(m.list[i].physicalExaminationItemUnitName);
            }

            //显示选择结果数量
            $("#showAbout").text(m.list.length);

            $("#right_results").val(right_results);
            $("#right_results_name").val(right_results_name);
        }
    });

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#physicalExaminationItemType_AMLayer").val() || "" == $("#physicalExaminationItemDescription_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择体检项目单位！");
            return;
        }

        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
                "physicalExaminationItemId": dataID,
                "physicalExaminationItemName": $("#physicalExaminationItemName_AMLayer").val(),
                "physicalExaminationItemType": $("#itemTypeResult").val(),
                "physicalExaminationItemDescription": $("#physicalExaminationItemDescription_AMLayer").val(),
                "physicalExaminationItemUnitIds": $("#right_results").val(),
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
        $("#detectNum_AMLayer").text("");
        $("#itemTypeResult").val("");
        $("#showAboutType").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#physicalExaminationItemName_AMLayer").val("");
        $("#physicalExaminationItemType_AMLayer").val("");
        $("#physicalExaminationItemDescription_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#itemTypeResult").val("");
        $("#showAboutType").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });
}

//修改选项modifyItemType
function modifyItemType(data) {

    var dataID = data.split(",")[0];
    var dataName = data.split(",")[1];
    var dataType = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var right_results = [];

    $("#itemTypeLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();
    $("#itemTypeLayer").show();

    $("#itemTypeLayer_content a").removeClass();
    $("a[rel='-" + dataType + "']").addClass("selected_a");

    $('#itemTypeLayer_content').off('click');
    $('#itemTypeLayer_content').on('click', 'a', function () {
        $(this).next("ul").animate({
            height: 'toggle',
            opacity: 'toggle'
        }, "slow");

        // 更改树形菜单图标
        if ($(this).find("span").html() == "[+]")
            $(this).find("span").html("[-]");
        else if ($(this).find("span").html() == "[-]")
            $(this).find("span").html("[+]");
        else if ($(this).find("span").html() == "") {
            $("#itemTypeLayer_content a").removeClass();
            $(this).addClass("selected_a");
        }

    });

    //查询该PEItemId对应的PEIUnitId
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemController/listMap_ajax.do",
        data: {
            "physicalExaminationItemId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            for (var i = 0; i < m.list.length; i++) {
                right_results.push(m.list[i].physicalExaminationItemUnitId);
            }

            //显示选择结果数量
            $("#showAbout").text(m.list.length);

            $("#right_results").val(right_results);
        }
    });

    $("#ok_btn_itemTypeLayer").off('click');
    $("#ok_btn_itemTypeLayer").on('click', function () {
        var result = $(".selected_a").attr("rel").substring(1);

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
                "physicalExaminationItemId": dataID,
                "physicalExaminationItemName": dataName,
                "physicalExaminationItemType": result,
                "physicalExaminationItemDescription": dataDes,
                "physicalExaminationItemUnitIds": $("#right_results").val(),
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

        $("#itemTypeLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
    });

    $("#cancel_btn_itemTypeLayer").off('click');
    $("#cancel_btn_itemTypeLayer").on('click', function () {
        $("#itemTypeLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
    });
}

function modifyChild(data) {

    var dataID = data.split(",")[0];
    var dataName = data.split(",")[1];
    var dataType = data.split(",")[2];
    var dataDes = data.split(",")[3];

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/physicalExaminationItemController/listMap_ajax.do",
        data: {
            "physicalExaminationItemId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            $("#listLayer_right_content").empty();
            for (var i = 0; i < m.list.length; i++) {
                $("#listLayer_right_content").append("<li id='" + m.list[i].physicalExaminationItemUnitId + "'>" + m.list[i].physicalExaminationItemUnitName + "<img class='rightX' src='../img/remove.png'></li>");
            }
        }
    });

    $("#listLayer").css({
        "top": $(window.parent.document).scrollTop() + 40
    });
    $("#listLayer").show();
    // 显示遮罩层并禁用滚动条
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();

    $("#ok_btn_listLayer").off('click');
    $("#ok_btn_listLayer").on('click', function () {

        var right_results = [];
        $("#listLayer_right_content li").each(function () {
            right_results.push($(this).attr("id"));
        });

        $("#right_results").val(right_results);

        if ("" == $("#right_results").val()) {
            alert("请选择体检项目单位！");
            return;
        }
        $("#listLayer").hide();
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/physicalExaminationItemController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
                "physicalExaminationItemId": dataID,
                "physicalExaminationItemName": dataName,
                "physicalExaminationItemType": dataType,
                "physicalExaminationItemDescription": dataDes,
                "physicalExaminationItemUnitIds": $("#right_results").val(),
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                showData(msg);
            }
        });
        $("#listLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
    });

    $("#cancel_btn_listLayer").on('click', function () {
        $("#listLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
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
            url: $("#path").val() + "/physicalExaminationItemController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "physicalExaminationItemName asc",
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
    console.log(msg);
    $("#dataTotalNum").text(msg.page.dataTotalNum);
    $("#info_content").children().remove();
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'><input type='checkbox' value='" + msg.page.list[i].physicalExaminationItemId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].physicalExaminationItemName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].physicalExaminationItemDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'><a href='javascript:void(0);' onclick=modifyItemType('" + msg.page.list[i].physicalExaminationItemId + "," + msg.page.list[i].physicalExaminationItemName + "," + msg.page.list[i].physicalExaminationItemType + "," + msg.page.list[i].physicalExaminationItemDescription + "')>" + msg.page.list[i].physicalExaminationItemType + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'><a href='javascript:void(0);' onclick=modifyChild('" + msg.page.list[i].physicalExaminationItemId + "," + msg.page.list[i].physicalExaminationItemName + "," + msg.page.list[i].physicalExaminationItemType + "," + msg.page.list[i].physicalExaminationItemDescription + "')>" + (null==msg.page.list[i].physicalExaminationItemUnitNum?"0":msg.page.list[i].physicalExaminationItemUnitNum) + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder less_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].physicalExaminationItemId + "," + msg.page.list[i].physicalExaminationItemName + "," + msg.page.list[i].physicalExaminationItemType + "," + msg.page.list[i].physicalExaminationItemDescription + "')>修改</a>&nbsp;<a href='javascript:void(0);' onclick=del('" + msg.page.list[i].physicalExaminationItemId + "')>删除</a></li>");

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

            // 判断是否点击“最后一页”
            var isLastPage = false;
            if (page == Math.ceil(dataTotalNum / PageSize))
                isLastPage = true;

            //将数据传给后台并获取相关信息
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/physicalExaminationItemController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "physicalExaminationItemName asc",
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

// 体检项目类型
function itemType() {
    $("#itemTypeLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#itemTypeLayer").show();

    $("#itemTypeLayer_content a").removeClass();
    $("a[rel='-" + $("#itemTypeResult").val() + "']").addClass("selected_a");

    $('#itemTypeLayer_content').off('click');
    $('#itemTypeLayer_content').on('click', 'a', function () {
        $(this).next("ul").animate({
            height: 'toggle',
            opacity: 'toggle'
        }, "slow");

        // 更改树形菜单图标
        if ($(this).find("span").html() == "[+]")
            $(this).find("span").html("[-]");
        else if ($(this).find("span").html() == "[-]")
            $(this).find("span").html("[+]");
        else if ($(this).find("span").html() == "") {
            $("#itemTypeLayer_content a").removeClass();
            $(this).addClass("selected_a");
        }

    });

    $("#ok_btn_itemTypeLayer").off('click');
    $("#ok_btn_itemTypeLayer").on('click', function () {
        var result = $(".selected_a").attr("rel").substring(1);
        //显示选择结果
        $("#showAboutType").text(result);

        $("#itemTypeResult").val(result);
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#itemTypeLayer").hide();
    });

    $("#cancel_btn_itemTypeLayer").off('click');
    $("#cancel_btn_itemTypeLayer").on('click', function () {
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#itemTypeLayer").hide();
    });
}

// 解析JSON数据，获取问题类型的树
function getItemTypeTree(m) {
    // 将字符串转换为json对象
    var tree = strToJson(m.qustionType);
    // 解析json数据
    renderMenu(tree, $("#itemTypeLayer_content"), "");

}

//解析JSON数据，并建立树形结构
function renderMenu(obj, parent, lineName) {
    var el = $("<a href='javascript:void(0);'><span>[-]</span>" + obj.name + "</a>");
    $(parent).append(el);

    var lineName = lineName + "-" + obj.name;
    if (obj.children.length < 1) {
        el.find("span").html("");
        el.attr("rel", lineName);
        $("#search_type").append("<option>"+lineName.substring(1)+"</option>");
        return parent;
    }

    var ul = $('<ul/>');
    for (var i = 0; i < obj.children.length; ++i) {
        var li = $('<li/>');
        renderMenu(obj.children[i], li, lineName);
        ul.append(li);
    }

    $(parent).append(ul);
    return parent;
}

// 将字符串转换为json对象
function strToJson(str) {
    var json = (new Function("return " + str))();
    return json;
}

//弹出体检项目单位多选框
function showItemUnit() {
    $("#listLayer").css({
        "top": $(window.parent.document).scrollTop() + 40
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#listLayer").show();

    var right_results = $("#right_results").val().split(",");
    var right_results_name = $("#right_results_name").val().split(",");

    $("#listLayer_right_content").empty();
    if ("" != $("#right_results").val()) {
        for (var i in right_results) {
            $("#listLayer_right_content").append("<li id='" + right_results[i] + "'>" + right_results_name[i] + "<img class='rightX' src='../img/remove.png'></li>");
        }
    }

    $("#ok_btn_listLayer").off('click');
    $("#ok_btn_listLayer").on('click', function () {

        right_results = [];
        right_results_name = [];
        $("#listLayer_right_content li").each(function () {
            right_results.push($(this).attr("id"));
            right_results_name.push($(this).text());
        });

        $("#right_results").val(right_results);
        $("#right_results_name").val(right_results_name);

        //显示选择结果数量
        $("#showAbout").text(right_results.length);

        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#listLayer").hide();
    });

    $("#cancel_btn_listLayer").on('click', function () {
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#listLayer").hide();
    });
}

// 清空所有搜索框里的内容
function clear_search(){
    $("#search :text").each(function(){
        $(this).val("");
    });
    $("#search select option:first").prop("selected",true);
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
        url: $("#path").val() + "/physicalExaminationItemController/page_ajax.do",
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
