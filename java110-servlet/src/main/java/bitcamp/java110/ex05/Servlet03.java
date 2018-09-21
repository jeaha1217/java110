// get/post 구분하기 III.


package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//  MyHttpServlet을 직접 상속 받는것 보다 
//  MyHttpServlet2 클래스를 상속 받으면
//  Get Post 요청 구분하여 처리 할 수 있다.
@WebServlet("/ex05/servlet03")
public class Servlet03 extends MyHttpServlet2 {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        //  test
        //  http://localhost:8888/ex05/test03.html
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
            out.println("get 요청입니다.");
    }
}
/*
    
*/