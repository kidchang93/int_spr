<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-01-04
  Time: 오후 5:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>
<h1>학점 관리</h1>
<table border="1">
  <tr>
    <th>학번</th>
    <th>이름</th>
  </tr>
  <c:forEach items="${studentList}" var="student">
  <tr>
    <td>${student.studentId}</td>
    <td>${student.studentName}</td>
  </tr>
  </c:forEach>
</table>
<br>
<a href="/student/login">로그인</a>
<a href="/student/save">학생등록</a>
<a href="/student/#">점수정정</a>
</body>
</html>
