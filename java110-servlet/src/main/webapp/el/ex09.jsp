<%@page import="bitcamp.java110.Member"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<h1>Expression Language - 연산자</h1>
	<pre>
        test : 
            http://localhost:8888/el/ex09.jsp
    </pre>
	<h2>산술 연산자</h2>
	100 + 200 = ${100 + 200}
	<br> 100 - 200 = ${100 - 200}
	<br> 100 * 200 = ${100 * 200}
	<br> 100 / 200 = ${100 / 200}
	<br> 100 div 200 = ${100 div 200}
	<br> 100 % 5 = ${100 % 5}
	<br> 100 mod 5 = ${100 mod 5}
	<br>
	<!--

-->
	<h2>논리 연산자</h2>
	true && false = ${true && false}
	<br> true and false = ${true and false}
	<br> true || false = ${true || false}
	<br> true or false = ${true or false}
	<br> !true or false = ${!true or false}
	<br> !true = ${!true}
	<br> not true = ${not true}
	<br>

	<h2>관계연산자</h2>
	100 == 200 = ${100 == 200}
	<br> 100 eq 200 = ${100 eq 200}
	<br> 100 != 200 = ${100 != 200}
	<br> 100 ne 200 = ${100 ne 200}
	<br> 100 > 200 = ${100 > 200}
	<br> 100 gt 200 = ${100 gt 200}
	<br> 100 >= 200 = ${100 >= 200}
	<br> 100 ge 200 = ${100 ge 200}
	<br> 100 &lt; 200 = ${100 < 200}
	<br> 100 lt 200 = ${100 lt 200}
	<br> 100 &lt;= 200 = ${100 <= 200}
	<br> 100 le 200 = ${100 le 200}
	<br>


	<h2>empty 연산자</h2>
	<p>보관소에 해당 객체가 없는지 검사한다.</p>
	<%
    pageContext.setAttribute("name1", new String("JEJE"));
    %>
	name1 값이 비었는가? ${empty name1}
	<br> name2 값이 비었는가? ${empty name2}
	<br>
    
    <h2>조건 연산자 - 조건 ? 식1 : 식2 </h2>
    name1 == "JEJE" :  ${name1== "JEJE" ? "Idiot" : "Asshole"}<br>
    
    <%
    String a = "JEJE";
    String b = new String("JEJE");
    
    if(a == b){         //  주소 비교.
        out.println("== : 같다.<br>");
    }   else{
        out.println("== : 다르다.<br>");
    }
    
    if(a.equals(b)){    //  값 비교.
        out.println("equals() : 같다.<br>");
    }   else{
        out.println("equals() : 다르다.<br>");
    }
    
    %>
</body>
</html>