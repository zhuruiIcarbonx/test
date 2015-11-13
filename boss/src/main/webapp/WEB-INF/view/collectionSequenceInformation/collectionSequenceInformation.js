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
            url: $("#path").val() + "/collectionSequenceInformationController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "collectionSequenceInformationNumber asc",
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

        //请求下拉表里面的数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/collectionInformationController/list_ajax.do",
            data: {
                "orderBy": "collectionInformationNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                var data = [];
                for (var i = 0; i < m.list.length; i++) {
                    $("#collectionInfo_AMLayer").append("<option value='" + m.list[i].collectionInformationId + "'>" + m.list[i].collectionInformationNumber + " (" + m.list[i].collectionInformationName + ")</option>");
                    data.push({"value": m.list[i].collectionInformationId, "text": m.list[i].collectionInformationNumber + " (" + m.list[i].collectionInformationName + ")"});
                }
                $("#collectionInfo_AMLayer").combobox("loadData", data);
            }
        });

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/sequenceScopeController/list_ajax.do",
            data: {
                "orderBy": "sequenceScopeNumber asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                var data = [];
                for (var i = 0; i < m.list.length; i++) {
                    $("#sequenceScope_AMLayer").append("<option value='" + m.list[i].sequenceScopeId + "'>" + m.list[i].sequenceScopeNumber + " (" + m.list[i].sequenceScopeName + ")</option>");
                    data.push({"value": m.list[i].sequenceScopeId, "text": m.list[i].sequenceScopeNumber + " (" + m.list[i].sequenceScopeName + ")"});
                }
                $("#sequenceScope_AMLayer").combobox("loadData", data);
            }
        });

        //再次渲染EASYUI
        var _9203 = setInterval(parse, 10);

        function parse() {
            if ($.parser && $.fn.slider && !window.renderedFlag) {
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


    });

    //    检验是否已存在相同的编号
    $("#collectionInfo_number_AMLayer").on('change', function () {
        if ("" == $("#collectionInfo_number_AMLayer").val().trim()) {
            $("#detectNum_AMLayer").text("");
            return;
        }
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/collectionSequenceInformationController/count_ajax.do",
            data: {
                "collectionSequenceInformationNumber": $("#collectionInfo_number_AMLayer").val(),
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
    if("" != $("#search_medicaid").val())
        blank = false;
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/collectionSequenceInformationController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "collectionSequenceInformationNumber asc",
            "collectionSequenceInformationNumber": $("#search_number").val(),
            "collectionSequenceInformationName": $("#search_name").val(),
            "collectionSequenceInformationDescription": $("#search_des").val(),
            "isMedicaid": $("#search_medicaid").val(),
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

    $("#collectionInfo_AMLayer").combobox('setValue',"---请选择---");
    $("#sequenceScope_AMLayer").combobox('setValue',"---请选择---");
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
        if ("" == $("#collection_name_AMLayer").val() || "" == $("#collection_description_AMLayer").val() || "" == $("#collectionInfo_number_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#collectionInfo_AMLayer").combobox('getValue')||"---请选择---" == $("#collectionInfo_AMLayer").combobox('getValue')) {
            alert("请选择下拉框中的样本信息！");
            return;
        }
        if (undefined == $("#sequenceScope_AMLayer").combobox('getValue')||"---请选择---" == $("#sequenceScope_AMLayer").combobox('getValue')) {
            alert("请选择下拉框中的测序范围！");
            return;
        }
        if ("" == $("#detectNum_AMLayer").text()) {
            alert("请填写编号！");
            return;
        }
        if ("√" != $("#detectNum_AMLayer").text()) {
            alert("该编号已存在！");
            return;
        }

//        //从后台获取第一页记录数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/collectionSequenceInformationController/insert_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "collectionSequenceInformationNumber asc",
                "collectionSequenceInformationNumber": $("#collectionInfo_number_AMLayer").val(),
                "collectionSequenceInformationName": $("#collection_name_AMLayer").val(),
                "collectionSequenceInformationDescription": $("#collection_description_AMLayer").val(),
                "sequenceScopeId": $("#sequenceScope_AMLayer").combobox('getValue'),
                "collectionInformationId": $("#collectionInfo_AMLayer").combobox('getValue'),
                "isMedicaid": $("#isMedicaid_AMLayer").prop("checked") ? "1" : "0",
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
        $("#collectionInfo_number_AMLayer").val("");
        $("#collection_name_AMLayer").val("");
        $("#collection_description_AMLayer").val("");
        $("#isMedicaid_AMLayer").attr("checked", false);
        $("#detectNum_AMLayer").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#collectionInfo_number_AMLayer").val("");
        $("#collection_name_AMLayer").val("");
        $("#collection_description_AMLayer").val("");
        $("#isMedicaid_AMLayer").attr("checked", false);
        $("#detectNum_AMLayer").text("");
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
    var dataInfo = data.split(",")[2];
    var dataScope = data.split(",")[3];
    var dataName = data.split(",")[4];
    var dataDes = data.split(",")[5];
    var isMedicaid_string = data.split(",")[6];
    var isMedicaid = ("1" == isMedicaid_string) ? true : false;

    $("#collectionInfo_number_AMLayer").val(dataNumber);
    $("#collectionInfo_number_AMLayer").select();
    $("#collectionInfo_AMLayer").combobox('select', dataInfo);
    $("#sequenceScope_AMLayer").combobox('select', dataScope);
    $("#collection_name_AMLayer").val(dataName);
    $("#collection_description_AMLayer").val(dataDes);
    $("#isMedicaid_AMLayer").prop("checked", isMedicaid);
    $("#detectNum_AMLayer").text("√");

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#collection_name_AMLayer").val() || "" == $("#collection_description_AMLayer").val() || "" == $("#collectionInfo_number_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#collectionInfo_AMLayer").combobox('getValue')) {
            alert("请选择下拉框中的样本信息！");
            return;
        }
        if (undefined == $("#sequenceScope_AMLayer").combobox('getValue')) {
            alert("请选择下拉框中的测序范围！");
            return;
        }
        if ("" == $("#detectNum_AMLayer").text()) {
            alert("请填写编号！");
            return;
        }
        if ("√" != $("#detectNum_AMLayer").text()) {
            alert("该编号已存在！");
            return;
        }

        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/collectionSequenceInformationController/update_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "collectionSequenceInformationNumber asc",
                "collectionSequenceInformationId": dataID,
                "collectionSequenceInformationNumber": $("#collectionInfo_number_AMLayer").val(),
                "collectionSequenceInformationName": $("#collection_name_AMLayer").val(),
                "collectionSequenceInformationDescription": $("#collection_description_AMLayer").val(),
                "sequenceScopeId": $("#sequenceScope_AMLayer").combobox('getValue'),
                "collectionInformationId": $("#collectionInfo_AMLayer").combobox('getValue'),
                "isMedicaid": $("#isMedicaid_AMLayer").prop("checked") ? "1" : "0",
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
        $("#collectionInfo_number_AMLayer").val("");
        $("#collection_name_AMLayer").val("");
        $("#collection_description_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#collectionInfo_number_AMLayer").val("");
        $("#collection_name_AMLayer").val("");
        $("#collection_description_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
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
            url: $("#path").val() + "/collectionSequenceInformationController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "collectionSequenceInformationNumber asc",
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

    $("#info_content").children().remove();
    $("#dataTotalNum").text(msg.page.dataTotalNum);
    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {

        $("#info_content").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><input type='checkbox' value='" + msg.page.list[i].collectionSequenceInformationId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].collectionSequenceInformationNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].collectionInformation.collectionInformationName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].sequenceScope.sequenceScopeName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].collectionSequenceInformationName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].collectionSequenceInformationDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + ("1"==msg.page.list[i].isMedicaid ? "是" : "否") + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder smallest_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].collectionSequenceInformationId + "," + msg.page.list[i].collectionSequenceInformationNumber + "," + msg.page.list[i].collectionInformationId + "," + msg.page.list[i].sequenceScopeId + "," + msg.page.list[i].collectionSequenceInformationName + "," + msg.page.list[i].collectionSequenceInformationDescription + "," + msg.page.list[i].isMedicaid + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].collectionSequenceInformationId + "')>删除</a></li>");

    }

}

function showPage(msg) {

    //分页功能实现
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
                url: $("#path").val() + "/collectionSequenceInformationController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "collectionSequenceInformationName asc",
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
function clear_search() {
    $("#search :text").each(function () {
        $(this).val("");
    });
    $("#search select option:first").prop("selected",true);
}

//重新排序
function reOrder(data, _li) {
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
        url: $("#path").val() + "/collectionSequenceInformationController/page_ajax.do",
        data: {
            "orderBy": data + order,
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
}



