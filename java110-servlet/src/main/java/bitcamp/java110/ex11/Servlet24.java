//  세션 - 세션을 강제로 무효화 시키기.
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet24")
public class Servlet24 extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //  http://localhost:8888/ex11/servlet24
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        //  현제 세션을 강제로 무효화 시킨다.
        session.invalidate();
        
        /*  test
            1) 세션 생성 - servlet21
            2) 새션 조회 - servlet22
            3) 세션 무효화 - servlet24
            4) 세션 재조회 - servlet22
        */
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> ! SESSION ! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Session 강제 무효화 시키기.</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
