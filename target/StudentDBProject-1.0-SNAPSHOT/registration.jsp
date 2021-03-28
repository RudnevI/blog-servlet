<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 28.03.2021
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>
<%@include file="templates/navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <%
            StringBuilder errorMessage = new StringBuilder();
            Object error = request.getParameter("error");
            if(error != null) {
                if(error.equals("1")) errorMessage.append("User with this email already exists");
                else if(error.equals("2")) errorMessage.append("Password should be at least 8 characters long");
                else if(error.equals("3")) errorMessage.append("Passwords do not match");

        %>
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
            <strong><%=errorMessage.toString()%></strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>


        <%
            }
        %>
    </div>
</div>



<div class="container">
    <div class="row">
        <div class="col-sm-4 offset-4">
    <form action="/registration" method="post">

        <div class="form-group">
            <label>Full name: </label>
            <input class="form-control" type="text" name="full-name" required value="<%=request.getParameter("email")!=null? request.getParameter("email") :""%>">
        </div>

        <div class="form-group">
            <label>E-mail: </label>
            <input class="form-control" type="email" name="email" required value="<%=request.getParameter("email")!=null? request.getParameter("email") :""%>">
        </div>

        <div class="form-group">
            <label>Password: </label>
            <input class="form-control" type="password" name="password" required>
        </div>

        <div class="form-group">
            <label>Confirm password: </label>
            <input class="form-control" type="password" name="confirm-password" required>
        </div>

        <div class="form-group mt-1">
            <button type="submit" class="btn btn-success">Log in</button>
        </div>
    </form>
    </div>
    </div>
</div>
<body>

</body>
</html>
