/* 서블릿 만들기 I
 * - javax.servlet.Servlet 인터페이스 구현
 */
package bitcamp.java110.ex02;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex02/servlet01")
public class Servlet01 implements Servlet {
    /*  Servlet 만들기 I
        - javax.servlet.Servlet 인터페이스 구현.
    */
    ServletConfig config;
    
    public Servlet01() {
        System.out.println("Servlet01() 호출됨.");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet01.init() 호출됨."); 
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("servlet01.service() 호출됨.");
    }

    @Override
    public String getServletInfo() {
        return "Servlet01";
    }

    @Override
    public void destroy() {
        System.out.println("servlet01.destroy() 호출됨.");
    }
}
/*
    "서블릿 인터페이스의 메소드 5가지 말해보세요."
    등의 질문을 받을수 있으니 잘 알아둬라.
*/