// get/post 구분하기 I

package bitcamp.java110.ex05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/ex05/servlet01")
public class Servlet01 extends GenericServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            ServletRequest req,
            ServletResponse res)
                    throws ServletException, IOException {
        //  test
        //  http://localhost:8888/ex05/test01.html
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        /*  GET / POST / HEAD 등을 구분하는 것은 HTTP 프로토콜의 기능임.
            ServletRequest에는 HTTP 를 다루는 메서드가 없음.
            따라서 원래의 타입인 HttpServletRequest로 변환 해야만 가능함.
        */ 
        
        HttpServletRequest httpReq = (HttpServletRequest)req;
        String method = httpReq.getMethod();

        if(method.equals("GET")) {
            out.println("get 요청입니다.");
        }   else if(method.equals("POST")) {
            out.println("post 요청입니다.");
        }   else {
            out.println("기타 요청입니다.");
        }
    }
}

/*
    
*/