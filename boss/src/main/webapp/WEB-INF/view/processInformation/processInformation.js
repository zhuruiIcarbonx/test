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
            url: $("#path").val() + "/processInformationController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "processInformationId asc",
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

        // 获取所有商品
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/productController/list_ajax.do",
            data: {
                "orderBy": "productNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                console.log(m);
                if(undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut){
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                for (var i = 0; i < m.list.length; i++) {
                    $("#listLayer_left_content").append("<li id='" + m.list[i].productId + "'>" + m.list[i].productNumber + " (" + m.list[i].productName + ")</li>");
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

        //    检验是否已存在相同的编号
        $("#processInfo_number").on('change', function () {
            if(""==$("#processInfo_number").val().trim()){
                $("#detectNum_AMLayer").text("");
                return;
            }
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/processInformationController/count_ajax.do",
                data: {
                    "processInformationNumber": $("#processInfo_number").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (msg) {
                    if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
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
                },
                error: function (error) {
                    console.log(error);
                }
            });
        });

        //    多选框中的关键字搜索框
        $("#listLayer_search").keyup(function () {
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/productController/list_ajax.do",
                data: {
                    "searchChildKey": $("#listLayer_search").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
                    console.log(m);
                    if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    $("#listLayer_left_content").empty();
                    for (var i = 0; i < m.list.length; i++)
                        $("#listLayer_left_content").append("<li id='" + m.list[i].geneDecodeUnitId + "'>" + m.list[i].geneDecodeUnitNumber + " (" + m.list[i].geneDecodeUnitName + ")</li>");

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
    $("#search_large :text").each(function(){
        if(""!=$(this).val().trim())
            blank = false;
    });
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    console.log($("#search_number").val());

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/processInformationController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "processInformationId asc",
            "processInformationNumber": $("#search_number").val(),
            "processInformationName": $("#search_name").val(),
            "processInformationDescription": $("#search_des").val(),
            "sampleCollectorType": $("#search_CType").val(),
            "sampleLogisticType": $("#search_LType").val(),
            "sampleExtractionType": $("#search_EType").val(),
            "sampleSequenceType": $("#search_SType").val(),
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
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
        if ("" == $("#processInfo_name").val() || "" == $("#processInfo_description").val() || "" == $("#sampleCollectorType").val() || "" == $("#sampleLogisticType").val() || "" == $("#sampleExtractionType").val() || "" == $("#sampleSequenceType").val()) {
            alert("请填写完整信息后提交！");
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
            url: $("#path").val() + "/processInformationController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "processInformationId asc",
                "processInformationNumber": $("#processInfo_number").val(),
                "processInformationName": $("#processInfo_name").val(),
                "processInformationDescription": $("#processInfo_description").val(),
                "sampleCollectorType": $("#sampleCollectorType").val(),
                "sampleLogisticType": $("#sampleLogisticType").val(),
                "sampleExtractionType": $("#sampleExtractionType").val(),
                "sampleSequenceType": $("#sampleSequenceType").val(),
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
        $("#processInfo_number").val("");
        $("#processInfo_name").val("");
        $("#processInfo_description").val("");
        $("#sampleCollectorType").val("");
        $("#sampleLogisticType").val("");
        $("#sampleExtractionType").val("");
        $("#sampleSequenceType").val("");
        $("#detectNum_AMLayer").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#processInfo_number").val("");
        $("#processInfo_name").val("");
        $("#processInfo_description").val("");
        $("#sampleCollectorType").val("");
        $("#sampleLogisticType").val("");
        $("#sampleExtractionType").val("");
        $("#sampleSequenceType").val("");
        $("#detectNum_AMLayer").text("");
    });
}

//修改方法
function modify(data) {
    $("#AMLayer").css({
        "top": $(window.parent.document).scrollTop() + 50,
        "left": "300px"
    });
    $("#AMLayer").show();
    // 显示遮罩层并禁用滚动条
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();

    $("#ok_btn_AMLayer").off('click');

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataCType = data.split(",")[4];
    var dataLType = data.split(",")[5];
    var dataEType = data.split(",")[6];
    var dataSType = data.split(",")[7];

    $("#processInfo_number").val(dataNumber);
    $("#processInfo_name").val(dataName);
    $("#processInfo_description").val(dataDes);
    $("#sampleCollectorType").val(dataCType);
    $("#sampleLogisticType").val(dataLType);
    $("#sampleExtractionType").val(dataEType);
    $("#sampleSequenceType").val(dataSType);
    $("#processInfo_name").select();
    $("#detectNum_AMLayer").text("√");

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#processInfo_name").val() || "" == $("#processInfo_description").val() || "" == $("#sampleCollectorType").val() || "" == $("#sampleLogisticType").val() || "" == $("#sampleExtractionType").val() || "" == $("#sampleSequenceType").val()) {
            alert("请填写完整信息后提交！");
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
            url: $("#path").val() + "/processInformationController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "processInformationId asc",
                "processInformationId": dataID,
                "processInformationNumber": $("#processInfo_number").val(),
                "processInformationName": $("#processInfo_name").val(),
                "processInformationDescription": $("#processInfo_description").val(),
                "sampleCollectorType": $("#sampleCollectorType").val(),
                "sampleLogisticType": $("#sampleLogisticType").val(),
                "sampleExtractionType": $("#sampleExtractionType").val(),
                "sampleSequenceType": $("#sampleSequenceType").val(),
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
        $("#processInfo_number").val("");
        $("#processInfo_name").val("");
        $("#processInfo_description").val("");
        $("#sampleCollectorType").val("");
        $("#sampleLogisticType").val("");
        $("#sampleExtractionType").val("");
        $("#sampleSequenceType").val("");
        $("#detectNum_AMLayer").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#processInfo_number").val("");
        $("#processInfo_name").val("");
        $("#processInfo_description").val("");
        $("#sampleCollectorType").val("");
        $("#sampleLogisticType").val("");
        $("#sampleExtractionType").val("");
        $("#sampleSequenceType").val("");
        $("#detectNum_AMLayer").text("");
    });
}

//删除方法
function del(dataID) {
    //判断有没有选择要删除的选项
    var delete_IDs = [];

    //读取批量删除,check_IDs为被选择要删除的栏目
    $("#info_content_large input:checked").each(function () {
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
            url: $("#path").val() + "/processInformationController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "processInformationId asc",
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

    console.log(msg);
    $("#dataTotalNum").text(msg.page.dataTotalNum);
    $("#info_content_large").children().remove();
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content_large").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><input type='checkbox' value='" + msg.page.list[i].processInformationId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'>" + msg.page.list[i].processInformationNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].processInformationName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].processInformationDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].sampleCollectorType + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].sampleLogisticType + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].sampleExtractionType + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].sampleSequenceType + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder smallest_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].processInformationId + "," + msg.page.list[i].processInformationNumber+ "," + msg.page.list[i].processInformationName + "," + msg.page.list[i].processInformationDescription + "," + msg.page.list[i].sampleCollectorType + "," + msg.page.list[i].sampleLogisticType+ "," + msg.page.list[i].sampleExtractionType + "," + msg.page.list[i].sampleSequenceType + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].processInformationId + "')>删除</a></li>");

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
                url: $("#path").val() + "/processInformationController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "processInformationId asc",
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

// 清空所有搜索框里的内容
function clear_search(){
    $("#search_large :text").each(function(){
        $(this).val("");
    });
}

//重新排序
function reOrder(data,_li){
    var order = " asc";
    if($(_li).find("span").hasClass("ASC")){
        $("#info_top_large li span").each(function(){
            $(this).removeClass();
        });
        order = " desc";
        $(_li).find("span").addClass("DESC");
    }else{
        $("#info_top_large li span").each(function(){
            $(this).removeClass();
        });
        $(_li).find("span").addClass("ASC");
    }

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/processInformationController/page_ajax.do",
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
