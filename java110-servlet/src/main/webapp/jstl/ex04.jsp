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
    <h1>JSTL - c:remove</h1>
    <pre>
        - 보관소에 저장된 값을 제거한다.
        http://localhost:8888/jstl/ex04.jsp
    </pre>
<%
pageContext.setAttribute("name", "JEJE");
request.setAttribute("name", "MJMJ");
session.setAttribute("name", "PPPP");
application.setAttribute("name", "EKEK");
%>

1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>
<hr>
<c:remove var="name" scope="page"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>
<hr>
<c:remove var="name" scope="request"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>
<hr>
<c:remove var="name" scope="session"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>
<hr>
<c:remove var="name" scope="application"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>


</body>
</html>