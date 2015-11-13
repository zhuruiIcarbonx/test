<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>BGI-BOSS</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/view/css/main.css">
</head>
<body>
<div id="wrap">
    <input type="hidden" id="visitKey" value="${visitKey}">
    <input type="hidden" id="path" value="<%=request.getContextPath()%>">
    <div id="header">
        <h1>BGI-BOSS系统</h1>
        <div id="header_bottom">
            <span><img src="<%=request.getContextPath() %>/view/img/head_user.png"></span>
            <span>欢迎你,</span>
            <div id="wellcome_name">${currentUser.adminName}</div>
            <div id="logout"><a href="<%=request.getContextPath()%>/loginController/logout.do">退出</a></div>
        </div>
    </div>

    <div id="sidebar">
        <h2>目 录</h2>
    </div>
    <div id="mainbody" class="mainbody_init">
        <ul id="tabs">
            <!--这里增加tabs-->
        </ul>
    </div>
</div>
<!--flash关闭层-->
<div id="closeFlash">
    <img src="<%=request.getContextPath() %>/view/img/close.png">
</div>
<!--flash层-->
<iframe id="flash_iframe"></iframe>
<!--父窗口遮罩层-->
<div id="shelterLayer_main"></div>
<script src="<%=request.getContextPath() %>/view/lib/require.js" data-main="<%=request.getContextPath() %>/view/main/main"></script>
</body>
</html>