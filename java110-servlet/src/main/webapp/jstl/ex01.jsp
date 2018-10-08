<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
    <h1>JSTL 개요</h1>
    <pre>
        - JSTL (JSP Standard Tag Library)?
            - JSP의 확장 태그이다.
            - 기본으로 지원하지 않는다.
            - JSTL API를 구현한 외부 라이브러리를 가져와서 사용해야함.
        - JSTL 라이브러리 가져오기.
            - mvnrepository.com에서 JSTL 검색하여 라이브러리 정보를 알아낸다.
            - build.gradle 파일의 dependencies{} 블록에 추가한다.
            - 'gradle eclipse' 실행하여 이클립스 설정파일을 갱신한다.
            - 이클립스 프로젝트 리프레쉬
        - JSTL 라이브러리 모듈
            - Core(c) : http://java.sun.jsp/jstl/core 
            - XML(x) : http://java.sun.jsp/jstl/xml
            - I18N(fmt) : http://java.sun.jsp/jstl/core
                Internationalization  i18n
                    국제화 : 라벨명을 다른 언어로 표현할 수 있도록 프로그래밍 한것.
                Localization    l10n
            - Database(sql) : http://java.sun.jsp/jstl/sql
            - Functions(fn) : http://java.sun.jsp/jstl/functions
         - JSP 페이지네 JSTL 라이브러리 모듈 사용하기
            JSTL 모듈의 네임스페이스를 가져온다.
                &lt;%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            - JSTL 태그 사용
                &lt;접두어면: 태그명 속성="값" 속성="값"/>
        test : 
            http://localhost:8888/jstl/ex01.jsp
    </pre>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:out value="<h2>오호라!!</h2>"/>
</body>
</html>