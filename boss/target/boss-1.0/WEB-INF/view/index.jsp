<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>BGI-BOSS</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/view/css/login.css">
</head>
<body>
<div id="bg"><img src="<%=request.getContextPath() %>/view/img/xingkon01.png"></div>
<div id="stars"></div>
<div id="main" method="POST">
    <div id="logo"><img src="<%=request.getContextPath() %>/view/img/logo.png"></div>
    <h1>BGI-BOSS 后台管理系统</h1>
    <div id="info">
        <form action="<%=request.getContextPath() %>/loginController/login.do" method="POST" name="login_form" id="login_form">
            <div id="name"><input type="text" placeholder="用户名" id="username" name="adminLoginId" autofocus></div>
            <div id="pwd"><input type="password" placeholder="密码" id="userpwd" name="adminPassword"></div>
            <div><input type="checkbox" id="isRemember" checked>记住我</div>
            <input type="button" value="登录" id="submit_btn" onclick="check()">
            <div>
                <%
                    String visitKey = (String)request.getAttribute("visitKey");
                    if(null != visitKey && "" == visitKey){
                        out.println("登录失败!");
                    }

                %>
            </div>
        </form>
    </div>
</div>
<script src="<%=request.getContextPath() %>/view/lib/require.js" data-main="<%=request.getContextPath() %>/view/main/login"></script>
</body>
</html>