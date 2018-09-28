/*  포워드(forword)
     
 */

package bitcamp.java110.ex09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09/servlet02")
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex09/servlet02
        
           ServletRequest 보관소에 저장된 값을 꺼낸다.
           => forward, include 서블릿 끼리는
              ServletRequest 보관소를 통해 값을 공유할 수 있다. 
        */
        String op = (String)req.getAttribute("op");
        int a = (int)req.getAttribute("a");
        int b = (int)req.getAttribute("b");
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        /*  방법2)
            => HTML의 <meta> tag에 refresh명령을 설정할 수 있다.
         */
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - ex09 - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>빼기 계산 결과</h1>");
        if(!op.equals("-")) {
            // 연산자가 -가 아니라면 servlet03에게 작업을 위임한다.
            RequestDispatcher 요청배달자 = req.getRequestDispatcher("servlet03");
            요청배달자.forward(req, res);
            return;
        }
        out.printf("<p>%d - %d = %d</p>\n", a, b, (a - b));
        out.println("</body>");
        out.println("</html>");

    }
}

/*

 */