/* 인터셉터 다루기 - FrontController와 vs "PageController/JSP" 사이의 Filtering 방법.
    3대 필터링 기법
    Filter Servlet
    InterCeptor
    AOP
 */
package ex03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor2 implements HandlerInterceptor {
    /* test:
           http://localhost:8888/app/ex03/test28/m1
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
       System.out.println("Test29_Interceptor2.preHandler()....");
       if(request.getParameter("name") != null) {
           response.sendRedirect("../m1");
           //   return 값이 false이면 페이지 컨트롤러를 실행하지 않는다.
           return false;
       }
       //   return 값이 true이면 다음 인터셉터나 페이지 컨트롤러를 실행한다.
       return true;
    }
    //  Auth Interceptor로 쓸 수 있다.
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Test29_Interceptor2.postHandler()....");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Test29_Interceptor2.afterCompletion()....");
    }
}