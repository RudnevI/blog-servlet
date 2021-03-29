<%@ page import="com.example.Collab.entity.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.Collab.dao.DbManager" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blog</title>
    <%@include file="templates/head.jsp"%>
</head>
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