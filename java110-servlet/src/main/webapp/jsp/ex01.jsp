<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>JSP 구동 원리</h1>
    <pre>
    1) 클라이언트가 jsp 실행 요청.
    2) 서블릿 컨테이너
        - JSP 파일에 대응하는 서블릿 클래스를 찾는다.
        - 있다면,
            - 현재 JSP 파일로 만든 서블릿 클래스인지 검사.
            - 서블릿 클래스를 만든 후 JSP가 변경된 적이 없다면,
                - 해당 서블릿을 실행한다.
            - 서블릿 클래스를 만든 후, JSP가 변경된 적이 있다면,
                - 서블릿 클래스가 없는 경우와 동일하게 처리한다.
        - 없다면,
            - JSP파일을 가지고 서블릿 클래스를 만든다.
                - $\{배치폴더}/work/.../XXX.java
            - 컴파일 한 후, 서블릿 컨테이너에 등록한다.
                - $\{배치폴더}/work/.../XXX.class
            - 서블릿 클래스를 실행한다.
    </pre>
    <h1>JSP로 서블릿 클래스를 만들 때 규칙</h1>
    <pre>
    - Javax.servlet.jsp.HttpJspPage인터페이스를 구현해야한다.
    - HttpJspPage 상속 계층도
        Servlet
            |
            |---JspPage
                    |
                    |---HttpJspPage
                            |
                            |---자동 생성된 서블릿 클래스
    </pre>
    <h1>톰켓 서버의 JSP Engine은 Servlet Class를 어떻게 만들까?></h1>
    <pre>
    - 클래스 계층도
        HttpServlet(상속), HttpJspPage(구현)
            |
            |--- org.apache.jasper.runtime.HttpJspBase
                =>  init(Serveletconfig){
                        ...[super.init();]
                        jspInit();
                    }
                =>  destroy(){
                        ...
                        jspDestroy();
                    }
                =>  service(HttpServletRequest, HttpServletResponse){
                        _jspService();
                    }
                |
                |--- 톰켓의 JEP Engine이 JSP파일로 만든 서블릿 클래스
                    => jspInit() {...}
                    => jspDestroy() {...}
                    => _jspService() {...}
    </pre>
    JSP는 서블릿을 자동으로 만들어주는 기술이지
    JSP 자체가 기술은 아니다.
    
</body>
</html>