<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Soteria Demo App</title>
    <link href="${mvc.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${mvc.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <c:if test="${errors != null}">
    <div class="row">
        <div class="col-md-12">
            <p class="alert alert-danger">${errors}</p>
        </div>
    </div>
    </c:if>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form method="post">
                <h2>Self-Registration</h2>
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" placeholder="Username" autofocus>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Email address">
                </div>
                <button class="btn btn-primary btn-block" type="submit">Register</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
