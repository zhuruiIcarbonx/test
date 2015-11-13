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
            url: $("#path").val() + "/questionController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "questionName asc",
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


        // 获取问题类型的树
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/getQustionType_ajax.do",
            data: {
                "visitKey": window.parent.getVisitKey(),
                "jsonFileName": "questionType.json"
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                getQuestionTypeTree(m);
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
        $("#question_number_AMLayer").on('change', function () {
            if(""==$("#question_number_AMLayer").val().trim()){
                $("#detectNum_AMLayer").text("");
                return;
            }

            $.ajax({
                type: "POST",
                url: $("#path").val() + "/questionController/count_ajax.do",
                data: {
                    "questionNumber": $("#question_number_AMLayer").val(),
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
                url: $("#path").val() + "/questionController/list_ajax.do",
                data: {
                    "searchKey": $("#listLayer_search").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
                    if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    $("#listLayer_left_content_parentQuestionLayer").empty();
                    for (var i = 0; i < m.list.length; i++)
                        $("#listLayer_left_content_parentQuestionLayer").append("<li id='" + m.list[i].questionId + "'>" + m.list[i].questionName + "</li>");

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

    });

});

//查询方法
function search() {
    var blank = true;
    $("#search_large :text").each(function(){
        if(""!=$(this).val().trim())
            blank = false;
    });
    if("---请选择---" != $("#search_type").text())
        blank = false;
    if(blank){
        alert("请输入搜索内容！");
        return;
    }

    console.log($("#search_type").val());

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "questionName asc",
            "questionNumber": $("#search_number").val(),
            "questionName": $("#search_name").val(),
            "questionDescription": $("#search_des").val(),
            "parentQuestionId": $("#search_parentName").val(),
            "activeQuestionOptionId": $("#question_active_AMLayer").val(),
            "questionType": $("#search_type").val(),
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
    $("#question_active_AMLayer").append("<option>----请选择----</option>");
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
        if ("" == $("#question_name_AMLayer").val() || "" == $("#question_description_AMLayer").val()) {
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

        var optionsResult = $("#optionsResult").val().split("///");
        var questionOptionType = optionsResult[0];
        var required = optionsResult[1];

        if (optionsResult.length < 3 && "03" != questionOptionType) {
            alert("请填写选项信息！");
            return;
        }

        var param = {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "questionName asc",
            "questionNumber": $("#question_number_AMLayer").val(),
            "questionName": $("#question_name_AMLayer").val(),
            "questionDescription": $("#question_description_AMLayer").val(),
            "parentQuestionId": $("#parentQuestionResult").val(),
            "activeQuestionOptionId": $("#question_active_AMLayer").val(),
            "questionType": $("#questionTypeResult").val(),
            "questionOptionType": questionOptionType,
            "required": required == "true" ? "1" : "0",
            "visitKey": window.parent.getVisitKey()
        };

        for (var i = 0; i < optionsResult.length - 2; i++) {
            param['questionOptionList[' + i + '].position'] = i;
            param['questionOptionList[' + i + '].questionOptionName'] = optionsResult[i + 2];
        }


        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/insert_ajax.do",
            data: param,
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                console.log(msg);
                showData(msg);
            }
        });

        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#question_number_AMLayer").val("");
        $("#question_name_AMLayer").val("");
        $("#question_description_AMLayer").val("");
        $("#parentQuestionResult").val("");
        $("#listLayer_left_content_parentQuestionLayer li").removeClass();
        $("#questionTypeResult").val("");
        $("#optionsResult").val("");
        $("#question_active_AMLayer").empty();
        $("#detectNum_AMLayer").text("");
        $("#showAboutParent").text("");
        $("#showAboutType").text("");
        $("#showAboutOType").text("");
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#question_number_AMLayer").val("");
        $("#question_name_AMLayer").val("");
        $("#question_description_AMLayer").val("");
        $("#parentQuestionResult").val("");
        $("#listLayer_left_content_parentQuestionLayer li").removeClass();
        $("#questionTypeResult").val("");
        $("#optionsResult").val("");
        $("#question_active_AMLayer").empty();
        $("#detectNum_AMLayer").text("");
        $("#showAboutParent").text("");
        $("#showAboutType").text("");
        $("#showAboutOType").text("");
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

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataParent = data.split(",")[4];   //parentQuestionId
    var dataParentName = data.split(",")[5];   //parentQuestionName
    var dataActive = data.split(",")[6];   //activeQuestionOptionId
    var dataType = data.split(",")[7];     //questionType
    var dataOType = data.split(",")[8];    //questionOptionType
    var dataRequired = data.split(",")[9];

    $("#question_number_AMLayer").val(dataNumber);
    $("#question_name_AMLayer").val(dataName);
    $("#question_description_AMLayer").val(dataDes);
    $("#question_name_AMLayer").select();
    $("#parentQuestionResult").val(dataParent);
    $("#question_active_AMLayer").val(dataActive);
    $("#questionTypeResult").val(dataType);
    $("#detectNum_AMLayer").text("√");

    //显示选择结果
    if ("null" != dataParentName)
        $("#showAboutParent").text(dataParentName);
    $("#showAboutType").text(dataType);
    console.log(dataOType);
    switch (dataOType) {
        case "01":
            $("#showAboutOType").text("单选");
            break;
        case "02":
            $("#showAboutOType").text("多选");
            break;
        case "03":
            $("#showAboutOType").text("填空");
            break;
    }

    // 获取该问题对应的激活问题选项
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/findQusOptList_ajax.do",
        data: {
            "questionId": dataParent,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);
            $("#question_active_AMLayer").empty();
            for (var i = 0; i < m.questionOptionList.length; i++) {
                $("#question_active_AMLayer").append("<option value='" + m.questionOptionList[i].questionOptionId + "'>" + m.questionOptionList[i].questionOptionName + "</option>");
            }
            $("option[value='" + dataActive + "']").prop("selected", "true");
        }
    });

    // 获取该问题对应的选项相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/findQusOptList_ajax.do",
        data: {
            "questionId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);

            var option_result = [];
            option_result.push(dataOType);
            option_result.push(dataRequired);
            $("#questionOptionsLayer_content").empty();
            for (var i = 0; i < m.questionOptionList.length; i++) {
                option_result.push(m.questionOptionList[i].questionOptionName);
            }
            //显示选择结果
            option_result = option_result.join("///");
            $("#optionsResult").val(option_result);
        }
    });

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").off('click');
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#surveyDomain_name_modifyLayer").val() || "" == $("#surveyDomain_description_modifyLayer").val()) {
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

        var optionsResult = $("#optionsResult").val().split("///");
        var questionOptionType = optionsResult[0];
        var required = optionsResult[1];

        if (optionsResult.length < 3 && "03" != questionOptionType) {
            alert("请填写选项信息！");
            return;
        }

        var param = {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "questionName asc",
            "questionId": dataID,
            "questionNumber": $("#question_number_AMLayer").val(),
            "questionName": $("#question_name_AMLayer").val(),
            "questionDescription": $("#question_description_AMLayer").val(),
            "parentQuestionId": $("#parentQuestionResult").val(),
            "activeQuestionOptionId": $("#question_active_AMLayer").val(),
            "questionType": $("#questionTypeResult").val(),
            "questionOptionType": questionOptionType,
            "required": required == "true" ? "1" : "0",
            "visitKey": window.parent.getVisitKey()
        };

        for (var i = 0; i < optionsResult.length - 2; i++) {
            param['questionOptionList[' + i + '].position'] = i;
            param['questionOptionList[' + i + '].questionOptionName'] = optionsResult[i + 2];
        }

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/update_ajax.do",
            data: param,
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
        $("#question_number_AMLayer").val("");
        $("#question_name_AMLayer").val("");
        $("#question_description_AMLayer").val("");
        $("#parentQuestionResult").val("");
        $("#listLayer_left_content_parentQuestionLayer li").removeClass();
        $("#questionTypeResult").val("");
        $("#optionsResult").val("");
        $("#question_active_AMLayer").empty();
        $("#detectNum_AMLayer").text("");
        $("#showAboutParent").text("");
        $("#showAboutType").text("");
        $("#showAboutOType").text("");

    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#question_number_AMLayer").val("");
        $("#question_name_AMLayer").val("");
        $("#question_description_AMLayer").val("");
        $("#parentQuestionResult").val("");
        $("#listLayer_left_content_parentQuestionLayer li").removeClass();
        $("#questionTypeResult").val("");
        $("#optionsResult").val("");
        $("#question_active_AMLayer").empty();
        $("#detectNum_AMLayer").text("");
        $("#showAboutParent").text("");
        $("#showAboutType").text("");
        $("#showAboutOType").text("");
    });
}

