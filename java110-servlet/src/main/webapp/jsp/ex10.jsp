<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>지시명령문(Directive Element) - taglib</h1>
	<pre>
    - 외부의 JSP확장 태그를 가져올 때 사용한다.
    &lt;%@ taglib prefix="별명" url="JSP확장 태그의 네임스페이스"%>
    - JSP에서 제공하는 전용 태그 외에 개발자가 정의한 태그를 가져와서 사용할 수 있다.
    - 주로 JSTL(JSP Standard Tag Library)를 가져올 때 사용한다.
        - JSTL?
            JSP에서 제공하는 전용 태그의 부족함을 보출하기 위해 만든 확장 태그임.
            JSTL의 명세는 JavaEE 표준 기술이다.
            그러나 서블릿 컨테이너에서 기본으로 제공하지 않는다.
            외부에서 JSTL 명세에 따라 구현된 라이브러리를 사용해야 한다.
        - JSTL 사용법
            - JSTL 명세에 따라 만든 자바 라이브러리(.jar)를 웹에플리케이션에 추가한다.
            JSTL태그를 사용하는 JSP 페이지에서는 taglib지시 명령을 통해
            JSTL 라이브러리를 사용하겠다고 선언한다.
</pre>
<hr>
<ul>
<c:forTokens var="name" items="JEJE,EKEK,MJMJ,PPAP,MAC,APPLE,FUCK" delims=",">
    <li>${name}</li>
</c:forTokens>
</ul>

</body>
</html>
