/*  서블릿 배치 정보 - 컨택스트 초기화 파라메터.
    => 컨텍스트 초기화 파라미터는 모든 서블릿이 참조할 수 있다.
        즉 모든 서블릿이 공유해야 하는 정보를 컨택스트 초기화 파라미터로 선언하라!
    => 활용
        DB연결, 파일 업로드 설정 정보등./
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet05 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        
        //  http://localhost:8888/ex06/servlet05
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex06/servlet04\n");
        // 배치 정보에서 컨텍스트 초기화 파라미터 값을 꺼내기
        // => 먼저 서블릿 환경 정보를 다루는 ServletContext 객체를 얻는다.
        ServletContext sc= this.getServletContext();
        
        // => ServletContext 객체를 통해 컨텍스트 초기화 파라미터 값을 꺼낸다.
        out.printf("컨텍스트 초기화 파라미터 aaa=%s\n",sc.getInitParameter("aaa"));
    }

}

/*
    
*/