//修改选项modifyOption
function modifyOption(data) {

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataParent = data.split(",")[4];   //parentQuestionId
    var dataActive = data.split(",")[5];   //activeQuestionOptionId
    var dataType = data.split(",")[6];     //questionType
    var dataOType = data.split(",")[7];    //questionOptionType
    var dataRequired = data.split(",")[8];

    $("#questionOptionsLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#questionOptionsLayer").show();

    // 获取该问题对应的选项相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/findQusOptList_ajax.do",
        data: {
            "questionId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);
            $("input[value='" + dataOType + "']").prop("checked", "true");
            $("input[value='" + dataOType + "']").trigger("click");

            if (dataRequired == 0)
                dataRequired = false;
            else
                dataRequired = true;
            $("#isRequired").prop("checked", dataRequired);

            $("#questionOptionsLayer_content").empty();
            for (var i = 0; i < m.questionOptionList.length; i++) {
                $("#questionOptionsLayer_content").append("<li><input type='text' value='" + m.questionOptionList[i].questionOptionName + "'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
            }
            if ("03" == dataOType)
                $("#questionOptionsLayer_content").html("<p>“填空”不用设置选项</p>");

        }
    });

    $(":radio").off('click');
    $(":radio").on('click', function () {
        $("#questionOptionsLayer_content").empty();
        if ("03" == $(this).val()) {
            $("#questionOptionsLayer_content").html("<p>“填空”不用设置选项</p>");
        } else {
            $("#questionOptionsLayer_content").append("<li><input type='text'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
        }
    });

    $("#questionOptionsLayer_content").off('click');
    $("#questionOptionsLayer_content").on('click', 'li #add_option', function () {
        $("#questionOptionsLayer_content").append("<li><input type='text'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
    });

    $("#questionOptionsLayer_content").on('click', 'li #del_option', function () {
        $(this).parent("li").remove();
    });

    $("#ok_btn_questionOptionsLayer").off('click');
    $("#ok_btn_questionOptionsLayer").on('click', function () {
        var option_result = [];
        $("#questionOptionsLayer_content li :text").each(function (i) {
            if ("" != $(this).val())
                option_result.push($(this).val());
        });

        if (option_result.length == 0 && "03" != $("input[name='optionsType']:checked").val()) {
            alert("请填写完整选项信息！");
            return;
        }

        var param = {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "questionName asc",
            "questionId": dataID,
            "questionNumber": dataNumber,
            "questionName": dataName,
            "questionDescription": dataDes,
            "parentQuestionId": dataParent,
            "activeQuestionOptionId": dataActive,
            "questionType": dataType,
            "questionOptionType": $("#optionsType").val(),
            "required": $("#isRequired").prop("checked") ? "1" : "0",
            "visitKey": window.parent.getVisitKey()
        };

        for (var i = 0; i < option_result.length; i++) {
            param['questionOptionList[' + i + '].position'] = i;
            param['questionOptionList[' + i + '].questionOptionName'] = option_result[i];
        }

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/update_ajax.do",
            data: param,
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                showData(msg);
            }
        });

        $("#questionOptionsLayer").hide();

    });

    $("#cancel_btn_questionOptionsLayer").off('click');
    $("#cancel_btn_questionOptionsLayer").on('click', function () {
        $("#questionOptionsLayer").hide();
    });
}

