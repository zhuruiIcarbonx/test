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
            url: $("#path").val() + "/geneDecodeUnitController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "geneDecodeUnitNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
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

        // 获取所有样本测序信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/collectionSequenceInformationController/list_ajax.do",
            data: {
                "orderBy": "collectionSequenceInformationNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                for (var i = 0; i < m.list.length; i++) {
                    $("#listLayer_left_content").append("<li id='" + m.list[i].collectionSequenceInformationId + "'>" + m.list[i].collectionSequenceInformationNumber + " (" + m.list[i].collectionSequenceInformationName + ")</li>");
                }
            }
        });

        $("#selectAll").on('click', function () {
            // 全选、取消全选的事件
            if (this.checked) {
                $("input:checkbox").prop('checked', true);
            } else {
                $("input:checkbox").prop('checked', false);
            }
        });

        //    检验是否已存在相同的编号
        $("#geneDecodeUnit_number_AMLayer").on('change', function () {
            if(""==$("#geneDecodeUnit_number_AMLayer").val().trim()){
                $("#detectNum_AMLayer").text("");
                return;
            }
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/geneDecodeUnitController/count_ajax.do",
                data: {
                    "geneDecodeUnitNumber": $("#geneDecodeUnit_number_AMLayer").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (msg) {
                    if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    if (0 == msg.idCount) {
                        $("#detectNum_AMLayer").text("√");
                        $("#detectNum_AMLayer").css({"color": "green"});
                    } else {
                        $("#detectNum_AMLayer").text(" X");
                        $("#detectNum_AMLayer").css({"color": "red"});
                    }

                }
            });
        });

        //    多选框中的关键字搜索框
        $("#listLayer_search").keyup(function () {
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/collectionSequenceInformationController/list_ajax.do",
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
                        $("#listLayer_left_content").append("<li id='" + m.list[i].collectionSequenceInformationId + "'>" + m.list[i].collectionSequenceInformationNumber + " (" + m.list[i].collectionSequenceInformationName + ")</li>");

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
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/geneDecodeUnitController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "geneDecodeUnitNumber asc",
            "geneDecodeUnitNumber": $("#search_number").val(),
            "geneDecodeUnitName": $("#search_name").val(),
            "geneDecodeUnitDescription": $("#search_des").val(),
            "unitCode": $("#search_unitCode").val(),
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
            //更新记录
            if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
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
        if ("" == $("#geneDecodeUnit_name_AMLayer").val() || "" == $("#geneDecodeUnit_description_AMLayer").val() || "" == $("#geneDecodeUnit_number_AMLayer").val() || "" == $("#geneDecodeUnit_unitCode_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择对应样本测序信息！");
            return;
        }
        if("" == $("#detectNum_AMLayer").text()){
            alert("请填写编号！");
            return;
        }
        if("√" != $("#detectNum_AMLayer").text()){
            alert("该编号已存在！");
            return;
        }

        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/geneDecodeUnitController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "geneDecodeUnitNumber asc",
                "geneDecodeUnitNumber": $("#geneDecodeUnit_number_AMLayer").val(),
                "geneDecodeUnitName": $("#geneDecodeUnit_name_AMLayer").val(),
                "geneDecodeUnitDescription": $("#geneDecodeUnit_description_AMLayer").val(),
                "unitCode": $("#geneDecodeUnit_unitCode_AMLayer").val(),
                "csIds": $("#right_results").val(),
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

        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#geneDecodeUnit_name_AMLayer").val("");
        $("#geneDecodeUnit_description_AMLayer").val("");
        $("#geneDecodeUnit_number_AMLayer").val("");
        $("#geneDecodeUnit_unitCode_AMLayer").val("")
        $("#detectNum_AMLayer").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#geneDecodeUnit_name_AMLayer").val("");
        $("#geneDecodeUnit_description_AMLayer").val("");
        $("#geneDecodeUnit_number_AMLayer").val("");
        $("#geneDecodeUnit_unitCode_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
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
    var dataNumber = data.split(",")[1];
    var dataUnitCode = data.split(",")[2];
    var dataName = data.split(",")[3];
    var dataDes = data.split(",")[4];
    var right_results = [];
    var right_results_number = [];
    var right_results_name = [];

    $("#geneDecodeUnit_number_AMLayer").val(dataNumber);
    $("#geneDecodeUnit_name_AMLayer").val(dataName);
    $("#geneDecodeUnit_description_AMLayer").val(dataDes);
    $("#geneDecodeUnit_unitCode_AMLayer").val(dataUnitCode);
    $("#geneDecodeUnit_number_AMLayer").select();
    $("#detectNum_AMLayer").text("√");

    //查询该geneDecodeUnitId对应的collectionSequenceInformation
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/geneDecodeUnitController/cdGdList_ajax.do",
        data: {
            "geneDecodeUnitId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);
            for (var i = 0; i < m.csList.length; i++) {
                right_results.push(m.csList[i].collectionSequenceInformationId);
                right_results_number.push(m.csList[i].collectionSequenceInformationNumber);
                right_results_name.push(m.csList[i].collectionSequenceInformationName);
            }

            //显示选择结果数量
            $("#showAbout").text(m.csList.length);

            $("#right_results").val(right_results);
            $("#right_results_number").val(right_results_number);
            $("#right_results_name").val(right_results_name);
        }
    });

    $("#ok_btn_AMLayer").on('click', function () {

        if ("" == $("#geneDecodeUnit_name_AMLayer").val() || "" == $("#geneDecodeUnit_description_AMLayer").val() || "" == $("#geneDecodeUnit_number_AMLayer").val() || "" == $("#geneDecodeUnit_unitCode_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择对应样本测序信息！");
            return;
        }
        if("" == $("#detectNum_AMLayer").text()){
            alert("请填写编号！");
            return;
        }
        if("√" != $("#detectNum_AMLayer").text()){
            alert("该编号已存在！");
            return;
        }

        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/geneDecodeUnitController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "geneDecodeUnitNumber asc",
                "geneDecodeUnitId": dataID,
                "geneDecodeUnitNumber": $("#geneDecodeUnit_number_AMLayer").val(),
                "geneDecodeUnitName": $("#geneDecodeUnit_name_AMLayer").val(),
                "geneDecodeUnitDescription": $("#geneDecodeUnit_description_AMLayer").val(),
                "unitCode": $("#geneDecodeUnit_unitCode_AMLayer").val(),
                "csIds": $("#right_results").val(),
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

        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#geneDecodeUnit_name_AMLayer").val("");
        $("#geneDecodeUnit_description_AMLayer").val("");
        $("#geneDecodeUnit_number_AMLayer").val("");
        $("#geneDecodeUnit_unitCode_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#geneDecodeUnit_name_AMLayer").val("");
        $("#geneDecodeUnit_description_AMLayer").val("");
        $("#geneDecodeUnit_number_AMLayer").val("");
        $("#geneDecodeUnit_unitCode_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#right_results").val("");
        $("#right_results_name").val("");
        $("#showAbout").text("");
    });
}

