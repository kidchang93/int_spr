<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>학생등록</title>
</head>
<body>

<Form method="post" action="/student/save">
    <p>학번 : <input type="text" name="studentId" placeholder="학번을 입력하세요" autofocus required></p>
    <p>이름 : <input type="text" name="studentName" placeholder="이름을 입력하세요"  required></p>
    <p>성별 : <label for="male"><input type="radio" name="gender" id="male" value="남자">남자</label>
        <label for="female"><input type="radio" name="gender" id="female" value="여자">여자</label>
    <p>국어 : <input type="number" min="0" max="100" name="korean" placeholder="국어점수를 입력하세요" required ></p>
    <p>영어 : <input type="number" min="0" max="100" name="english" placeholder="영어점수를 입력하세요" required ></p>
    <p>수학 : <input type="number" min="0" max="100" name="math" placeholder="수학점수를 입력하세요" required ></p>
    <input type="submit" value="입력"><button type="button" value="초기화" onclick="">초기화</button>
</Form>
</body>
</html>
