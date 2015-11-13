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
            url: $("#path").val() + "/surveyController/page_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyName asc",
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

        // 请求下拉表里面的数据
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/surveyDomainController/list_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyDomainId asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                var data = [];
                for (var i = 0; i < m.list.length; i++) {
                    data.push({"value": m.list[i].surveyDomainId, "text": m.list[i].surveyDomainNumber + " (" + m.list[i].surveyDomainName + ")"});
                    $("#search_surveyDomain").append("<option value='" + m.list[i].surveyDomainId + "'>" + m.list[i].surveyDomainName + "</option>")
                }
                $("#question_domain_AMLayer").combobox("loadData", data);
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
            // 全选、取消全选的事件
            if (this.checked) {
                $("input:checkbox").prop('checked', true);
            } else {
                $("input:checkbox").prop('checked', false);
            }
        });

        //    检验是否已存在相同的编号
        $("#survey_number_AMLayer").on('change', function () {
            if ("" == $("#survey_number_AMLayer").val().trim()) {
                $("#detectNum_AMLayer").text("");
                return;
            }
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/surveyController/count_ajax.do",
                data: {
                    "surveyNumber": $("#survey_number_AMLayer").val(),
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

        // 获取所有问题
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/questionController/list_ajax.do",
            data: {
                "orderBy": "questionId asc",
                "visitKey": window.parent.getVisitKey()
            },
            success: function (m) {
                console.log(m);
                if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                    window.parent.location.href = "../index.jsp";
                    return;
                }
                getFirstParentQuestionOfTree(m.list, "surveyQuestionListLayer_left_content");
                getQuestionsTree(m.list, "surveyQuestionListLayer_left_content");

            }
        });

        //    多选框中的关键字搜索框
        $("#listLayer_search").keyup(function () {
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/questionController/list_ajax.do",
                data: {
                    "questionName": $("#listLayer_search").val(),
                    "visitKey": window.parent.getVisitKey()
                },
                success: function (m) {
                    if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                        window.parent.location.href = "../index.jsp";
                        return;
                    }

                    // 整棵树呈现收起状态，无高亮文字
                    $("#surveyQuestionListLayer_left_content").find(".question-down").trigger("click");
                    $("#surveyQuestionListLayer_left_content").find(".red").removeClass("red");

                    if(m.list.length == $("#surveyQuestionListLayer_left_content").find("li").length)
                        return;
                    // 打开检索到的节点
                    for (var i = 0; i < m.list.length; i++){
                        var $node = $("#surveyQuestionListLayer_left_content").find("#"+m.list[i].questionId);
                        $node.addClass("red");
                        $node.parents("div").children("li").children(".question-up").trigger("click");
                    }

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

        resultList = [];
        // 左边多选框中的箭头点击事件
        $("#surveyQuestionListLayer_left_content,#surveyQuestionListLayer_right_content").on('click', 'li span.question-arrow', function () {
            if ($(this).hasClass("question-up")) {
                $(this).parent().next("ul").show();
                $(this).removeClass("question-up");
                $(this).addClass("question-down");
            } else if ($(this).hasClass("question-down")) {
                $(this).parent().next("ul").hide();
                $(this).removeClass("question-down");
                $(this).addClass("question-up");
            }
        });
        // 左边多选框中的问题名称点击事件
        $("#surveyQuestionListLayer_left_content").on('click', 'li span.questions', function () {
            var insert_id = $(this).parent().attr("id");
            // 判断右边是否已经存在相同的节点
            if (0 == $("#surveyQuestionListLayer_right_content").find("#" + insert_id).length)
                $("#surveyQuestionListLayer_right_content").append($(this).parent().parent().clone());
            else
                return;

            // 取消原有的高亮
            $("#surveyQuestionListLayer_right_content").find(".red").removeClass("red");

            // 给每个li添加三个图标
            $("#surveyQuestionListLayer_right_content li").each(function () {
                $(this).children("img").remove();
                $(this).append("<img class='delete_img' src='../img/remove.png'><img class='toUp_img' src='../img/up.png'><img class='toDown_img' src='../img/down.png'>");
            });
        });

        //多选框右部分li事件绑定
        $("#surveyQuestionListLayer_right_content").on({
            mouseenter: function () {
                $(this).find("img").show();
            },
            mouseleave: function () {
                $(this).find("img").hide();
            }
        }, 'li');

        // 多选框右部分li里点击事件绑定
        $("#surveyQuestionListLayer_right_content").on('click', 'li img', function () {

            var $cur_div = $(this).parent().parent();
            // 删除
            if ($(this).hasClass("delete_img")) {

                // 检测该父问题是否还有子问题，否则去掉父问题箭头符号
                if(2 == $cur_div.parent().parent().find("li").length) {
                    $cur_div.parent().parent().children("li").children(".question-down").removeClass("question-down");
                }
                $cur_div.remove();
            }
            // 向上移动
            else if ($(this).hasClass("toUp_img")) {
                if (0 != $cur_div.index()) {
                    var $prev_div = $cur_div.prev();
                    // 移动节点
                    $cur_div.insertBefore($prev_div);
                }
            }
            // 向下移动
            else if ($(this).hasClass("toDown_img")) {
                var parent_children_num = $cur_div.parent().children().length;
                if (parent_children_num != $cur_div.index()) {
                    var $next_div = $cur_div.next();
                    // 移动节点
                    $cur_div.insertAfter($next_div);
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
    if ("" != $("#search_surveyDomain").val())
        blank = false;
    if (blank) {
        alert("请输入搜索内容！");
        return;
    }

    //将数据传给后台并获取相关信息
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/surveyController/page_ajax.do",
        data: {
            "currentPage": "1",
            "pageSize": "20",
            "isLastPage": "false",
            "orderBy": "surveyName asc",
            "surveyNumber": $("#search_number").val(),
            "surveyName": $("#search_name").val(),
            "surveyDescription": $("#search_des").val(),
            "surveyDomainId": $("#search_surveyDomain").val(),
            "visitKey": window.parent.getVisitKey()
        },
        success: function (msg) {
            if (undefined != msg.visitKeyTimeOut && "true" == msg.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(msg);
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
    $("#question_domain_AMLayer").combobox('setValue', "----请选择----");

    $("#AMLayer").css({
        "top": $(window.parent.document).scrollTop() + 50
    });
    $("#AMLayer").show();
    // 显示遮罩层并禁用滚动条
    $("#shelterLayer").show();
    $("body").css({"overflow": "hidden"});
    $(window.parent.document).find("#shelterLayer_main").show();
    $("#geneChecked_AMLayer").text("");

    //移除点击事件，否则会重复
    $("#ok_btn_AMLayer").off('click');
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#survey_name_AMLayer").val() || "" == $("#survey_description_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#question_domain_AMLayer").combobox('getValue') || "---请选择---" == $("#question_domain_AMLayer").combobox('getValue')) {
            alert("请选择调查领域！");
            return;
        }
        if ("" == resultList.codeOfHTML) {
            alert("请选择问题！");
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

        var position = "";
        var questionId = "";
        for (var i in resultList.questionsInfo) {
            position += "&questionList[" + i + "].position=" + resultList.questionsInfo[i][1];
            questionId += "&questionList[" + i + "].questionId=" + resultList.questionsInfo[i][0];
        }
        position = position.substring(1);

        //从后台获取第一页记录数据
        $.ajax({
            traditional: true,
            type: "POST",
            url: $("#path").val() + "/surveyController/insert_ajax.do?" + position + questionId,
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyName asc",
                "surveyNumber": $("#survey_number_AMLayer").val(),
                "surveyName": $("#survey_name_AMLayer").val(),
                "surveyDescription": $("#survey_description_AMLayer").val(),
                "surveyDomainId": $("#question_domain_AMLayer").combobox('getValue'),
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
        $("#survey_number_AMLayer").val("");
        $("#survey_name_AMLayer").val("");
        $("#survey_description_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#showAbout").text("");
        resultList.codeOfHTML = "";
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#survey_number_AMLayer").val("");
        $("#survey_name_AMLayer").val("");
        $("#survey_description_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#showAbout").text("");
        resultList.codeOfHTML = "";
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
    var dataDomain = data.split(",")[4];
    var right_results = [];
    var right_results_name = [];

    $("#survey_name_AMLayer").val(dataName);
    $("#survey_number_AMLayer").val(dataNumber);
    $("#survey_description_AMLayer").val(dataDes);
    $("#question_domain_AMLayer").combobox('select', dataDomain);
    $("#survey_number_AMLayer").select();
    $("#detectNum_AMLayer").text("√");

    //查询该reportDataUnitId对应的question
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/surveyController/findQuestionList_ajax.do",
        data: {
            "surveyId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);

            getFirstParentQuestionOfTree(m.questionList, "surveyQuestionListLayer_right_content");
            getQuestionsTree(m.questionList, "surveyQuestionListLayer_right_content");

            // 给每个li添加三个操作的图标
            $("#surveyQuestionListLayer_right_content li").each(function () {
                $(this).append("<img class='delete_img' src='../img/remove.png'><img class='toUp_img' src='../img/up.png'><img class='toDown_img' src='../img/down.png'>");
            });

            //设置相关信息显示
            setResultList();

        }
    });

    // on() 对同一个元素多次绑定同一个事件的时候，这个事件就会执行多次
    $("#ok_btn_AMLayer").off('click');
    $("#ok_btn_AMLayer").on('click', function () {
        if ("" == $("#survey_name_AMLayer").val() || "" == $("#survey_description_AMLayer").val()) {
            alert("请填写完整信息后提交！");
            return;
        }
        if (undefined == $("#question_domain_AMLayer").combobox('getValue')) {
            alert("请选择调查领域！");
            return;
        }
        if ("" == resultList.codeOfHTML) {
            alert("请选择问题！");
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

        var position = "";
        var questionId = "";
        for (var i in resultList.questionsInfo) {
            position += "&questionList[" + i + "].position=" + resultList.questionsInfo[i][1];
            questionId += "&questionList[" + i + "].questionId=" + resultList.questionsInfo[i][0];
        }
        position = position.substring(1);

        // 将数据传给后台并获取相关信息
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/surveyController/update_ajax.do?" + position + questionId,
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyName asc",
                "surveyId": dataID,
                "surveyNumber": $("#survey_number_AMLayer").val(),
                "surveyName": $("#survey_name_AMLayer").val(),
                "surveyDescription": $("#survey_description_AMLayer").val(),
                "surveyDomainId": $("#question_domain_AMLayer").combobox('getValue'),
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
        $("#survey_number_AMLayer").val("");
        $("#survey_name_AMLayer").val("");
        $("#survey_description_AMLayer").val("");
        $("#detectNum_AMLayer").text("");
        $("#question_domain_AMLayer").combobox('clear');
        $("#showAbout").text("");
        resultList.codeOfHTML = "";
    });

    $("#cancel_btn_AMLayer").on('click', function () {
        $("#AMLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        $("#survey_number_AMLayer").val("");
        $("#survey_name_AMLayer").val("");
        $("#survey_description_AMLayer").val("")
        $("#detectNum_AMLayer").text("");
        $("#question_domain_AMLayer").combobox('clear');
        $("#showAbout").text("");
        resultList.codeOfHTML = "";
    });
}

function modifyChild(data) {

    var dataID = data.split(",")[0];
    var dataNumber = data.split(",")[1];
    var dataName = data.split(",")[2];
    var dataDes = data.split(",")[3];
    var dataDomain = data.split(",")[4];

    //查询该reportDataUnitId对应的question
    $.ajax({
        type: "POST",
        url: $("#path").val() + "/surveyController/findQuestionList_ajax.do",
        data: {
            "surveyId": dataID,
            "visitKey": window.parent.getVisitKey()
        },
        success: function (m) {
            if (undefined != m.visitKeyTimeOut && "true" == m.visitKeyTimeOut) {
                window.parent.location.href = "../index.jsp";
                return;
            }
            console.log(m);

            getFirstParentQuestionOfTree(m.questionList, "surveyQuestionListLayer_right_content");
            getQuestionsTree(m.questionList, "surveyQuestionListLayer_right_content");

            // 给每个li添加三个操作的图标
            $("#surveyQuestionListLayer_right_content li").each(function () {
                $(this).append("<img class='delete_img' src='../img/remove.png'><img class='toUp_img' src='../img/up.png'><img class='toDown_img' src='../img/down.png'>");
            });

            //设置相关信息显示
            setResultList();

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
        setResultList();
        if ("" == resultList.codeOfHTML) {
            alert("请选择问题！");
            return;
        }

        var position = "";
        var questionId = "";
        for (var i in resultList.questionsInfo) {
            position += "&questionList[" + i + "].position=" + resultList.questionsInfo[i][1];
            questionId += "&questionList[" + i + "].questionId=" + resultList.questionsInfo[i][0];
        }
        position = position.substring(1);

        $("#listLayer").hide();
        $.ajax({
            type: "POST",
            url: $("#path").val() + "/surveyController/update_ajax.do?" + position + questionId,
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyName asc",
                "surveyId": dataID,
                "surveyNumber": dataNumber,
                "surveyName": dataName,
                "surveyDescription": dataDes,
                "surveyDomainId": dataDomain,
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
        resultList.codeOfHTML = "";
    });

    $("#cancel_btn_listLayer").on('click', function () {
        $("#listLayer").hide();
        $("#shelterLayer").hide();
        $("body").css({"overflow": ""});
        $(window.parent.document).find("#shelterLayer_main").hide();
        resultList.codeOfHTML = "";
    });
}

//删除方法
function del(dataID) {
    //判断有没有选择要删除的选项
    var delete_IDs = [];

    //读取批量删除,check_IDs为被选择要删除的栏目
    $("#info_content input:checked").each(function () {
        delete_IDs.push($(this).val());
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
            url: $("#path").val() + "/surveyController/delete_ajax.do",
            data: {
                "currentPage": "1",
                "pageSize": "20",
                "isLastPage": "false",
                "orderBy": "surveyName asc",
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
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'><input type='checkbox' value='" + msg.page.list[i].surveyId + "'></li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder less_content_li'>" + msg.page.list[i].surveyNumber + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder more_content_li'>" + msg.page.list[i].surveyName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder large_content_li'>" + msg.page.list[i].surveyDescription + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'>" + msg.page.list[i].surveyDomainName + "</li>");
        $("#ul_" + i).append("<li class='remove_topBorder remove_rightBorder middle_content_li'><a href='javascript:void(0);' onclick=modifyChild('" + msg.page.list[i].surveyId + "," + msg.page.list[i].surveyNumber + "," + msg.page.list[i].surveyName + "," + msg.page.list[i].surveyDescription + "," + msg.page.list[i].surveyDomainId + "')>" + (null == msg.page.list[i].questionNum ? "0" : msg.page.list[i].questionNum) + "</a></li>");
        $("#ul_" + i).append("<li class='remove_topBorder less_content_li'><a href='javascript:void(0);' onclick=modify('" + msg.page.list[i].surveyId + "," + msg.page.list[i].surveyNumber + "," + msg.page.list[i].surveyName + "," + msg.page.list[i].surveyDescription + "," + msg.page.list[i].surveyDomainId + "')>修改</a><a href='javascript:void(0);' onclick=del('" + msg.page.list[i].surveyId + "')>删除</a></li>");

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
            console.log("当前为第" + page + "页");

            // 判断是否点击“最后一页”
            var isLastPage = false;
            if (page == Math.ceil(dataTotalNum / PageSize))
                isLastPage = true;

            //将数据传给后台并获取相关信息
            $.ajax({
                type: "POST",
                url: $("#path").val() + "/surveyController/page_ajax.do",
                data: {
                    "currentPage": page,
                    "pageSize": PageSize,
                    "isLastPage": isLastPage,
                    "orderBy": "surveyNumber asc",
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

//问题多选框
function showQuestion() {
    $("#listLayer").css({
        "top": $(window.parent.document).scrollTop() + 40
    });
    $("#shelterLayer").css({
        "z-index": 4
    });

    // 重置关键字搜索框的内容
    $("#listLayer_search").val("");
    $("#surveyQuestionListLayer_left_content").find(".red").removeClass("red");

    $("#listLayer").show();

    $("#surveyQuestionListLayer_right_content").empty();
    $("#surveyQuestionListLayer_right_content").append(resultList.codeOfHTML);

    $("#ok_btn_listLayer").off('click');
    $("#ok_btn_listLayer").on('click', function () {
        setResultList();

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
function clear_search() {
    $("#search :text").each(function () {
        $(this).val("");
    });
    $("select option:first").prop("selected", true);
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
        url: $("#path").val() + "/surveyController/page_ajax.do",
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

// resultList是一个全局变量，用于保存用户输入的问题结果
function setResultList() {
    resultList.questionsInfo = [];
    $("#surveyQuestionListLayer_right_content li").each(function () {
        var cur_li_info = [$(this).attr("id"), $(this).parent().index(), $(this).find("span").text()];
        resultList.questionsInfo.push(cur_li_info);
    });

    resultList.codeOfHTML = $("#surveyQuestionListLayer_right_content").html();

    //显示选择结果数量
    $("#showAbout").text($("#surveyQuestionListLayer_right_content li").length);
}

// 根据后台返回的数据绘制树
function getFirstParentQuestionOfTree(mlist, area) {
    $("#" + area).empty();
    for (var i = 0; i < mlist.length; i++) {
        if ("" == mlist[i].parentQuestionId) {
            $("#" + area).append("<div><li id='" + mlist[i].questionId + "'><span class='question-arrow'></span><span class='questions'>" + mlist[i].questionName + "</span></li><ul></ul></div>");
        }
    }
}

function getQuestionsTree(mlist, area) {
    for (var i = 0; i < mlist.length; i++) {
        // 判断该子问题是否已存在
        var n = $("#" + area).find("#" + mlist[i].questionId).length;

        if (0 == n && "" != mlist[i].parentQuestionId) {
            $("#" + area).find("#" + mlist[i].parentQuestionId + " span.question-arrow").addClass("question-up");
            $("#" + area).find("#" + mlist[i].parentQuestionId).next("ul").append("<div><li id='" + mlist[i].questionId + "'><span class='question-arrow'></span><span class='questions'>" + mlist[i].questionName + "</span></li><ul></ul><div>");
        }
    }

    // 判断是否全部子问题都已找出，否的话继续查找
    var n = $("#" + area).find("li").length;

    if (n != mlist.length)
        getQuestionsTree(mlist, area);
    else
        return;
}


