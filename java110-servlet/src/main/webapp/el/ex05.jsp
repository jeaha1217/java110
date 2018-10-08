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
    <h1>Expression Language - 배열에서 값 꺼내기 </h1>
    <pre>
        - EL에서 문자열이나 숫자를 표현하는 방법.
        test : 
            http://localhost:8888/el/ex05.jsp
    </pre>
<%
pageContext.setAttribute("names", new String[]{"JEJE", "MJ", "PPPP", "EKEK"});
%>
${names[0]}<br>
${names[1]}<br>
${names[2]}<br>
${names[3]}<br>
${names[4]}<br>
<!-- outOfBoundException 안뜸 -->
    
</body>
</html>