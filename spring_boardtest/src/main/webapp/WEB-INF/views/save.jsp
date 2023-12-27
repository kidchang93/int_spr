<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SAVE</title>
</head>
<body>
<form action="/board/save" method="post">
    <p>작 성 자 : <input type="text" name="boardWriter" placeholder="작성자"><br><br>
    <p>비밀번호 : <input type="text" name="boardPass" placeholder="비밀번호"><br><br>
    <p>제    목 : <input type="text" name="boardTitle" placeholder="제목"><br><br>
    <p>글 쓰 기 : <br><textarea name="boardContents"
              cols="30" rows="10"
              placeholder="내용을 입력하세요">
    </textarea><br><br>
    <input type="submit" value="작성">

</form>
</body>
</html>
