<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RandomTitleHere</title>
</head>
<body>
    <h1>Test26 - 7 Page</h1>
<pre>
    이름:${sessionScope.name}
    나이:${sessionScope.age}
    강사여부:${sessionScope.teacher}
    과목:<c:forEach items="${sessionScope.language}" var="lang">${lang},</c:forEach>
    성별:${sessionScope.gender} 
</pre>
<a href="m8"> 세션 무효화 시키</a>

</body>
</html>