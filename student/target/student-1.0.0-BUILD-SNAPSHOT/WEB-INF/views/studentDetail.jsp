<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>detail</title>
</head>
<body>
<table>
    <tr>
        <th>학번</th>
        <td>${student.studentId}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${student.studentName}</td>
    </tr>
    <tr>
        <th>국어</th>
        <td>${student.korean}</td>
    </tr>
    <tr>
        <th>영어</th>
        <td>${student.english}</td>
    </tr>
    <tr>
        <th>수학</th>
        <td>${student.math}</td>
    </tr>
</table>
<hr>
<a href="/student/studentUpdate?studentId=${student.studentId}">수정하기</a>
<br>
<a href="/student/deleteStudent?studentId=${student.studentId}">삭제하기</a>
<br>
<a href="/student/studentList">목록으로 돌아가기</a>
</body>
</html>