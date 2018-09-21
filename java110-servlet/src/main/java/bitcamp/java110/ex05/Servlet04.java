// get/post 구분하기 IV.


package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  HttpServlet을 상속
@WebServlet("/ex05/servlet04")
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        //  test
        //  http://localhost:8888/ex05/test04.html
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
            out.println("get 요청입니다.");
    }
}
/*
    
*/