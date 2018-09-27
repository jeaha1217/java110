/*  서블릿 배치 정보 - 초기 파라미터.
    => 서블릿이 실행하는 동안 사용할 값이 고정값이라면
        자바 코드로 그 값을 표혀야하기 보다는
애노테이션이나 xml 태그로 표현하는 것이 관리하기 편하다.
    
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(    //  배치 정보를 설정하는 애노테이션.
        value="/ex06/servlet02",
        initParams= {
                @WebInitParam(name="aasdf",value="hell"),
                @WebInitParam(name="qqwert",value="holly"),
                @WebInitParam(name="zzxcv",value="fuck")
        })  //  애노테이션 갑을 설정하는데 안에 애노테이션이 또 들어올 수 있다.
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        
        //  상속받은 기능을 다 포기하고 오버라이드.
        //  http://localhost:8888/ex06/servlet02
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        //  배치정보에서 초기화 파라미터 값을 꺼내기.
        out.printf("aasdf=%s\n",this.getInitParameter("aasdf"));
        out.printf("qqwert=%s\n",this.getInitParameter("qqwert"));
        out.printf("zzxcv=%s\n",this.getInitParameter("zzxcv"));

    }
}

/*
    
*/