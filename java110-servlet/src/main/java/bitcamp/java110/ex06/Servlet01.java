/*  서블릿 배치 정보 - loadOnStartUp 속성.
    =>  loadOnStartup 속성의 값을 설정하지 않으면,
        클라이언크가 최초로 해달 서블릿의 실행을 요청했을 때 비로서 객체를 생성한다.
    =>  loadOnstratup 속성의 값을 설정하면,
        웹 어플리케이션이 실행될때 해당 서블릿 객체를 자동으로 생성한다.
        물론 init()도 자동 호출한다.
        
    =>  사용법
        loadOnStartup = 실행순서.
    => 활용
        - 서블릿을 실행하기 전에 준비해야할 작업이 있다면,
            그리고 그 작업을 수행 하는데 시간이 걸린다면
            서블릿을 실행하기 전에 미리 서블릿 객체를 만들어 놓고,
            init()에서 필요한 자원을 미리 준비시키는것이 좋다.
        - 또는 모든 서블릿들이 공유하는 자원을 준비시킬 때도 응용할 수 있다.
        
    
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        value="/ex06/servlet01",
        loadOnStartup=1)
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Servlet01() {
        System.out.println("/ex06.servlet01 생성자 호출.");
    }
    
    @Override
    public void init() throws ServletException{
        System.out.println("/ex06.servlet01.init() 호출...");
    }
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        
        //  상속받은 기능을 다 포기하고 오버라이드.
        //  http://localhost:8888/ex06/servlet01
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex06.servlet01 실행.");

    }
}

/*
    
*/