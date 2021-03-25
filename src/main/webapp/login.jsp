
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@include file="templates/head.jsp"%>
</head>
<body>
<%@include file="templates/navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm-4 offset-4 mt-5">
            <%
                String errorMessage = "Incorrect password, please try again!";
                Object error = request.getParameter("error");
                if(error!=null) {
                    if(error.equals("1")) errorMessage ="User doesn't exist!";


            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong><%=errorMessage%></strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <div class="container">
            <form action="/login" method="post">

                <div class="form-group">
                    <label>E-mail: </label>
                    <input class="form-control" type="email" name="email" required value="<%=request.getParameter("email")!=null? request.getParameter("email") :""%>">
                </div>
                <div class="form-group">
                    <label>Password: </label>
                    <input class="form-control" type="password" name="password" required>
                </div>
                <div class="form-group mt-1">
                    <button type="submit" class="btn btn-success">Log in</button>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>