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
    <h1>Expression Element(표현식)</h1>
    <pre>
        - 실행 결과를 출력할 때 사용한다.
            &lt;%= 표현식 %> 
        - java code :
            표현식 안에 작성한 코드가 출력문의 파라미터로 복사된다.
            out.print(표현식)
        - 표현식(express)?
            어떤 결과를 리턴하는 코드이다.
    </pre>
    <p>100 + 200  = <% out.print(100 + 200); %></p>
    <p>100 + 200  = <%= 100 + 200 %></p>
    <% //_jspService() "메서드 안에" 자바 코드를 작성한다는 것!! 절대 잊지마! %>
</body>
</html>
<!--
JSP 공부하는 tip :
    war 파일을 tomcat 서버로 돌릴 경우 :
apache-tomcat-9.0.12/work/Catalina/localhost/manager/org/apache/jsp/WEB_002dINF/jsp
    eclipse로 tomcat 서버 돌릴 경우 : 
org.eclipse.wst.server.core/tmp0/work/Catalina/localhost/ROOT/org/apache/jsp/jsp
    dir에서 컴파인 된 class 파일이나 java파일을 확인한다.
-->