//修改选项modifyQuestionType
function modifyQuestionType(data) {

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataParent = data.split(",")[4];   //parentQuestionId
    var dataActive = data.split(",")[5];   //activeQuestionOptionId
    var dataType = data.split(",")[6];     //questionType
    var dataOType = data.split(",")[7];    //questionOptionType
    var dataRequired = data.split(",")[8];
    var optionsResult = [];

    $("#questionTypeLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#questionTypeLayer").show();

    $("#questionTypeLayer_content a").removeClass();
    $("a[rel='-" + dataType + "']").addClass("selected_a");

    // 获取该问题对应的选项相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/findQusOptList_ajax.do",
        data: {
            "questionId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            for (var i = 0; i < m.questionOptionList.length; i++) {
                optionsResult.push(m.questionOptionList[i].questionOptionName);
            }
        }
    });

    $('#questionTypeLayer_content').off('click');
    $('#questionTypeLayer_content').on('click', 'a', function () {
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
            $("#questionTypeLayer_content a").removeClass();
            $(this).addClass("selected_a");
        }

    });

    $("#ok_btn_questionTypeLayer").off('click');
    $("#ok_btn_questionTypeLayer").on('click', function () {
        var result = $(".selected_a").attr("rel").substring(1);

        var param = {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "questionName asc",
            "questionId": dataID,
            "questionNumber": dataNumber,
            "questionName": dataName,
            "questionDescription": dataDes,
            "parentQuestionId": dataParent,
            "activeQuestionOptionId": dataActive,
            "questionType": result,
            "questionOptionType": dataOType,
            "required": dataRequired,
            "visitKey": window.parent.getVisitKey()
        };
        for (var i = 0; i < optionsResult.length; i++) {
            param['questionOptionList[' + i + '].position'] = i;
            param['questionOptionList[' + i + '].questionOptionName'] = optionsResult[i];
        }

        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/update_ajax.do",
            data: param,
            success: function (msg) {
                if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                showData(msg);
            }
        });

        $("#questionTypeLayer").hide();
    });

    $("#cancel_btn_questionTypeLayer").off('click');
    $("#cancel_btn_questionTypeLayer").on('click', function () {
        $("#questionTypeLayer").hide();
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
            url: $("#path").val() + "/questionController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "questionName asc",
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
    $("#info_content_large").children().remove();
    $("#dataTotalNum").text(msg.page.dataTotalNum);

    //获取记录并显示，超出页面显示记录数则隐藏
    for (var i = 0; i < msg.page.list.length; i++) {
        $("#info_content_large").append("<ul id='ul_" + i + "'></ul>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><input type='checkbox' value='" + msg.page.list[i].questionId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].questionNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].questionName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].questionDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + (msg.page.list[i].parentQuestionName == null ? "无" : msg.page.list[i].parentQuestionName) + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + (msg.page.list[i].activeQuestionOptionName == null ? "无" : msg.page.list[i].activeQuestionOptionName) + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'><a href='javascript:void(0);' onclick=modifyQuestionType('" + msg.page.list[i].questionId + "," + msg.page.list[i].questionNumber + "," + msg.page.list[i].questionName + "," + msg.page.list[i].questionDescription + "," + msg.page.list[i].parentQuestionId + "," + msg.page.list[i].activeQuestionOptionId + "," + msg.page.list[i].questionType + "," + msg.page.list[i].questionOptionType + "," + msg.page.list[i].required + "')>" + msg.page.list[i].questionType + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder smallest_content_li'><a href='javascript:void(0);' onclick=modifyOption('" + msg.page.list[i].questionId + "," + msg.page.list[i].questionNumber + "," + msg.page.list[i].questionName + "," + msg.page.list[i].questionDescription + "," + msg.page.list[i].parentQuestionId + "," + msg.page.list[i].activeQuestionOptionId + "," + msg.page.list[i].questionType + "," + msg.page.list[i].questionOptionType + "," + msg.page.list[i].required + "')>查看</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder less_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].questionId + "," + msg.page.list[i].questionNumber + "," + msg.page.list[i].questionName + "," + msg.page.list[i].questionDescription + "," + msg.page.list[i].parentQuestionId + "," + msg.page.list[i].parentQuestionName + "," + msg.page.list[i].activeQuestionOptionId + "," + msg.page.list[i].questionType + "," + msg.page.list[i].questionOptionType + "," + msg.page.list[i].required + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].questionId + "')>删除</a></li>");

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
                url: $("#path").val() + "/questionController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "questionName asc",
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
    });
}

