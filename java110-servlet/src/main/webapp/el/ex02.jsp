<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
    <h1>Expression Language - 보관소에서 값 꺼내기</h1>
    test : 
            http://localhost:8888/el/ex02.jsp
<%
pageContext.setAttribute("name", "page");
request.setAttribute("name", "request");
session.setAttribute("name", "session");
application.setAttribute("name", "application");
%>

PageContext 보관소 : ${pageScope.name}<br>
ServletRequest 보관소 : ${requestScope.name}<br>
HttpSession 보관소 : ${sessionScope.name}<br>
ServletContext 보관소 : ${applicationScope.name}<br>



    
</body>
</html>