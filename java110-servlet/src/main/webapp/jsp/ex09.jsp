<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>RequestDispatcher의 including vs include 지시 명령 비교.</h1>

	<jsp:include page="ex09_1.jsp"></jsp:include>

	<hr>

	<jsp:include page="ex09_2.jsp"/>
	<!-- 서블릿에서 배웠던 Including Forwarding -->
</body>
</html>
