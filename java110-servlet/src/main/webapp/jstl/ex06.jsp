<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
    <h1>JSTL - c:chosse</h1>
    <pre>
        - 다중 조건문을 만든다.
        - java의 switch와 유사.
        http://localhost:8888/jstl/ex06.jsp
    </pre>
    
<c:set var="name" value="JEJE"/>
<c:set var="age" value="22"/>

<c:choose>
    <c:when test="${age < 19 }">
        <p>민짜!</p>
    </c:when>
    <c:when test="${age >= 19 and age < 65}">
        <p>성인!</p>
    </c:when>
    <c:otherwise>
        <p>노인@@</p>
    </c:otherwise>
</c:choose>
</body>
</html>