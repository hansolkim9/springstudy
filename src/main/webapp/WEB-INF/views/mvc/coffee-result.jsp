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

    <h1>주문 내역입니다.</h1>

    <ul>
        <li># 주문하신 메뉴: ${mmm}</li>
        <li># 지불하실 가격: ${ppp}원</li>
    </ul>

    <a href="/coffee/order">재주문하기</a>


</body>
</html>