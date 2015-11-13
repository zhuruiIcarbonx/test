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
    收集类型:<input type="text" id="search_CType"></ul>
    物流类别:<input type="text" id="search_LType">
    分离人:<input type="text" id="search_EType">
    测序人:<input type="text" id="search_SType">
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
            <li class="remove_rightBorder smallest_content_li canOrder" onclick="reOrder('processInformationNumber',this)">编号<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('processInformationName',this)">处理流程名称<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('processInformationDescription',this)">处理流程描述<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('sampleCollectorType',this)">样本收集类型<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('sampleLogisticType',this)">样本物流类别<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('sampleExtractionType',this)">样本分离执行人<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('sampleSequenceType',this)">样本测序执行人<span></span></li>
            <li class="smallest_content_li">操作列</li>
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
<!--弹出层-->
<div id="AMLayer" class="addAndModifyLayer_medium">
    <div>处理流程编号:<input type="text" id="processInfo_number"><span id="detectNum_AMLayer"></span></div>
    <div>处理流程名称:<input type="text" id="processInfo_name"></div>
    <div>处理流程描述:<input type="text" id="processInfo_description"></div>
    <div>样本收集类型:<input type="text" id="sampleCollectorType"></div>
    <div>样本物流类别:<input type="text" id="sampleLogisticType"></div>
    <div>样本分离执行人:<input type="text" id="sampleExtractionType"></div>
    <div>样本测序执行人:<input type="text" id="sampleSequenceType"></div>
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
<script src="../lib/require.js" data-main="processInformation"></script>
</body>
</html>

