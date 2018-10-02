<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%  //  스크립트 릿 : 자바 코드를 두는 태그
int a;
%>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%
a=100;
int b = a++;
%>
    <h1>스크립트릿(scriptlet)</h1>
    <pre>
    - JSP 파일안에 작성하는 java코드.
    - java 코드 :
      스크립트릿 태그 안에 작성한 코드는 그대로 _jspService() 안에 그대로 복사된다.
    </pre>
<%
out.println("<p>a = " + a + "</p>");
out.println("<p>b = " + b + "</p>");
//  printf 불가능.
%>
</body>
</html>