package bitcamp.java110.cms.web.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.web.PageController;

@Component("/auth/logout")
public class LogoutController implements PageController {

    @Override
    public String service (
            HttpServletRequest request, 
            HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        
        // 현재 세션 객체를 무효화시킨다.
        session.invalidate();
        
        return "redirect:login";
    }
}