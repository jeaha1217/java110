package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex02/servlet02")
public class Servlet02 extends GenericServlet {
    /*  Servlet 만들기 II
    - javax.servlet.GenericServlet 인터페이스 구현.
     */
    private static final long serialVersionUID = 1L;
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Servlet02.Service() 호출됨.");
        
    }
}