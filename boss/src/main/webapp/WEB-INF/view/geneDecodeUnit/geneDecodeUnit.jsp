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
<div id="search"><ul>
    编号:<input type="text" id="search_number">
    解读业务码:<input type="text" id="search_unitCode">
    名称:<input type="text" id="search_name"></ul>
    描述:<input type="text" id="search_des">
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
            <li class="remove_rightBorder smallest_content_li"><input type="checkbox" id="selectAll">全选</li>
            <li class="remove_rightBorder less_content_li canOrder" onclick="reOrder('geneDecodeUnitNumber',this)">编号<span></span></li>
            <li class="remove_rightBorder less_content_li canOrder" onclick="reOrder('unitCode',this)">解读业务码<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('geneDecodeUnitName',this)">基因解读单元名称<span></span></li>
            <li class="remove_rightBorder large_content_li canOrder" onclick="reOrder('geneDecodeUnitDescription',this)">基因解读单元描述<span></span></li>
            <li class="remove_rightBorder more_content_li canOrder" onclick="reOrder('childNum',this)">对应样本测序数量<span></span></li>
            <li class="middle_content_li">操作列</li>
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
<div id="AMLayer" class="addAndModifyLayer_large">
    <div>基因解读单元编号:<input type="text" id="geneDecodeUnit_number_AMLayer" autofocus><span id="detectNum_AMLayer"></span></div>
    <div>基因解读业务码:<input type="text" id="geneDecodeUnit_unitCode_AMLayer"></div>
    <div>基因解读单元名称:<input type="text" id="geneDecodeUnit_name_AMLayer"></div>
    <div>基因解读单元描述:<input type="text" id="geneDecodeUnit_description_AMLayer"></div>
    <div>对应样本测序信息:<span id="showAbout"></span><a href="javascript:void(0);" onclick="showCollectionSequenceInfo()">选择</a></div>
    <div class="ok_cancel_btn">
        <input type="button" value="确定" class="ok_btn" id="ok_btn_AMLayer">
        <input type="button" value="取消" class="cancel_btn" id="cancel_btn_AMLayer">
    </div>
</div>
<%--样本测序信息多选框--%>
<div id="listLayer">
    <div id="listLayer_title">选择对应样本测序信息</div>
    <div id="listLayer_left">
        <div class="margin_top_bottom">
            <input id="listLayer_search" type="text" placeholder="输入查找关键字">
            <img id="clearSearch" src="../img/clear.png" alt="清空">
        </div>
        <div id="listLayer_left_content">
        </div>
    </div>
    <div id="listLayer_right">
        <div class="margin_top_bottom">已选择内容:</div>
        <div id="listLayer_right_content"></div>
        <input id="right_results" type="hidden">
        <input id="right_results_number" type="hidden">
        <input id="right_results_name" type="hidden">
    </div>
    <div id="ok_cancel_btn_listLayer" class="ok_cancel_btn">
        <input type="button" value="确定" id="ok_btn_listLayer" class="ok_btn">
        <input type="button" value="取消" id="cancel_btn_listLayer" class="cancel_btn">
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
<script src="../lib/require.js" data-main="geneDecodeUnit"></script>
</body>
</html>

