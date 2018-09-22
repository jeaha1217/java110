package bitcamp.java110.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  클라이언트로 출력하기
*/
@WebServlet("/ex03/servlet01")
public class Servlet01 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        
        System.out.println("/ex03/servlet01.Service() 호출됨.");
        out.println("Halo");
        out.println("아...");
        out.println("Hola");
        out.println("Dobrý den");
        out.println("你好");
        out.println("こんにちは");
        
        /*  문제점.
              - 영어를 제외한 다른 언어의 문자는 ?로 출력된다.
              왜?
              - getWriter가 리턴한 출력 스트림은 기본적으로
                  자바 유니코드를 ISO-8859-1 문자 표에 따라 출력하기 때문.
              - 따라서 ISO-8859-1에 정의 되지 않은 유니코드는 '?'로 대치되어 출력됨.
                  서버에서 '?'를 보낸것임...
         */
    }
}