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
            url: $("#path").val() + "/productController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "productNumber asc",
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

        // 获取所有报告数据单元
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/reportDataUnitController/list_ajax.do",
            data: {
                "orderBy": "reportDataUnitNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                for (var i = 0; i < m.list.length; i++) {
                    $("#listLayer_left_content").append("<li id='" + m.list[i].reportDataUnitId + "'>" + m.list[i].reportDataUnitNumber + " (" + m.list[i].reportDataUnitName + ")</li>");
                }
            }
        });

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/processInformationController/list_ajax.do",
            data: {
                "orderBy": "processInformationName asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                var data = [];
                for (var i = 0; i < m.list.length; i++) {
                    data.push({"value": m.list[i].processInformationId, "text": m.list[i].processInformationNumber + " (" + m.list[i].processInformationName + ")"});
                }
                console.log(data);
                $("#processInfo_AMLayer").combobox("loadData", data);
            }
        });
        //再次渲染EASYUI
        var _9203 = setInterval(parse,10);
        function parse(){
            if($.parser && $.fn.slider && !window.renderedFlag){
                clearInterval(_9203);
                $.parser.parse();
                window.renderedFlag = true;
            }
        }

        $("#selectAll").on('click', function () {
            if (this.checked) {
                $("input:checkbox").prop('checked', true);
            } else {
                $("input:checkbox").prop('checked', false);
            }
        });

        //    多选框中的关键字搜索框
        $("#listLayer_search").keyup(function () {
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/geneDecodeUnitController/list_ajax.do",
                data: {
                    "searchChildKey": $("#listLayer_search").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
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

    //    检验是否已存在相同的编号
    $("#product_number_AMLayer").on('change', function () {
        if(""==$("#product_number_AMLayer").val().trim()){
            $("#detectNum_AMLayer").text("");
            return;
        }
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/productController/count_ajax.do",
            data: {
                "productNumber": $("#product_number_AMLayer").val(),
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
        url: $("#path").val() + "/productController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "productNumber asc",
            "productNumber": $("#search_number").val(),
            "productName": $("#search_name").val(),
            "productDescription": $("#search_des").val(),
            "productPrice": $("#search_price").val(),
            "processInformationName": $("#search_processInfo").val(),
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
    $("#processInfo_AMLayer").combobox('setValue',"----请选择----");
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
        if ("" == $("#product_name_AMLayer").val() || "" == $("#product_description_AMLayer").val() || "" == $("#product_number_AMLayer").val() || "" == $("#product_price_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#processInfo_AMLayer").combobox('getValue')||"---请选择---" == $("#processInfo_AMLayer").combobox('getValue')) {
            alert("请选择样本处理流程！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择对应报告数据单元！");
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
            url: $("#path").val() + "/productController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "productNumber asc",
                "productNumber": $("#product_number_AMLayer").val(),
                "productName": $("#product_name_AMLayer").val(),
                "productDescription": $("#product_description_AMLayer").val(),
                "productPrice": $("#product_price_AMLayer").val(),
                "reportDataUnitIds": $("#right_results").val(),
                "processInformationId": $("#processInfo_AMLayer").combobox('getValue'),
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
        $("#product_number_AMLayer").val("");
        $("#product_name_AMLayer").val("");
        $("#product_description_AMLayer").val("");
        $("#product_price_AMLayer").val("");
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
        $("#product_number_AMLayer").val("");
        $("#product_name_AMLayer").val("");
        $("#product_description_AMLayer").val("");
        $("#product_price_AMLayer").val("");
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
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataPrice = data.split(",")[4];
    var dataProInfo = data.split(",")[5];
    var right_results = [];
    var right_results_number = [];
    var right_results_name = [];

    $("#product_number_AMLayer").val(dataNumber);
    $("#product_name_AMLayer").val(dataName);
    $("#product_description_AMLayer").val(dataDes);
    $("#product_price_AMLayer").val(dataPrice);
    $("#product_number_AMLayer").select();
    $("#processInfo_AMLayer").combobox('select', dataProInfo);
    $("#detectNum_AMLayer").text("√");

    //查询该productId对应的reportDataUnit
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/productController/listMap_ajax.do",
        data: {
            "productId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            console.log(m);
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);
            for (var i = 0; i < m.list.length; i++) {
                right_results.push(m.list[i].reportDataUnitId);
                right_results_number.push(m.list[i].reportDataUnitNumber);
                right_results_name.push(m.list[i].reportDataUnitName);
            }

            //显示选择结果数量
            $("#showAbout").text(m.list.length);

            $("#right_results").val(right_results);
            $("#right_results_number").val(right_results_number);
            $("#right_results_name").val(right_results_name);
        }
    });

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#product_name_AMLayer").val() || "" == $("#product_description_AMLayer").val() || "" == $("#product_number_AMLayer").val() || "" == $("#product_price_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#processInfo_AMLayer").combobox('getValue')) {
            alert("请选择样本处理流程！");
            return;
        }
        if ("" == $("#right_results").val()) {
            alert("请选择对应报告数据单元！");
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
            url: $("#path").val() + "/productController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "productNumber asc",
                "productId": dataID,
                "productNumber": $("#product_number_AMLayer").val(),
                "productName": $("#product_name_AMLayer").val(),
                "productDescription": $("#product_description_AMLayer").val(),
                "productPrice": $("#product_price_AMLayer").val(),
                "reportDataUnitIds": $("#right_results").val(),
                "processInformationId": $("#processInfo_AMLayer").combobox('getValue'),
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
        $("#product_number_AMLayer").val("");
        $("#product_name_AMLayer").val("");
        $("#product_description_AMLayer").val("");
        $("#product_price_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#showAbout").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#product_number_AMLayer").val("");
        $("#product_name_AMLayer").val("");
        $("#product_description_AMLayer").val("");
        $("#product_price_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#showAbout").text("");
    });
}

function modifyChild(data) {

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataPrice = data.split(",")[4];
    var dataProInfo = data.split(",")[5];

    $.ajax({
        type: "POST",
        url: $("#path").val() + "/productController/listMap_ajax.do",
        data: {
            "productId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            console.log(m);
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            $("#listLayer_right_content").empty();
            for (var i = 0; i < m.list.length; i++) {
                $("#listLayer_right_content").append("<li id='" + m.list[i].reportDataUnitId + "'>" + m.list[i].reportDataUnitNumber + " (" + m.list[i].reportDataUnitName + ")<img class='rightX' src='../img/remove.png'></li>");
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
            alert("请选择对应报告数据单元！");
            return;
        }
        $("#listLayer").hide();
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/productController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "productNumber asc",
                "productId": dataID,
                "productNumber": dataNumber,
                "productName": dataName,
                "productDescription": dataDes,
                "productPrice": dataPrice,
                "reportDataUnitIds": $("#right_results").val(),
                "processInformationId":dataProInfo,
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
            url: $("#path").val() + "/productController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "productNumber asc",
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
    $("#info_content").children().remove();
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><input type='checkbox' value='" + msg.page.list[i].productId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].productNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].productName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].productDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].productPrice + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'><a href='javascript:void(0);' onclick=modifyChild('" + msg.page.list[i].productId + "," + msg.page.list[i].productNumber + "," + msg.page.list[i].productName + "," + msg.page.list[i].productDescription + "," + msg.page.list[i].productPrice + "," + msg.page.list[i].processInformationId + "')>" + (null==msg.page.list[i].reportDataUnitNum?'0':msg.page.list[i].reportDataUnitNum) + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].processInformationName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder smallest_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].productId + "," + msg.page.list[i].productNumber + "," + msg.page.list[i].productName + "," + msg.page.list[i].productDescription + "," + msg.page.list[i].productPrice + "," + msg.page.list[i].processInformationId + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].productId + "')>删除</a></li>");
    }

}

function showPage(msg) {

    var PageSize = msg.page.pageSize;
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
                url: $("#path").val() + "/productController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "productNumber asc",
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

//弹出报告数据单元多选框
function showReportDataUnit() {
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
            right_results_name.push(results_name.substring(1, results_name.length - 1));
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
        url: $("#path").val() + "/productController/page_ajax.do",
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

