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
        li {
            color: red;
        }
    </style>
</head>
<body>

    <%--서버가 보낸 memberList 그리기--%>
    <ul>

        <h1>프론트컨트롤러V4 목록보기</h1>

        <c:forEach var="m" items="${memberList}">
            <li>
                # 아이디: ${m.account},
                <a href="/chap02/v4/detail?account=${m.account}">
                    이름: ${m.userName}
                </a>
                &nbsp;&nbsp;&nbsp;
                <a id="rm-btn" href="/chap02/v4/delete?account=${m.account}">[delete]</a>

            </li>
        </c:forEach>

    </ul>

    <a href="/chap02/v4/join">새로운 회원가입하기</a>

</body>
</html>