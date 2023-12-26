<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>스프링 시큐리티 예제</h3>
<ul>
    <li>웹 요청 URL : <a href="<c:url value='/home/main' />">/home/main(비회원)</a></li>
    <li>웹 요청 URL : <a href="<c:url value='/member/main' />">/member/main(회원)</a></li>
    <li>웹 요청 URL : <a href="<c:url value='/employee/main' />">/employee/main(직원)</a></li>
    <li>웹 요청 URL : <a href="<c:url value='/admin/main' />">/admin/main(관리자)</a></li>
</ul>
</body>
</html>
