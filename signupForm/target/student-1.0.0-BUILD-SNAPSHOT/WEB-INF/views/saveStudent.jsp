<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <title>index</title>
</head>
<body>
<form action="/student/saveStudent" method="post">
    <p>학   번 : <input type="text" name="studentId" placeholder="학번" id="studentId" onblur="idCheck()"></p>
    <p id="check-result"></p>
    <p>이   름 : <input type="text" name="studentName" placeholder="이름"></p>
    <p>국   어 : <input type="text" name="korean" placeholder="국어"></p>
    <p>영   어 : <input type="text" name="english" placeholder="영어"></p>
    <p>수   학 : <input type="text" name="math" placeholder="수학"></p>
    <input type="submit" value="학생 등록">
</form>
</body>
<script type="text/javascript">
  /*  // 학번 입력값을 가져오고,
    // 입력값을 서버로 전송하고 똑같은 학번이 있는지 체크한 후
    // 사용 가능 여부를 이메일 입력창 아래에 표시
    // document 관련된건 DOM 명령
    const idCheck = () => {
        const studentId = document.getElementById("studentId").value;
        const checkResult = document.getElementById("check-result");
        console.log("입력한 학번", studentId);
        $.ajax({
            // 요청방식: post, url: "id-check", 데이터: 이메일
            type: "post",
            url: "/member/id-check",
            data: {
                "studentId": studentId
            },
            success: function(res) {
                console.log("요청성공", res);
                if (res == "ok") {
                    console.log("일치하는 학번");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "일치하는 학번입니다.";
                } else {
                    console.log("일치하지 않는 학번");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "일치하지 않는 학번입니다.";
                }
            },
            error: function(err) {
                console.log("에러발생", err);
            }
        });
    }*/
</script>
</html>
