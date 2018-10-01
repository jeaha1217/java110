/*  쿠키(cookies) - 같은 경로의 서블릿이 쿠키를 받는 예.
    => 
 */

package bitcamp.java110.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/a/b/servlet03")
public class Servlet03 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex10/a/b/servlet03
            1) http 요청 프로토콜에서 쿠키 목록 가져오기.
                쿠키가 없다면 null을 리턴함.
         */
        Cookie[] cookies = req.getCookies();
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - ex10 - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠키 받기 2 </h1>");

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                out.printf("<p>%s=%s</p>\n",
                        cookie.getName(),
                        cookie.getValue());
            }
        }
/*
RequestHeader
Cookie: name=Looser; age=12; working=true
*/
        out.println("</body>");
        out.println("</html>");
    }
}