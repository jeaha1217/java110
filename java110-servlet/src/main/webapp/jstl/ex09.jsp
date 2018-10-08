<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
    <h1>JSTL - c:url</h1>
    <pre>
        - 복잡한 형식의 URL을 만들 수 있다.
        http://localhost:8888/jstl/ex09.jsp
    </pre>

<h2>NAVER 검색 URL 만들기</h2>
<pre>
    https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%ED%99%8D%EA%B8%B8%EB%8F%99
</pre>
<c:url value="https://search.naver.com/search.naver" var="naverUrl">
    <c:param name="where" value="nexearch"/>
    <c:param name="sm" value="tab_hty"/>
    <c:param name="fbm" value="1"/>
    <c:param name="ie" value="utf8"/>
    <c:param name="query" value="홍길동"/>
</c:url>
<p>${naverUrl}</p>

</body>
</html>