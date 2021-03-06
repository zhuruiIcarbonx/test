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
<div id="search"><ul>
    名称:<input type="text" id="search_name">
    描述:<input type="text" id="search_des">
    最大值:<input type="text" id="search_max"></ul>
    最小值:<input type="text" id="search_min">
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
    <div id="info_top">
        <ul>
            <li class="remove_rightBorder less_content_li"><input type="checkbox" id="selectAll">全选</li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('physicalExaminationItemUnitName',this)">体检项目单位名称<span></span></li>
            <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('physicalExaminationItemUnitDescription',this)">体检项目单位描述<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('maximumValue',this)">最大值<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('minimumValue',this)">最小值<span></span></li>
            <li class="more_content_li">操作列</li>
        </ul>
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
<div id="AMLayer" class="addAndModifyLayer">
    <div>单位名称:<input type="text" id="physicalExaminationItemUnitName_AMLayer"></div>
    <div>单位描述:<input type="text" id="physicalExaminationItemUnitDescription_AMLayer"></div>
    <div>最大值:<input type="text" id="maximumValue_AMLayer"></div>
    <div>最小值:<input type="text" id="minimumValue_AMLayer"></div>
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
<%--遮罩层--%>
<div id="shelterLayer"></div>
<script src="../lib/require.js" data-main="physicalExaminationItemUnit"></script>
</body>
</html>

