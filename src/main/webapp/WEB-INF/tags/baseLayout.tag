<%@tag description="Base Layout Tag" pageEncoding="UTF-8"%>
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

    <jsp:doBody/>

    <hr/>

    <footer>
        &copy; Niko K&ouml;bler -
        <a href="https://www.n-k.de" target="_blank">www.n-k.de</a> -
        <a href="https://twitter.com/dasniko" target="_blank">@dasniko</a>
        <a href="https://github.com/dasniko/soteria-demo-mvc" target="_blank" class="pull-right">Project GitHub Repository</a>
    </footer>

</div>

</body>
</html>
