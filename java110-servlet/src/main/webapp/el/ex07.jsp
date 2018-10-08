<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
    <h1>Expression Language - Map 객체에서 값 꺼내기 </h1>
    <pre>
        test : 
            http://localhost:8888/el/ex07.jsp
    </pre>
<%
HashMap<String, Object> map = new HashMap<>();
map.put("s01", "김구");
map.put("s02","안중근");
map.put("s03","윤봉길");
map.put("s04","이봉창");

pageContext.setAttribute("map", map);
%>
${map["s01"]}<br>
${map['s02']}<br>
${map.s03}<br>
</body>
</html>