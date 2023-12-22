<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>학점관리</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    table{
        border: 1px solid black;
        width: 50%;
    }
    tr{
        border: 1px solid black;
    }
    th{
        border: 1px solid black;
    }
    td{
        border: 1px solid black;
    }
</style>
<body>
<h1>학점 관리</h1>


<table>
    <tr>
        <th>학번</th>
        <th>이름</th>
    </tr>
    <c:forEach items="${studentList}" var="student">
        <tr>
            <td>
                <a href="/student?studentId=${student.studentId}">${student.studentId}</a>
            </td>
            <td>${student.studentName}</td>
        </tr>
    </c:forEach>
</table>

<a href="/member/login">로그인</a><br>
<a href="/student/saveStudent">학생 등록</a><br>
<a href="/student/" type="hidden">점수 정정</a>
</body>
<script>
    const deleteMember = (id) => {
    console.log(id);
    // alert 필요 " 정말로 삭제할거임? " 이란 문구로 확인시 where 취소시 where 짜줘야함.
    location.href = "/member/delete?id="+id;
    }
</script>
</html>
