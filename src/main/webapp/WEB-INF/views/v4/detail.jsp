<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

    <h1>회원 상세 조회</h1>

    <ul>
        <li># 계정명: ${mem.account}</li>
        <li># 비밀번호: ${mem.password}</li>
        <li># 이름: ${mem.userName}</li>
    </ul>

    <a href="/chap02/v4/show">목록으로 돌아가기</a>

</body>
</html>