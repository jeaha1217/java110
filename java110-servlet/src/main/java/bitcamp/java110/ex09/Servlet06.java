/*  인클루드 (include)
    => 다른 서블릿의 작업을 포함하는 기술.
        일종의 함수 호출하
 */

package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet06")
public class Servlet06 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex09/servlet04
            이전 서블릿에서 호출한 setContextType이 그대로 적용되기대문에  
            인클루드 서블릿에서는 setContextType을 할 필요가 없고 해봐야 소용 ㅇ없음.
         */
//        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<h1> !! Servlet 06 !! </h1>");
    }
}