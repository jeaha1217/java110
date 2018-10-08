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
    <h1>JSTL - c:redirect</h1>
    <pre>
        - redirect 응답하기
        http://localhost:8888/jstl/ex11.jsp
        http://localhost:8888/jstl/ex11.jsp?serch=
    </pre>

<c:if test="${param.serch == 'naver'}">
    <c:redirect url="http://www.naver.com"/>
</c:if>
<c:if test="${param.serch == 'daum'}">
    <c:redirect url="http://www.daum.net"/>
</c:if>
<c:if test="${empty param.serch}">
    <c:redirect url="http://www.google.com"/>
</c:if>

<p>search라는 이름으로 검색 엔진을 지정!<br>
유효한 엔진은 'naver', 'daum'</p>
</body>
</html>