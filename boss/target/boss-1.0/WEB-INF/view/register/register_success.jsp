<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="com.thirdParty.entity.Gb2User" %>
注册成功!
<%
    String message = (String)request.getAttribute("message");
    String message1 = (String)request.getAttribute("message1");
    String message2 = (String)request.getAttribute("message2");
    out.println(message);
    out.println("-------------1:");
    out.println(message1);
    out.println("-------------2:");
    out.println(message2);

%>