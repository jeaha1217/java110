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
    <h1>JSTL - c:out</h1>
    <pre>
        - 출력문을 만드는 태그
        &lt;c:out value="출력될 값" default="기본값"/>
        &lt;c:out value="출력될 값">기본값&lt;c:out>
        
        http://localhost:8888/jstl/ex02.jsp
    </pre>

<c:out value="EKEK"/><br>
<c:out value="${null}" default="PPPP"/><br>
<c:out value="${null}">JEJE</c:out><br>
<c:out value="${'MJMJ'}" default='JEJE'/><br>

</body>
</html>