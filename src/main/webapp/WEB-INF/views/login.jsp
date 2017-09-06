<%--
  Created by IntelliJ IDEA.
  User: Niko
  Date: 05.09.17
  Time: 09:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <form method="post">
                <h2>Please sign in</h2>
                <div class="form-group">
                    <label for="username">Username / Email</label>
                    <input id="username" name="username" class="form-control" placeholder="Username or Email address" required autofocus>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="rememberMe" value="rememberMe"> Remember me
                    </label>
                </div>
                <button class="btn btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <a href="./registration">New Registration &raquo;</a>
        </div>
    </div>
</div>

</body>
</html>
