<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h1>JSTL - c:if</h1>
	<pre>
        - 조건문을 만든다.
        http://localhost:8888/jstl/ex05.jsp
    </pre>
	<c:set var="name" value="JEJE" />
	<c:set var="age" value="22" />
	<c:set var="gender" value="male" />


	<c:if test="${not empty name }">
		<p>${name}등장!</p>
	</c:if>

	<c:if test="${age < 19}">
		<p>민짜!</p>
	</c:if>
	<c:if test="${age >= 19}">
		<p>성인!</p>
	</c:if>

	<h2>조건문의 결과를 보관소에 저장하기</h2>
	<pre>var 속성으로 변수 이름을 설정하면, 조건문의 테스트 결과는 지정된 이름으로 보관소에 저장된다.</pre>
	<c:if test="${gender == 'female'}" var="r1" />

	${pageScope.r1 ? "female" : "Male" }

</body>
</html>