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
<div id="search">
    <select id="sort_search">
        <option value="">请选择...</option>
        <option value="userName">用户名</option>
        <option value="phoneNumber">电话号码</option>
        <option value="sexName">性别</option>
    </select>
    <input type="text" id="text_search">
    <input type="button" value="查询" id="search_btn" onclick="search()">
    <input type="hidden" value="<%=request.getContextPath() %>" id="path">
</div>
<hr>
<div id="operate">
    <%--<input type="button" value="添加" id="add_btn" onclick="add()">--%>
    <input type="button" value="批量删除" id="delete_btn" onclick="del()">
    <div id="dataTotalNum_display">共有 <span id="dataTotalNum">0</span> 条数据</div>
</div>
<div id="info">
    <div id="info_top">
        <ul>
            <li class="remove_rightBorder middle_content_li"><input type="checkbox" id="selectAll">全选</li>
            <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('userName',this)">用户名<span></span></li>
            <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('phoneNumber',this)">电话号码<span></span></li>
            <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('sex',this)">性别<span></span></li>
            <li class="large_content_li">操作列</li>
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
    <div>用户名:<input type="text" id="name_gb2User" autofocus></div>
    <div>电话号码:<input type="text" id="phoneNumber_gb2User"></div>
    <div>性别:<select id="sex_gb2User"></select>
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
<script src="../lib/require.js" data-main="gb2User"></script>
</body>
</html>

