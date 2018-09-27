/*  서블릿 배치 정보 - XML과 초기화 파라미터.
    =>  loadOnStartup 
 */

package bitcamp.java110.ex06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
@WebServlet(
        value="/ex06/servlet04",
        loadOnStartup=1,
        initParams= {
                @WebInitParam(name="aasdf",value="hell"),
                @WebInitParam(name="qqwert",value="holly"),
                @WebInitParam(name="zzxcv",value="fuck")
        })
        
        web.wml과 어노테이션의 차이.
        xml로 하면 컴파일 할 필요가 없음. 다만 기술하기 귀찮을뿐.
        애노테이션으로 하면 기술하긴 편하지만 컴파일 해야함.
*/
public class Servlet04 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public Servlet04() {
        System.out.println("/ex06.servlet04 생성자 호출.");
    }
    
    @Override
    public void init() throws ServletException{
        System.out.println("/ex06.servlet04.init() 호출.");
    }
    
    @Override
    public void service(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        
        //  상속받은 기능을 다 포기하고 오버라이드.
        //  http://localhost:8888/ex06/servlet04
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("/ex06/servlet04\n");
        out.printf("aasdf=%s\n",this.getInitParameter("aasdf"));
        out.printf("qqwert=%s\n",this.getInitParameter("qqwert"));
        out.printf("zzxcv=%s\n",this.getInitParameter("zzxcv"));
    }
}

/*
    
*/