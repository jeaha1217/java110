package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
  서블릿 만들기  III
      javax.servlet.http.httpservlet상속받기.
  GenericServlet abstract class Service만 구현 하면 됨.
*/
@WebServlet("/ex02/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet03의 doGet 호출됨..");
        super.doGet(req, resp);
    }
}