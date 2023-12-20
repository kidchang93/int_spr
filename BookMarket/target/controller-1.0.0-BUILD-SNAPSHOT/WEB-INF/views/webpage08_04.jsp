<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security</title>
</head>
<body>
<h2>스프링 시큐리티 예</h2>

<sec:authorize access="isAuthenticated()">
    <h5><sec:authentication property="principal.username"/>님, 반갑습니다.</h5>
    <form action="./logout" method="post">
        <button type="submit">Logout</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>
</body>
</html>
