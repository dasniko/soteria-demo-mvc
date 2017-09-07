<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:baseLayout>
    <h1>Hello ${account.username}!</h1>
    <p>Email: ${account.email}</p>
    Roles:
    <ul>
        <c:forEach var="role" items="${account.roles}">
            <li>${role}</li>
        </c:forEach>
    </ul>
    <p><a href="./user/logout" class="btn btn-primary">Logout &raquo;</a></p>
</t:baseLayout>
