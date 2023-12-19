<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Tag</title>
</head>
<body>

<h3>회원 정보</h3>
<p>아이디 : ${member.id}</p>
<p>비밀번호 : ${member.password}</p>
<p>거주지 : ${member.city}</p>
<p>성 별 : ${member.sex}</p>
<p>취 미 : <c:forEach items="${member.hobby}" var="hobby">
            [<c:out value="${hobby}"/>]
            </c:forEach>

</body>
</html>
