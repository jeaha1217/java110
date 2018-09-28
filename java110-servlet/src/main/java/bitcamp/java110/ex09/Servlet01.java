/*  포워드(forword)
    => 다른 서블릿으로 작업을 위임하는 기술
        이전 서블릿에서 출력한 내용이 있다면 포워드 전에 버린다.
        그래서 작업을 위임받은 서블릿에서 새로 출력한다.
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

@WebServlet("/ex09/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex09/servlet01

         */

        String op = req.getParameter("op");
        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

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
        out.println("<h1>계산 결과</h1>");
        if(!op.equals("+")) {
            /* - 연산을 수행하는 서블릿으로 작업을 위임하기.
              주의!
              현재까지 출력한 내용은 버려야함.
              어떻게? 웹 브라우져로 출력한 것을 취소함?
                  아직 클라이언트로 출력하지 않았기 때문에 가능함.
                  out.print()과 같은 출력문을 호출하면
                  즉시 클라이언트로 출력하는것이 아니라 버퍼로 출력하기 때문에.
             */
            //  포워딩을 수행할 작업자를 준비한다.
            RequestDispatcher 요청배달자 = req.getRequestDispatcher("servlet02");
            
            //  작업을 위임 받은 서블릿이 데이터를 바로 사용할 수 있도록
            //  ServletReauest 보관소에 저장한다.
            req.setAttribute("op", op);
            req.setAttribute("a", a);
            req.setAttribute("b", b);
            //  어디에서 auto-boxing했음?
/*
            int v1 = 100;
            Integer v2 = Integer.valueOf(v1);
            Integer v3 = v1;    //  autoBoxing
            
            Integer v4 = Integer.valueOf(200);
            int v5 = v4.intValue();
            int v6 = v4; // auto-unboxing
*/
            
            요청배달자.forward(req, res);
            return;
        }
        out.printf("<p>%d + %d = %d</p>\n", a, b, (a + b));
        out.println("</body>");
        out.println("</html>");
    }
}

/*  주의!
    => '+' 문자를 서버에 보낼 때 주의 해야함.
    => URL에서 '+'문자는 공백을 의미함.
        따라서 서버에서 값을 꺼내려면 getParameter()호출 공백이 리턴됨.
    =>  '+' 문자를 서버에 보내려면 URL인코딩 값을 보내야 함.
    %2b

    forword와 ServletRequest보관소.
*/