// 父问题
function parentQuestion() {

    // 父问题选择框中的问题列表
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/questionController/list_ajax.do",
        data: {
            "orderBy": "questionName asc",
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            $("#listLayer_left_content_parentQuestionLayer").empty();
            for (var i = 0; i < m.list.length; i++) {
                $("#listLayer_left_content_parentQuestionLayer").append("<li id='" + m.list[i].questionId + "'>" + m.list[i].questionName + "</li>");
            }
        }
    });

    $("#parentQuestionLayer").css({
        "top": $(window.parent.document).scrollTop() + 40
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#parentQuestionLayer").show();

    $("#listLayer_left_content_parentQuestionLayer li").removeClass();
    $("#" + $("#parentQuestionResult").val()).addClass("selected_li");

    // 选中的li改变样式
    $('#listLayer_left_content_parentQuestionLayer').off('click');
    $('#listLayer_left_content_parentQuestionLayer').on('click', 'li', function () {
        if($(this).hasClass("selected_li")){
            $(this).removeClass("selected_li");
        }else {
            $("#listLayer_left_content_parentQuestionLayer li").removeClass();
            $(this).addClass("selected_li")
        }
    });

    $("#ok_btn_listLayer").off('click');
    $("#ok_btn_listLayer").on('click', function () {
        //显示选择结果
        $("#showAboutParent").text($(".selected_li").text());
        $("#parentQuestionResult").val($(".selected_li").attr("id"));
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#parentQuestionLayer").hide();

        // 设置激活问题选项
        if ("" == $("#parentQuestionResult").val())
            $("#question_active_AMLayer").val("");
        else {
            //获取该父问题对应的选项
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/questionController/findQusOptList_ajax.do",
                data: {
                    "questionId": $("#parentQuestionResult").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
                    if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }
                    console.log(m);
                    $("#question_active_AMLayer").empty();
                    for (var i = 0; i < m.questionOptionList.length; i++) {
                        $("#question_active_AMLayer").append("<option value='" + m.questionOptionList[i].questionOptionId + "'>" + m.questionOptionList[i].questionOptionName + "</option>");
                    }
                }
            });
        }
    });

    $("#cancel_btn_listLayer").off('click');
    $("#cancel_btn_listLayer").on('click', function () {
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#parentQuestionLayer").hide();
    });
}

