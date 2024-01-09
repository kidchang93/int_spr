<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>유효성 검사</title>
</head>
<body>

<h3>유효성 검사</h3>
<form:form modelAttribute="person" method="post">
    <p>이름 : <form:input path="name"/> <form:errors path="name"/></p>
    <p>나이 : <form:input path="age"/> <form:errors path="age"/></p>
    <p>이메일 : <form:input path="email"/> <form:errors path="email"/></p>
    <p><input type="submit" value="확인"></p>
    <input type="reset" value="취소">
</form:form>

</body>
</html>
