<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="/student/studentUpdate" method="post" name="updateStudentForm">
    학번: <input type="text" name="studentId" value="${student.studentId}">
    이름: <input type="text" name="studentName" value="${student.studentName}">
    국어: <input type="text" name="korean" value="${student.korean}">
    영어: <input type="text" name="english" value="${student.english}">
    수학: <input type="text" name="math" value="${student.math}">
    <input type="submit" value="수정">

</form>
</div>
</body>
<script>
    const update = () => {
        const passwordDB = '${member.memberPassword}';
        const password = document.getElementById("memberPassword").value;
        if (passwordDB == password) {
            document.updateStudentForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>