// 问题选项
function questionOptions() {
    $("#questionOptionsLayer").css({
        "top": $(window.parent.document).scrollTop() + 150
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#questionOptionsLayer").show();

    var optionsResult = $("#optionsResult").val().split("///");
    if ("" != optionsResult[0]) {
        $("input[value='" + optionsResult[0] + "']").prop("checked", "true");
        $("input[value='" + optionsResult[0] + "']").trigger("click");
    } else {
        $("input[value='01']").prop("checked", "true");
        $("input[value='01']").trigger("click");
    }

    if (optionsResult[1] == 0)
        optionsResult[1] = false;
    else
        optionsResult[1] = true;
    $("#isRequired").prop("checked", optionsResult[1]);

    if (optionsResult.length > 2 && optionsResult[0] != "03") {
        $("#questionOptionsLayer_content").empty();
        for (var i = 0; i < optionsResult.length - 2; i++) {
            $("#questionOptionsLayer_content").append("<li><input type='text' value='" + optionsResult[i + 2] + "'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
        }
    }

    $(":radio").off('click');
    $(":radio").on('click', function () {
        $("#questionOptionsLayer_content").empty();
        if ("03" == $(this).val()) {
            $("#questionOptionsLayer_content").html("<p>“填空”不用设置选项</p>");
        } else {
            $("#questionOptionsLayer_content").append("<li><input type='text'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
        }
    });

    $("#questionOptionsLayer_content").off('click');
    $("#questionOptionsLayer_content").on('click', 'li #add_option', function () {
        $("#questionOptionsLayer_content").append("<li><input type='text'><img id='add_option' src='../img/add.png'><img id='del_option' src='../img/delete.png'></li>");
    });

    $("#questionOptionsLayer_content").on('click', 'li #del_option', function () {
        $(this).parent("li").remove();
    });

    $("#ok_btn_questionOptionsLayer").off('click');
    $("#ok_btn_questionOptionsLayer").on('click', function () {

        //将结果集放在option_result
        var option_result = [];
        option_result.push($("input[name='optionsType']:checked").val());
        option_result.push($("#isRequired").prop("checked"));
        $("#questionOptionsLayer_content li :text").each(function (i) {
            if ("" != $(this).val())
                option_result.push($(this).val());
        });
        option_result = option_result.join("///");

        $("#optionsResult").val(option_result);

        //显示选择结果
        switch ($("input[name='optionsType']:checked").val()) {
            case "01":
                $("#showAboutOType").text("单选");
                break;
            case "02":
                $("#showAboutOType").text("多选");
                break;
            case "03":
                $("#showAboutOType").text("填空");
                break;
        }

        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#questionOptionsLayer").hide();
        $(":radio:first").trigger("click");
        $("#isRequired").prop("checked", "true");
    });

    $("#cancel_btn_questionOptionsLayer").off('click');
    $("#cancel_btn_questionOptionsLayer").on('click', function () {
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#questionOptionsLayer").hide();
        $(":radio:first").trigger("click");
        $("#isRequired").prop("checked", "true");
    });
}

// 问题类型
function questionType() {
    $("#questionTypeLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#shelterLayer").css({
        "z-index": 4
    });
    $("#questionTypeLayer").show();

    $("#questionTypeLayer_content a").removeClass();
    $("a[rel='-" + $("#questionTypeResult").val() + "']").addClass("selected_a");

    $('#questionTypeLayer_content').off('click');
    $('#questionTypeLayer_content').on('click', 'a', function () {
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
            $("#questionTypeLayer_content a").removeClass();
            $(this).addClass("selected_a");
        }

    });

    $("#ok_btn_questionTypeLayer").off('click');
    $("#ok_btn_questionTypeLayer").on('click', function () {
        var result = $(".selected_a").attr("rel").substring(1);
        //显示选择结果
        $("#showAboutType").text(result);

        $("#questionTypeResult").val(result);
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#questionTypeLayer").hide();
    });

    $("#cancel_btn_questionTypeLayer").off('click');
    $("#cancel_btn_questionTypeLayer").on('click', function () {
        $("#shelterLayer").css({
            "z-index": 2
        });
        $("#questionTypeLayer").hide();
    });
}

// 解析JSON数据，获取问题类型的树
function getQuestionTypeTree(m) {
    // 将字符串转换为json对象
    var tree = strToJson(m.qustionType);
    // 解析json数据
    renderMenu(tree, $("#questionTypeLayer_content"), "");

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

// 清空所有搜索框里的内容
function clear_search(){
    $("#search_large :text").each(function(){
        $(this).val("");
    });
    $("#search_large option:first").prop("selected",true);
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
        url: $("#path").val() + "/questionController/page_ajax.do",
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



