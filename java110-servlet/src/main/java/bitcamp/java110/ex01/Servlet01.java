package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  서블릿을 만들었으면 서블릿 컨테이너에 등록해야함.
  서블릿을 등록할 때 URL을 지정해야 클라이언트가 호출할 수 있다.
      URL은 "/"로 시작해야 함.
      클라이언트는 다음과 같이 요청해야함.
      
  1) 웹 애플리캐이션의 경로 root(/)로 설정했을 경우,
  
      http://localhost:8888/ex01/servlet01
      
  2) 웹 애플리캐이션의 경로를 web01로 지정했을 경우,
  
      http://localhost:8888/web01/ex01/servlet01
      
  3) 웹 애플리캐이션의 경로응 별도로 지정하지 않을 경우,
  
      http://localhost:8888/java110-sevlet/ex01/servlet01
      
      즉 웹 애플리케이션 이름 자리에 프로젝트 이름을 사용되는것이 default.
      
      eclipse 상에서는 server 폴더의 server.xml 파일 마지막 단에
      <Context docBase="java110-servlet" path="/" reloadable="true" source="org.eclipse.jst.j2ee.server:java110-servlet"/></Host>
      path="/"로 잡아줌.
      
    서블릿을 새로 만든 경우,
        서블릿 컨테이너를 다시 시작해야 적용됨.
    만약 이미 만든 서블릿에 대해 변경했을경우,
        10초 이내에 자동으로 로딩된다...?에??
*/
@WebServlet("/ex01/servlet01")
public class Servlet01 implements Servlet{
    
    ServletConfig config;
    
    public Servlet01() {
        System.out.println("\nServlet01() 호출됨.\n");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        /*  서블릿 객체를 만든 후 생성자 다음으로 호출 되기 때문에
            이 메서드에서는 서블릿이 작업 할 때 사용할 자원을 준비하는 일을 함.
            예) DB Connection, 외부 서버에 소켓을 연결하는 등의 작업.
                또는 서블릿에서 사용할 Service 객체나 DAO 객체를 준비하는 일을 함.
         */
        System.out.println("\ninit() 호출됨.\n");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        /*  서블릿을 실행하다가 서블릿 정보가 필요할 때
            이 매서드를 호출하여 ServletConfig 객체를 리턴 받아 사용함.
            그래서 이 매서드는 init()에서 파라미터로 받은 ServletConfig를
            잘 보관해 두었다가 호출될 때 리턴함.
         */
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /*  클라이언트가 이 서블릿의 실행을 요청할 때 마다 서블릿 컨테이너가 호출함.
            그래서 클라이언트가 요청한 일을 수행한다.
            예) 게시물 목록 조회, 로그인 처리, 회원 가입 처리하는 등의 일을 함.
         */
        System.out.println("\n/ex01/servlet01.Service() 호출됨.\n");
    }

    @Override
    public String getServletInfo() {
        /*  서블릿을 실행 중에 직접 호출할 일은 없음.
            주로 서블릿 컨테이너의 관리 메뉴에서 서블릿 정보를 출력 할 때
            이 메서드의 리턴값을 받아서 출력함.
         */
        return "Servlet01";
    }

    @Override
    public void destroy() {
        /*  서블릿 객체가 제거되기 직전에 호출되는 메서드.
            그래서 이 메서드에서는 init()에서 준비한 자원을 해제 시키는 일을 함.
            예를 들면 DB커넥션을 닫거나 소켓 연결을 닫는 등의 작업을 수행.
         */
        System.out.println("Destroy() 호출됨.");
    }

}
/*
    서블릿 구동 절차
    1) 클라이언트가 요청한 URL에 응답할 서블릿 찾기.
    2) 해당 서블릿의 인스턴스가 이미 생성 되었다면,
         - service를 호출.
    3) 해당 서블릿의 인스턴스가 아직 생성되니 않았다면,
         - 서블릿 객체 생성 및 생성자 호출.
         - init() 호출
         - service() 호출
    4) 만약 서블릿 컨테이너를 종료하거나 웹 어플리케이션의 실행을 멈춘다면,
         - 생성된 모든 서블릿들에 대해 destroy()를 호출.
         - 생성된 모든 서블릿 객체를 garbage로 만듦.
        
    
    - 주의!
        - 서블릿 객체는 클래스 당 한 개만 생성된다.
        - 요청할 때마다 생성되는것이 아님!
        - 클라이언트 마다 객체가 생성되는것이 아니라 한 객체를 사용하는 것이기 때문에,
            객체의 인스턴스 변수를 공유하게 됨!
        - 클라이언트 마다 구분해서 값을 저장한다면,
            서블릿의 인스턴스 변수를 사용해서는 안된다.
          why?  서블릿 객체는 한개만 생성 되고, 모든 클라이언트가 공유하니까 ㅇㅇ
*/


