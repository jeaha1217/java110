#[java110-servlet]

## ex01
- 서블릿이란
    - ex01/Servlet01.java
- 리스너
    - ex01/Listener01.java, ex01/Listener02.java
- 필터
    - ex01/Filter01.java, ex01/Filter02.java
## ex02
- 서블릿
    - ex02/Servlet01.java, ex02/Servlet02.java, ex02/Servlet03.java

## ex03
- 클라이언트로 출력하기
    -ex03/Servlet01.java, ex03/
- 클라이언트로 출력하기
    - 한글 깨짐 현상 해결, MIME 타입
    - ex03/Servlet02.java
    - ex03/Servlet03.java
- 이미지 출력
		ex03/Servlet04.java

## ex04
- GET 요청
		ex04/Servlet01.java, ex04/get.html
- POST 요청
		ex04/Servlet02.java, ex04/post.html
- 멀티파트 데이터 읽기(파일업로드)
		ex04/Servlet03.java, ex04/file.html
		ex04/Servlet04.java, ex04/file2.html
- POST 요청 한글깨짐 해결
		ex04/Servlet05.java, ex04/post2.html
- URL 인코딩
		ex04/Servlet06.java

## ex05
- GET/POST 구분하기
		ex05/Servlet01.java, ex05/test1.html
- MyHttpServlet
		ex05/MyHttpServlet.java, ex05/Servlet02.java, ex05/test2.html
- MyHttpServlet2 - doGet, doPost 구분하여 처리하기
		ex05/MyHttpServlet2.java, ex05/Servlet03.java, ex05/test3.html
- HttpServlet
		ex05/Servlet04.java, ex05/test4.html
		

## ex06
- 서블릿 배치 정보 - loadOnStartUp 속성
		ex06/Servlet01.java
- 서블릿 배치 정보 - 초기 파라미터(@WebInitParam)
		ex06/Servlet02.java
		ex06/Servlet03.java, web.xml
		ex06/Servlet04.java, web.xml
		ex06/Servlet05.java, web.xml


## ex07	리스너(listener)
		ex07/Listener01.java, web.xml
- ServletContext 보관소
		ex07/Servlet01.java, ex07/Servlet02.java
- HttpSession 보관소
		ex07/Servlet03.java, ex07/Servlet04.java

## ex08
- 리프래시(refresh)
		ex08/Servlet01.java
- 리다이렉트(redirect)
		ex08/Servlet02.java
## ex09
- 포워드(forward) 이용 계산기 만들기
		ex09/Servlet01.java, ex09/Servlet02.java, ex09/Servlet03.java
- 인클루드(include)
		ex09/Servlet04.java, ex09/Servlet05.java, ex09/Servlet06.java

## ex10
- 쿠키(cookie) 보내기
		ex10/Servlet01_1.java, ex10/Servlet01_2.java, ex10/Servlet01_3.java
- 쿠키(cookie) 받기
		ex10/Servlet02.java, ex10/Servlet03.java, ex10/Servlet04.java

## ex11
- hidden 타입 input 필드 사용
		ex11/Servlet01.java, ex11/Servlet02.java, ex11/Servlet03.java, ex11/Servlet04.java
- 세션(HttpSession)
		ex11/Servlet11.java, ex11/Servlet12.java, ex11/Servlet13.java, ex11/Servlet14.java
- 쿠키의 원리: 세션ID와 쿠키, 세션 timeout, invalidate()
		ex11/Servlet21.java, ex11/Servlet22.java, ex11/Servlet23.java, ex11/Servlet24.java
## ex12
- 로그인폼 출력하기
		ex12/Servlet01.java
	
## ex13
- Inventory, ThreadLocal
		ex13/Inventory.java, ex13/Inventory2.java, ex13/Listener01.java
		ex13/Servlet01.java, ex13/Servlet02.java

##JSP
- JSP 구동원리
		jsp/ex01.jsp, jsp/ex02.jsp
- 스크립트릿 (<%  %>)
		jsp/ex03.jsp, jsp/ex04.jsp
	
    - 표현식 (<%= %>)
		jsp/ex05.jsp
	
    - 선언부 (<%! %>)
		jsp/ex06.jsp
	
    - 지시부 (<%@ %>)
		jsp/ex07.jsp
- 지시부 include
		jsp/08.jsp, jsp/08_1.txt, jsp/08_2.txt
- <jsp:include>
		jsp/ex09.jsp, jsp/ex09_1.jsp, jsp/ex09_2.jsp
- 지시부 - taglib
		jsp/ex10.jsp
	
    - - 빌트인 객체
		jsp/ex11.jsp
	
    - JSP 액션태그 <jsp:useBean>
		jsp/ex12_1.jsp, jsp/ex12_2.jsp, jsp/ex12_3.jsp, jsp/ex14_4.jsp
		jsp/ex12_5.jsp, jsp/ex12_6.jsp
	
    - JSP 액션태그 <jsp:setProperty>
		jsp/ex13.jsp
	
    - JSP 액션태그 <jsp:include>
		jsp/ex14.jsp, jsp/ex14_header.jsp, jsp/ex14_footer.jsp
	
    - JSP 액션태그 <jsp:forward>
		jsp/ex15.jsp, jsp/ex15_error.jsp

## EL
- Expression Langueage

		el/ex01.jsp, el/ex02.jsp, el/ex03.jsp
	EL - 보관소에서 값꺼내기
		el/ex04.jsp, el/ex05.jsp, el/ex06.jsp,
		el/ex07.jsp, el/ex08.jsp
	EL - 연산자
		el/09.jsp

## JSTL
- JSTL
		jstl/ex01.jsp
- JSTL - <c:out>
		jstl/ex02.jsp
- JSTL - <c:set>
		jstl/ex03.jsp
- JSTL - <c:remove>
		jstl/ex04.jsp
- JSTL - <c:if>
		jstl/ex05.jsp
- JSTL - <c:choose>
		jstl/ex06.jsp
- JSTL - <c:forEach>
		jstl/ex07.jsp
- JSTL - <c:forTokens>
		jstl/ex08.jsp
- JSTL - <c:url>
		jstl/ex09.jsp
- JSTL - <c:import>
		jstl/ex10.jsp
- JSTL - <c:redirect>
		jstl/ex11.jsp
- JSTL - <fmt:parseDate>
		jstl/ex12.jsp
- JSTL - <fmt:formatDate>
		jstl/ex13.jsp


