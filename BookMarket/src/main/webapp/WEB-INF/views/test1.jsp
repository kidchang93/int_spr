<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix='form' uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="dataBean" action='result'>

    <%--셀렉트--%>
    <hr>
    <h2>셀렉트</h2>
    <form:select path="a1">
        <form:options items="${requestScope.data_list1}"/><br>
    </form:select>
    <hr>

    <h2>체크박스</h2>
    <%--체크박스--%>
    <form:checkboxes items="${requestScope.data_list1}" path="a5"/><br>
    <hr>

    <%--라디오버튼--%>
    <h2>라디오버튼</h2>
    <form:radiobuttons path="a2" items="${requestScope.data_list2}"/><br>
    <hr>
</form:form>
</body>
</html>