//  세션의 - 세션 timeout.
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet23")
public class Servlet23 extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //  http://localhost:8888/ex11/servlet23
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        /*  Session Timeout
            => 서블릿 컨테이너의 설정파일에서 세션 타임아웃 시간을 설정할 수 있다.
                예) web.xml  (톰캣 서버인 경우)
                <session-config>
                    <session-timeout>1</session-timeout>
                </session-config>
            => 각각의 세션 객체에 대해 타임아웃을 설정 할 수있다.
                예) session.setMaxInactiveInterval(초);
            
            다음과 같이 세션에 대해 타임아웃을 설정 할 수 있다.
            => 10초 사이에 다시 요청이 들어오지 않으면
                해당 세션은 무효화 된다.
            위나 아래 두가지 방법으로 할 수 있음.
        */
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(10);     //  단위는 초.
        
        //  세션에 데이터 보관.
        session.setAttribute("name", "IsoL");
        
        //  테스트:
        //  이 서블릿을 실행한 후 30 초 이전에 /ex11/servlet22 실행하기.
        //  그리고 다시 30초가 지난 후에 /ex11/servlet22 실행하기.
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> ! SESSION ! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Session data - timeout 설정.</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
