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
    <div class="col-md-12">
        <h1 class="alert alert-success">Thank you ${account.username}, for your registration!</h1>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <a href="./user" class="btn btn-primary btn-block">Continue &raquo;</a>
        </div>
    </div>
</div>

</body>
</html>
