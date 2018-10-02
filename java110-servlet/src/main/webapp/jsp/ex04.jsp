<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
    <h1>스크립트릿(scriptlet) 응용</h1>
<%  //  _jspService()메서드 안에 자바 코드를 작성한다는 것을 절대 잊지 말자.
/*...*/
//  <!-- 엥? -->
    String[] names = {"JEJE", "EKEK", "MJMJ", "PP"};
%>
<ul>
<%for (String name : names) { %>
    <li><%out.print(name);%></li>
<%} %>
</ul>
</body>
</html>
<!-- JSP 공부하는 방법 컴파인 된 class 파일이나 java파일을 확인한다. -->