<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>Custom Login Page</h1>
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2>

<form method='post' action="/login">

    <div>
        <input type='text' name='username' value=''>
    </div>
    <div>
        <input type='password' name='password' value=''>
    </div>
    <div>
        <input type='checkbox' name='remember-me'> Remember Me
    </div>
    <div>
        <input type='submit'>
    </div>
    <%--토큰이 난수 형태로 나오게됨 ( 페이지 소스로만 볼 수있음 ) 그치만 security context 에서 disalbed 하면 안쓰게됨.--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

</form>

</body>
</html>
