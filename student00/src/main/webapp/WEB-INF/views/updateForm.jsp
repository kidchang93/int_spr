<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>학생등록</title>
</head>
<body>

<Form method="post" action="/student/update">
    <p>학번 : <input type="text" name="studentId" placeholder="학번을 입력하세요" value="${student.studentId}" readonly></p>
    <p>이름 : <input type="text" name="studentName" placeholder="이름을 입력하세요" value="${student.studentName}" readonly></p>
    <p>성별 : <label for="male"><input type="radio" name="gender" id="male" value="남자">남자</label>
        <label for="female"><input type="radio" name="gender" id="female" value="여자">여자</label>
    <p>국어 : <input type="number" min="0" max="100" name="korean" placeholder="국어점수를 입력하세요" value="${student.korean}" autofocus></p>
    <p>영어 : <input type="number" min="0" max="100" name="english" placeholder="영어점수를 입력하세요" value="${student.english}" ></p>
    <p>수학 : <input type="number" min="0" max="100" name="math" placeholder="수학점수를 입력하세요" value="${student.math}" ></p>
    <input type="submit" value="수정하기"><button type="button" value="삭제" onclick="deleteMember(${student.studentId})">삭제</button>
</Form>
</body>
<script>
    const deleteMember = (studentId) => {
        console.log(studentId);
        // alert 필요 " 정말로 삭제할거임? " 이란 문구로 확인시 where 취소시 where 짜줘야함.
        location.href = "/student/delete?studentId=" + studentId;
    }
</script>
</html>
