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

    <style>
        label {
            display: block;
        }
    </style>
</head>
<body>

    <h1>프론트컨트롤러V2 회원가입 양식</h1>

    <form action="/chap02/v2/save" method="post">
        <label>
            # 계정명: <input type="text" name="account">
        </label>
        <label>
            # 비밀번호: <input type="password" name="password">
        </label>
        <label>
            # 이름: <input type="text" name="userName">
        </label>
        <label>
            <button type="submit">회원가입</button>
        </label>
    </form>

</body>
</html>