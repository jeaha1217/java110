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
    <h1>Expression Language - 보관소에서 값 꺼내기 II</h1>
    <pre>
        - 보관소의 이름을 지정하지 않으면 다음 순서로 값을 찾는다.
            pageScope => requestScope => sessionScope => applicationScope
            
        - 보관소에 저장된 값을 찾지 못하면 빈 문자열을 리턴한다.
        - test : 
            http://localhost:8888/el/ex03.jsp
    </pre>
<%
//session.invalidate();
//session = request.getSession();
session.setAttribute("name", null);
application.setAttribute("name", null);


//pageContext.setAttribute("name", "page"); //  한번 불러올때만 저장한다.
//request.setAttribute("name", "request");  //  한번 불러올때만 저장한다.
//session.setAttribute("name", "session");  //  한번 저장되면 계속 저장 하고 있는다.
//application.setAttribute("name", "application");  //  한번 저장되면 계속 저장 하고 있는다.
%>

<h2>보관소에서 값 꺼내기 : ${name}</h2>



    
</body>
</html>