<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:baseLayout>
    <c:if test="${errors != null}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach var="error" items="${errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
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
</t:baseLayout>
