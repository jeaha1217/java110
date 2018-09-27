/*  HTTPSession 보관소 생성 및 데이터 값 저장.
    => 
 */

package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex07/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        //  http://localhost:8888/ex07/servlet01
        
        // HttpSession 보관소 준비하기.
        //  => 각 클라이언트마다 별도의 HttpSession 객체가 생성된다.
        //  
        //  각각 개별적으로 저장해야하는 정보는 httpSession에 저장해야 한다는것!
        //  보안상의 이유로 ㅇㅇ, 임시적인것 이지만 데이터는 서버쪽에서 갖고 있는것 임.
        HttpSession session = req.getSession();
        
        //  HttpSession보관소에 값 저장하기.
        session.setAttribute("ccc", req.getParameter("name"));
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex07/servlet03 실행.");
        out.println("HttpSession에 값 보관.");
    }
}

/*
    
*/