function modifyChild(data) {

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataUnitCode = data.split(",")[2];
    var dataName = data.split(",")[3];
    var dataDes = data.split(",")[4];

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/geneDecodeUnitController/cdGdList_ajax.do",
        data: {
            "geneDecodeUnitId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                window.parent.location.href = "../index.jsp";
                return;
            }
            $("#listLayer_right_content").empty();
            for (var i = 0; i < m.csList.length; i++) {
                $("#listLayer_right_content").append("<li id='" + m.csList[i].collectionSequenceInformationId + "'>" + m.csList[i].collectionSequenceInformationNumber + " (" + m.csList[i].collectionSequenceInformationName + ")<img class='rightX' src='../img/remove.png'></li>");
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
            alert("请选择对应样本测序信息！");
            return;
        }
        $("#listLayer").hide();
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/geneDecodeUnitController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "geneDecodeUnitNumber asc",
                "geneDecodeUnitId": dataID,
                "geneDecodeUnitNumber": dataNumber,
                "geneDecodeUnitName": dataName,
                "geneDecodeUnitDescription": dataDes,
                "unitCode": dataUnitCode,
                "csIds": $("#right_results").val(),
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
            url: $("#path").val() + "/geneDecodeUnitController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "geneDecodeUnitNumber asc",
                "deleteIds": delete_IDs_string,
                "visitKey": window.parent.getVisitKey()
            },
            success: function (msg) {
                if(undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut){
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

    $("#info_content").children().remove();
    $("#dataTotalNum").text(msg.page.dataTotalNum);
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><input type='checkbox' value='" + msg.page.list[i].geneDecodeUnitId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].geneDecodeUnitNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].unitCode + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].geneDecodeUnitName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].geneDecodeUnitDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'><a href='javascript:void(0);' onclick=modifyChild('" + msg.page.list[i].geneDecodeUnitId + "," + msg.page.list[i].geneDecodeUnitNumber + "," + msg.page.list[i].unitCode + "," + msg.page.list[i].geneDecodeUnitName + "," + msg.page.list[i].geneDecodeUnitDescription + "')>" + (null==msg.page.list[i].childNum? '0':msg.page.list[i].childNum) + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder middle_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].geneDecodeUnitId + "," + msg.page.list[i].geneDecodeUnitNumber + "," + msg.page.list[i].unitCode + "," + msg.page.list[i].geneDecodeUnitName + "," + msg.page.list[i].geneDecodeUnitDescription + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].geneDecodeUnitId + "')>删除</a><a href='javascript:void(0);' onclick=openFlash('" + msg.page.list[i].geneDecodeUnitNumber + "')>编辑模板</a></li>");

    }

}

