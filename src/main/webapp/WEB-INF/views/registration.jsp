<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="_header.jspf"%>

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

<%@include file="_footer.jspf"%>
