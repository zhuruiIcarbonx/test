<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/jqpagination.css">
    <title></title>
</head>
<body>
<div id="search_large"><ul>
    编号:<input type="text" id="search_number">
    名称:<input type="text" id="search_name">
    描述:<input type="text" id="search_des">
    父问题:<input type="text" id="search_parentName"></ul>
    激活问题:<input type="text" id="search_activeQuestion">
    类型:<select id="search_type">
        <option value="">---请选择---</option>
    </select>
    <input type="button" value="查询" id="search_btn" onclick="search()">
    <input type="button" value="清空" class="clear_btn" onclick="clear_search()">
    <input type="hidden" value="<%=request.getContextPath() %>" id="path">
</div>
<hr>
<div id="operate_large">
    <input type="button" value="添加" id="add_btn" onclick="add()">
    <input type="button" value="批量删除" id="delete_btn" onclick="del()">
    <div id="dataTotalNum_display">共有 <span id="dataTotalNum">0</span> 条数据</div>
</div>
<div id="info_large">
    <div id="info_top_large">
        <ul>
            <li class="remove_rightBorder smallest_content_li"><input type="checkbox" id="selectAll">全选</li>
            <li class="remove_rightBorder less_content_li canOrder" onclick="reOrder('questionNumber',this)">编号<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('questionName',this)">问题名称<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('questionDescription',this)">问题描述<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('parentQuestionName',this)">父问题<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('activeQuestionOptionName',this)">激活问题选项<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('questionType',this)"><span></span>问题类型</li>
            <li class="remove_rightBorder smallest_content_li">选项</li>
            <li class="less_content_li">操作列</li>
        </ul>
    </div>
    <div id="info_content_large"></div>
    <%--页面跳转栏--%>
    <div class="pagination" id="pagination_all">
        <a href="#" class="first" data-action="first">&laquo;</a>
        <a href="#" class="previous" data-action="previous">&lsaquo;</a>
        <input type="text" readonly="readonly" data-max-page="40"/>
        <a href="#" class="next" data-action="next">&rsaquo;</a>
        <a href="#" class="last" data-action="last">&raquo;</a>
    </div>
    <div class="pagination" id="pagination_search">
        <a href="#" class="first" data-action="first">&laquo;</a>
        <a href="#" class="previous" data-action="previous">&lsaquo;</a>
        <input type="text" readonly="readonly" data-max-page="40"/>
        <a href="#" class="next" data-action="next">&rsaquo;</a>
        <a href="#" class="last" data-action="last">&raquo;</a>
    </div>
</div>
<%--弹出层--%>
<div id="AMLayer" class="addAndModifyLayer">
    <div>问题编号:<input type="text" id="question_number_AMLayer"><span id="detectNum_AMLayer"></span></div>
    <div>问题名称:<input type="text" id="question_name_AMLayer"></div>
    <div>问题描述:<input type="text" id="question_description_AMLayer"></div>
    <div>父问题名称:<span id="showAboutParent"></span><a href="javascript:void(0);" onclick="parentQuestion()">选择</a></div>
    <div>激活选项:<select id="question_active_AMLayer"></select></div>
    <div>问题类型:<span id="showAboutType"></span><a href="javascript:void(0);" onclick="questionType()">选择</a></div>
    <div>选项:<span id="showAboutOType"></span><a href="javascript:void(0);" onclick="questionOptions()">选择</a></div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_AMLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_AMLayer">
    </div>
</div>

<%--父问题名称选择框--%>
<div id="parentQuestionLayer">
    <div id="listLayer_title">选择父问题</div>
    <div id="listLayer_left">
        <div class="margin_top_bottom">
            <input id="listLayer_search" type="text" placeholder="输入查找关键字">
            <img id="clearSearch" src="../img/clear.png" alt="清空">
            <input type="hidden" id="parentQuestionResult">
        </div>
        <div id="listLayer_left_content_parentQuestionLayer"></div>
    </div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" id="ok_btn_listLayer" class="ok_btn">
        <input type="button" value="取消" id="cancel_btn_listLayer" class="cancel_btn">
    </div>
</div>

<%--问题类型选择框--%>
<div id="questionTypeLayer">
    <div id="questionTypeLayer_content"></div>
    <input type="hidden" id="questionTypeResult">
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_questionTypeLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_questionTypeLayer">
    </div>
</div>

<%--选项选择框--%>
<div id="questionOptionsLayer">
    <div id="questionOptionsLayer_top">
        <input type="radio" name="optionsType" value="01" checked="checked">单选
        <input type="radio" name="optionsType" value="02">多选
        <input type="radio" name="optionsType" value="03">填空
        <input type="checkbox" id="isRequired" checked="checked">必填
        <input type="hidden" id="optionsResult">
    </div>
    <div id="questionOptionsLayer_content">
        <li><input type="text"><img id="add_option" src="../img/add.png"><img id="del_option" src="../img/delete.png"></li>
    </div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_questionOptionsLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_questionOptionsLayer">
    </div>
</div>

<div id="deleteLayer">
    <div>确定要删除吗?</div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_deleteLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_deleteLayer">
    </div>
</div>
<%--遮罩层--%>
<div id="shelterLayer"></div>

<script src="../lib/require.js" data-main="question"></script>
</body>
</html>