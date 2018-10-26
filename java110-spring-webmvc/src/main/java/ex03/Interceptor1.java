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

public class Interceptor1 implements HandlerInterceptor {
    /* test:
           http://localhost:8888/app/ex03/test28/m1
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
       System.out.println("Test29_Interceptor1.preHandler()....");
       return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Test29_Interceptor1.postHandler()....");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("Test29_Interceptor1.afterCompletion()....");
    }
}