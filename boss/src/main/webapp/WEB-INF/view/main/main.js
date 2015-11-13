require.config({
    paths: {
        "jquery": "../lib/jquery-1.11.1.min"
    }
});

require(['jquery'], function ($) {

    $(document).ready(function () {
        getSidebar();

        $("#sidebar").css({"height": $(window).height()-110});
        $("#mainbody").css({"height": $(window).height()-110});

        $("#sidebar a").click(function () {
            addTab($(this));
            $("#mainbody").removeClass();
        });

        $("#closeFlash").on('click', function () {
            $("#flash_iframe").hide();
            $("#closeFlash").hide();
            $("body").css({"overflow": ""});
        });

        // sidebar树形菜单控制 1.9开始不支持toggle()
        $('#sidebar dl').on('click', 'dt', function () {
            $(this).next(".list").animate({
                height: 'toggle',
                opacity: 'toggle'
            }, "slow");

            //更改树形菜单图标
            if ($(this).hasClass("menu-up")) {
                $(this).removeClass();
                $(this).addClass("menu-down");
            }else{
                $(this).removeClass();
                $(this).addClass("menu-up");
            }
        });

        //jquery 1.7后不支持live()方法，替代为on()
        $('#tabs').on('click', 'a.tab', function () {
            // Get the tab name
            var contentname = $(this).attr("id") + "_content";

            // hide all other tabs
//            $("#content p").hide();-------------
            $("#tabs li").removeClass("current");

            // show current tab
            $("#" + contentname).show();
            $(this).parent().addClass("current");

        });

        $('#tabs').on('click', 'a.remove', function () {
            // Get the tab name
            var tabid = $(this).parent().find(".tab").attr("id");

            // remove tab
            $(this).parent().remove();

            // if there is no current tab and if there are still tabs left, show the first one
            if ($("#tabs li.current").length == 0 && $("#tabs li").length > 0) {

                // find the first tab and change the content
                var firsttab = $("#tabs li:first-child");
                firsttab.addClass("current");
                showIframe(firsttab.find("a.tab").attr("target"));

                // get its link name and show related content
//                var firsttabid = $(firsttab).find("a.tab").attr("id");
//                $("#" + firsttabid + "_content").show();
            }
            if ($("#tabs li").length == 0) {
                $("iframe").hide();
                $("#mainbody").addClass("mainbody_init");
            }
        });

    });

});

function addTab(link) {
    //当该tab标签已经存在时
    if ($("#" + $(link).attr("rel")).length != 0) {
        $("#tabs li").removeClass("current");
        //设置当前标签页底色为浅色，其他为暗色
        $("#" + $(link).attr("rel")).parent().addClass("current");
        return;
    }

    // 隐藏其他的标签
    $("#tabs li").removeClass("current");

    // 新增一个标签并显示对应的iframe
    $("#tabs").append("<li class='current'><a class='tab' id='" +
        $(link).attr("rel") + "' href='javascript:void(0);' target='" + $(link).attr("target") + "' onclick=showIframe('" + $(link).attr("target") + "') >" + $(link).html() +
        "</a><a href='#' class='remove'>X</a></li>");

}

function getSidebar() {
    var data = [
        [
            ["样本与测序"],
            ["样本信息", $("#path").val()+"/view/collectionInformation/collectionInformation.jsp"],
            ["测序范围", $("#path").val()+"/view/sequenceScope/sequenceScope.jsp"],
            ["样本测序信息", $("#path").val()+"/view/collectionSequenceInformation/collectionSequenceInformation.jsp"]
        ],
        [
            ["报告相关"],
            ["报告场景", $("#path").val()+"/view/reportScene/reportScene.jsp"]
        ],
        [
            ["数据处理"],
            ["解读单元", $("#path").val()+"/view/geneDecodeUnit/geneDecodeUnit.jsp"],
            ["报告单元", $("#path").val()+"/view/reportDataUnit/reportDataUnit.jsp"],
            ["报告模板", $("#path").val()+"/view/reportDataTemplate/reportDataTemplate.jsp"]
        ],
        [
            ["商品"],
            ["样本处理流程表", $("#path").val()+"/view/processInformation/processInformation.jsp"],
            ["商品表", $("#path").val()+"/view/product/product.jsp"]
        ],
        [
            ["体检报告"],
            ["体检项目单位", $("#path").val()+"/view/physicalExaminationItemUnit/physicalExaminationItemUnit.jsp"],
            ["体检项目", $("#path").val()+"/view/physicalExaminationItem/physicalExaminationItem.jsp"]
        ],
        [
            ["问卷"],
            ["调查领域", $("#path").val()+"/view/surveyDomain/surveyDomain.jsp"],
            ["问题", $("#path").val()+"/view/question/question.jsp"],
            ["问卷调查", $("#path").val()+"/view/survey/survey.jsp"]
        ],
        [
            ["系统文件"],
            ["数据字典", $("#path").val()+"/view/gb2Dict/gb2Dict.jsp"]
        ],
        [
            ["用户信息"],
            ["用户", $("#path").val()+"/view/gb2User/gb2User.jsp"],
            ["第三方系统", $("#path").val()+"/view/thirdPartySystem/thirdPartySystem.jsp"]
        ]
    ];

    for (var i = 0; i < data.length; i++) {
        $("#sidebar").append("<dl><dt class='menu-up'>" + data[i][0] + "</dt><div id='list" + i + "'class='list'></div></dl>");

        for (var j = 1; j < data[i].length; j++) {
            $("#mainbody").append("<iframe name='iframe_" + i + "_" + j + "' id='iframe_" + i + "_" + j + "'></iframe>");
            $("#list" + i).append("<dd><a target='iframe_" + i + "_" + j + "' onclick=showIframe('iframe_" + i + "_" + j + "') href='" + data[i][j][1] + "' rel='TAB_" + i + "_" + j + "'>" + data[i][j][0] + "</a></dd>");
        }
    }
}

function showIframe(target) {
    $("iframe").hide();
    $("#" + target).show();
}

function getVisitKey(){
    return $("#visitKey").val();
}




