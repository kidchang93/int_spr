<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security</title>
</head>
<body>
<h3>접근 권한과 사용자 권한 설정 예</h3>
<p>뷰 페이지는 ${data} 입니다.</p>
<p><a href="<c:url value='/exam01'/>">[웹 요청 URL /exam01로 이동하기]</a></p>
</body>
</html>
