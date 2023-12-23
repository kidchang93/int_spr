<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    table{
        border: 1px solid black;
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
<table>
    <tr>
        <th>id</th>
        <th>email</th>
        <th>password</th>
        <th>name</th>
        <th>age</th>
        <th>mobile</th>
        <th>조회</th>
        <th>삭제</th>
    </tr>
    <c:forEach items="${memberList}" var="member">
        <tr>
            <td>${member.id}</td>
            <td>

                <a href="/member?id=${member.id}">${member.memberEmail}</a>
            </td>
            <td>${member.memberPassword}</td>
            <td>${member.memberName}</td>
            <td>${member.memberAge}</td>
            <td>${member.memberMobile}</td>
            <td>
                <a href="/member?id=${member.id}">조회</a>
            </td>
            <td>
                <button onclick="deleteAlert('${member.id}')">삭제</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    function deleteAlert() {
        alert("정말로 삭제하시겠습니까?");
        window.location.href = "/"
    }

    const deleteMember = (id) => {
        console.log(id);
        // alert 필요 " 정말로 삭제할거임? " 이란 문구로 확인시 where 취소시 where 짜줘야함.
        location.href = "/member/delete?id="+id;
    }
</script>
</html>
