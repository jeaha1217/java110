<%@page import="bitcamp.java110.Member"%>
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
    <h1>Expression Language - 일반 객체에서 값 꺼내기 </h1>
    <pre>
        test : 
            http://localhost:8888/el/ex08.jsp
    </pre>
<%
Member member = new Member();
member.setNo(999);
member.setName("JEJE");
member.setEmail("JEJE'sEmail");
member.setTel("01010203430");

pageContext.setAttribute("member", member);
%>
${member["no"]}<br>
${member['name']}<br>
${member.email}<br>
${member.getTel()}<br>
<!--
member.email 주로씀.
-->
</body>
</html>