//  세션 사용 후 - httpSession 보관소에 data 저장하기.
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet14")
public class Servlet14 extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String tel = request.getParameter("tel");
        
        //  세션에 보관된 name과 age값을 꺼낸다.
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        String age = (String)session.getAttribute("age");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> ! session ! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> The Last Page </h1>");
        out.printf("<p>이름 : %s</p>", name);
        out.printf("<p>나이 : %s\n</p>", age);
        out.printf("<p>전화 : %s\n</p>", tel);
        out.println("</body>");
        out.println("</html>");
    }
}
//  1부터 4까지 httpSession 보관소에 data 따로 저장