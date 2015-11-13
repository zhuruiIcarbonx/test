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
    编号:<input type="text" id="search_number">
    名称:<input type="text" id="search_name">
    描述:<input type="text" id="search_des"></ul>
    是否医学用途:<select id="search_medicaid">
                <option value="">----请选择----</option>
                <option value="1">是</option>
                <option value="0">否</option>
            </select>
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
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('collectionSequenceInformationNumber',this)">测序编号<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('collectionInformationName',this)">对应样本信息<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('sequenceScopeName',this)">对应测序范围<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('collectionSequenceInformationName',this)">样本测序名称<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('collectionSequenceInformationDescription',this)">样本描述<span></span></li>
            <li class="remove_rightBorder middle_content_li canOrder" onclick="reOrder('isMedicaid',this)">是否医学用途<span></span></li>
            <li class="smallest_content_li">操作列</li>
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
<div id="AMLayer" class="addAndModifyLayer_medium">
    <div>样本测序编号:<input type="text" id="collectionInfo_number_AMLayer" autofocus><span id="detectNum_AMLayer"></span></div>
    <div>对应样本信息:<select class="easyui-combobox" id="collectionInfo_AMLayer"></select></div>
    <div>对应测序范围:<select class="easyui-combobox" id="sequenceScope_AMLayer"></select></div>
    <div>样本测序名称:<input type="text" id="collection_name_AMLayer"></div>
    <div>样本测序描述:<input type="text" id="collection_description_AMLayer"></div>
    <div class="center"><input type="checkbox" id="isMedicaid_AMLayer">是否医学用途</div>

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
<script src="../lib/require.js" data-main="collectionSequenceInformation"></script>
</body>
</html>
