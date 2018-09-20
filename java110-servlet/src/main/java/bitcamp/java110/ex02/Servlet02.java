package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  서블릿 만들기  II
  .
  서블릿 인터페이스의 메소드 5가지 말해보세요.
  
  GenericServlet abstract class Service만 구현 하면 됨.
*/
@WebServlet("/ex02/servlet02")
public class Servlet02 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //  예) 게시물 목록 조회, 로그인 처리, 회원 가입 처리하는 등의 일을 함.
        System.out.println("Servlet02의 Service() 호출됨.");
        
    }
}


