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

    <h1>[${name}] 취미 목록</h1>
    <ol>
        <%-- for (String h : hList) --%>
        <c:forEach var="h" items="${hobbies}">
            <%-- 주석주석 --%>
            <li>${h}</li>
        </c:forEach>
    </ol>

    <h2>나의 전공: ${major}</h2>

</body>
</html>