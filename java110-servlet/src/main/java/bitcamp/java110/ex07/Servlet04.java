/*  HttpSession 보관소의 데이터 꺼내기.
    
 */

package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex07/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        
        //  http://localhost:8888/ex07/servlet04
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex07/servlet04 실행.");
        
        //  ServletContext 보관소에 저장된 값 꺼내기.
        //  => 먼저 ServletContext 객체를 알아낸다.
        ServletContext sc = this.getServletContext();
        out.printf("\nServletContext : aaa=%s", sc.getAttribute("aaa"));
        
        //  Servlet01에서 ServletRequest 보관소에 저장한 값을 꺼낼수 있는가?
        // XX
        out.printf("\nServletRequest : bbb=%s", req.getAttribute("bbb"));
        
        //  HttpSession의 값 꺼내기.
        HttpSession session = req.getSession();
        out.printf("\nHttpSession : ccc=%s", session.getAttribute("ccc"));

    }
}

/*
    
*/