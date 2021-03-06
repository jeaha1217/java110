package bitcamp.java110.cms.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        
        System.out.println("AuthInterceptor.preHandler()..!");
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("loginUser") == null ) {
            //  로그인 하지 않았다면 
            response.sendRedirect("/app/auth/form");
            return false;   //  PageController의 requestHandler를 실행하지 말라.
        }
        return true;
    }

}
