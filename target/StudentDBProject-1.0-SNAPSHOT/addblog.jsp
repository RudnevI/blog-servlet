<%--
  Created by IntelliJ IDEA.
  User: РудневИ
  Date: 25.03.2021
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Blog</title>
    <%@include file="templates/head.jsp"%>
    <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <script type="text/javascript">tinymce.init({selector:'#tinemc'});</script>
</head>
<body>
<%@include file="templates/navbar.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-sm-4 offset-4">
            <form method="post">
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Title</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="title">
            </div>
            <div class="mb-3">
                <label class="form-label">Blog Text</label>
                <textarea class="form-control" id="tinemc" rows="3" name="content"></textarea>
            </div>
                <div class="mb-3">
                    <button type="submit">POST</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
