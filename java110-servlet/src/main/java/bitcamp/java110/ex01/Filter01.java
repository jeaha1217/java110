/*  Filter 만들기
    - javax.servlet.Filter 인터페이스 구현
*/
package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
  필터를 만들었으면 어떤 요청에 대해 실행할 것인지 등록 해야 한다.
  URL은 반드시 "/"로 시작해야함. 
@WebFilter({"/ex01/*","/ex02/*"})
    Chain of Responsibility 패턴.
    설계를 어떻게 하느냐에 따라서
    기존 코드를 손대지 않고 기능을 뗏다 붙였다 할 수 있음.
 */
public class Filter01 implements Filter{

    public Filter01() {
        System.out.println("Filter01() 호출.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //  필터가 생성된 후 생성자 호출 후 이 메서드가 호출된다.
        //  필터가 작업하는 동안 사용할 자원을 준비하는 일을 함.
        System.out.println("Filter01.init() 호출.");
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
                    throws IOException, ServletException {
        /*  클라이언트가 요청한 서블릿을 실행하기 전에
            해당 URL에 등록한 필터를 실행한다.
            이때 이 메서드가 호출됨.
            서블릿을 실행하기 전, 후에 수행해야 할 작업이 있다면 이 메서드에서 실행함.
            
          서블릿이 실행하기 전에 하는 일.
              - 클라이언트가 암호화 해서 보낸 데이터를 서블릿이 사용할 수 있도록 암호 해제하기.
              - 클라이언트가 압축해서 보낸 데이터 서블릿이 사용할 수 있도록 압축 해제 하기.
              - 클라이언트의 요청에 대해 기록 남기기
              - 클라이언트가 특별한 형식으로 보낸 데이터를 파싱하여 서블릿이 사용하기 쉽게 변환하기.
              - 클라이언트가 요청한 서블릿의 실행 권한이 있는지 검사하기.
              - 클라이언트가 로그인 한 사용자인지 검사하기.
         */
        System.out.println("Filter01.doFilter() -- before");
        
        //  다음 필터가 있다면 실행하고, 없다면 서블릿을 호출하게 함.
        chain.doFilter(request, response);
/*        위 메소드를 호출하지 않으면 다음 필터나 서블릿을 실행하지 않음.
          따라서 빼면 안됨.
          최종적으로 서블릿의 service() 호출이 끝나면 위 메서드는 리턴됨.

          서블릿을 실행한 후에 하는 일:
          - 클라이언트로 보낼 데이터 압축하기.
          - 클라이언트로 보낼 데이터 암호화 하기.
          - 클라이언트로 보낼 데이터를 특정 형식으로 변환 하기.
*/   
         System.out.println("Filter01.doFilter() --\t after");
    }

    @Override
    public void destroy() {
        // 톰캣 서버가 종료 되거나 웹애플리캐이션이 멈출 때
        // 생성된 모든 필터에 대해 이 메서드를 호출한다.
        // init()에서 준비했던 자원을 이 메소드에서 해제한다.
        System.out.println("Filter01.Destroy() 호출.");
        Filter.super.destroy();
    }

}
/*  Filter 가 구동되는 절차.
    1) 톰캣 서버를 시작하거나 웹 애플리캐이션을 시작하면 필터 객체를 생성한다.
        - 생성자 호출 => init()호출.
    2)  클라이언트 요청이 들어오면,
        - 필터에 해당하는 URL이라면, doFilter()호출.
        - 필터에 해당하지 않는 URL이라면 이 필터는 동작 되지 않는다.
    3) 톰캣 서버를 종료하거나 웹 애플리캐이션을 멈추면,
        - destroy()호출.
    주의!
    - 필터는 호출 순서를 명확하게 제어할 수 없다.
    - 따라서 필터 순서에 의존하는 방식으로 프로그래밍을 해서는 안됨.
    
    
    Chain of Responsibility 패턴.
    
    Aspect Oriented Program ?
    
    객체 = Object = Instance = Bean <= Component
    Component : 한개 이상의 클래스로 구성된 특별한 역할을 수행하는 작업자.
 */