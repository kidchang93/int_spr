<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
          rel="stylesheet">
    <title>로그인</title>
</head>
<body>

<nav class="navbar navbar-expand navbar-dark bg-dark">
    <div class="container">
        <div class="navbar-header">
            <a href="./home" class="navbar-brand">Home</a>
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <h1 class="display-3">로그인</h1>
    </div>
</div>
<div class="container col-md-4">
    <div class="text-center">
        <h3 class="form-signin-heading">Please login</h3>
    </div>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            UserName과 Password가 일치하지 않습니다.<br>
        </div>
    </c:if>
    <form action="<c:url value="/login"/>" method="post" class="form-siginin">
        <div class="form-group row">
            <input type="text" name="username" class="form-control" placeholder="UserName" required autofocus>
        </div>
        <div class="form-group row">
            <input type="password" name="password" class="form-control" placeholder="Password" required>
        </div>
        <div class="form-group row">
            <button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </div>

    </form>

</div>
</body>
</html>
