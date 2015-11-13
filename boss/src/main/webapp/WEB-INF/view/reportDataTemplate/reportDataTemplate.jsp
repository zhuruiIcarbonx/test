<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/easyui.css">
    <link rel="stylesheet" type="text/css" href="../css/jqpagination.css">
    <title></title>
</head>
<body>
<div id="search">
    编号:<input type="text" id="search_number">
    使用场景:<input type="text" id="search_scene">
    报告单元:<input type="text" id="search_RDU">
    <input type="button" value="查询" id="search_btn" onclick="search()">
    <input type="button" value="清空" class="clear_btn" onclick="clear_search()">
    <input type="hidden" value="<%=request.getContextPath() %>" id="path">
</div>
<hr>
<div id="operate">
    <input type="button" value="添加" id="add_btn" onclick="add()">
    <input type="button" value="批量删除" id="delete_btn" onclick="del()">
    <div id="dataTotalNum_display">共有 <span id="dataTotalNum">0</span> 条数据</div>
</div>
<div id="info">
    <div id="into_top">
        <div id="info_top">
            <ul>
                <li class="remove_rightBorder less_content_li"><input type="checkbox" id="selectAll">全选</li>
                <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('reportDataTemplateNumber',this)">模板编号<span></span></li>
                <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('reportSceneName',this)">报告使用场景<span></span></li>
                <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('b.reportDataUnitName',this)">报告单元名称<span></span></li>
                <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('reportDataTemplateContent',this)">报告模板内容<span></span></li>
                <li class="more_content_li">操作列</li>
            </ul>
        </div>
    </div>
    <div id="info_content"></div>
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
<!--弹出层-->
<div id="AMLayer" class="addAndModifyLayer_medium">
    <div>报告模板编号:<input type="text" id="reportDataTemplate_number_AMLayer" autofocus><span
            id="detectNum_AMLayer"></span></div>
    <div>报告使用场景:<select class="easyui-combobox" id="reportDataTemplate_scene_AMLayer"></select></div>
    <div>报告单元名称:<select class="easyui-combobox" id="reportDataTemplate_unit_AMLayer"></select></div>
    <div>报告模板内容:<input type="text" id="reportDataTemplate_content_AMLayer"></div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_AMLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_AMLayer">
    </div>
</div>
<div id="deleteLayer">
    <div>确定要删除吗?</div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" id="ok_btn_deleteLayer" class="ok_btn">
        <input type="button" value="取消" id="cancel_btn_deleteLayer" class="cancel_btn">
    </div>
</div>
<!--遮罩层-->
<div id="shelterLayer"></div>
<script src="../lib/require.js" data-main="reportDataTemplate"></script>
</body>
</html>