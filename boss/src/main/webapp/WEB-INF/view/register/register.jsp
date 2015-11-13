<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<form action="<%=request.getContextPath() %>/gb2UserController/insert1.do" method="post" id="register_form">
    <div><input type="text" placeholder="用户名" name="username" id="username"></div>
    <div><input type="text" placeholder="邮箱" name="email" id="email"></div>
    <div><input type="password" placeholder="密码" name="userpassword" id="userpwd"></div>
    <div><input type="password" placeholder="确认密码" id="userpwd_confirm"></div>
    <div><input type="button" value="注册" onclick="registerCheck()"></div>
</form>

<script src="../lib/jquery-1.11.1.min.js"></script>
<script src="register.js"></script>
</body>
</html>