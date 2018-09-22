// get/post 구분하기 II.


package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*  GenericServlet을 직접 상속 받는것 보다 
    MyHttpServlet 클래스를 상속 받으면
    HttpServletRequest, HttpServletResponse를 파라미터로 받는
    servise()를 오버라이딩 할 수 있다. 그래서 사용하기 편하다.
*/
@WebServlet("/ex05/servlet02")
public class Servlet02 extends MyHttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        //  test
        //  http://localhost:8888/ex05/test02.html
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String method = req.getMethod();
        
        if(method.equals("GET")) {
            out.println("get 요청입니다.");
        }   else if(method.equals("POST")) {
            out.println("post 요청입니다.");
        }   else {
            out.println("기타 요청입니다.");
        }
    }
}