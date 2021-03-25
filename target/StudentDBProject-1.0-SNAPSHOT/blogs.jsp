<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Collab.entity.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Collab.dao.DbManager" %><%--
  Created by IntelliJ IDEA.
  User: РудневИ
  Date: 25.03.2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog list</title>
</head>
<%@include file="templates/head.jsp"%>
<body>
<%@include file="templates/navbar.jsp"%>
    <%
        List<Blog> blogs = (List<Blog>) request.getAttribute("blogs");


        for (Blog blog:
             blogs) {


    %>
<div class="container">
    <div class="row">
        <div class="col-sm-6 offset-3">
            <p><%=blog.getTitle()%> <sub><%=DbManager.getUserById(blog.getAuthorId()).getFullName()%></sub></p>
            <hr>
            <p><%=blog.getContent()%></p>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