function showPage(msg) {
    console.log(msg);

    //分页功能实现
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
                url: $("#path").val() + "/geneDecodeUnitController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "geneDecodeUnitNumber asc",
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
        }
    });
}

// 弹出加载 flash 的 iframe
function openFlash(unitId) {
    $(window.parent.document).find("#flash_iframe").attr({
        "src": "../view/editor/TemplateEditor.html?unitId=" + unitId + "&unitType=decodeUnit&visitKey="+window.parent.getVisitKey()
    });

    $(window.parent.document).find("#flash_iframe").show();
    $(window.parent.document).find("#closeFlash").show();

//    滚动条回到最上
    $(window.parent.document).find("body").animate({scrollTop: 0}, 0);
//    禁用滚动条
    $(window.parent.document).find("body").css({"overflow": "hidden"});
}

//弹出样本测序信息多选框
function showCollectionSequenceInfo() {
    $("#listLayer").css({
        "top": $(window.parent.document).scrollTop() + 40
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#listLayer").show();

    var right_results = $("#right_results").val().split(",");
    var right_results_number = $("#right_results_number").val().split(",");
    var right_results_name = $("#right_results_name").val().split(",");

    $("#listLayer_right_content").empty();
    if ("" != $("#right_results").val()) {
        for (var i in right_results) {
            $("#listLayer_right_content").append("<li id='" + right_results[i] + "'>" + right_results_number[i] + " (" + right_results_name[i] + ")<img class='rightX' src='../img/remove.png'></li>");
        }
    }

    $("#ok_btn_listLayer").off('click');
    $("#ok_btn_listLayer").on('click', function () {

        right_results = [];
        right_results_number = [];
        right_results_name = [];
        $("#listLayer_right_content li").each(function () {
            right_results.push($(this).attr("id"));
            var results_name = $(this).text().split(" ")[1];
            right_results_number.push($(this).text().split(" ")[0]);
            right_results_name.push(results_name.substring(1,results_name.length-1));
        });

        $("#right_results").val(right_results);
        $("#right_results_number").val(right_results_number);
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
        url: $("#path").val() + "/geneDecodeUnitController/page_ajax.do",
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

