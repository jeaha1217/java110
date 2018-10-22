package bitcamp.java110.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping;
import bitcamp.java110.cms.mvc.RequestMappingHandlerMapping.Handler;

//  Spring Web MVC의 핵심 DispatcherServlet
//  이 놈이 오늘의 핵심 포인트.
//  등장 배경?
public class DispatcherServlet extends HttpServlet  {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        //  클라이언트가 요청한 URL에서 /app 다음 경로로를 추출한다.
        System.out.println(request.getServletPath());
        System.err.println(request.getPathInfo());
        String pageControllerPath = request.getPathInfo();

        //  Spring IoC Container 가져오기
        ApplicationContext iocContainer = 
                (ApplicationContext) this.getServletContext()
                .getAttribute("iocContainer");

        try {
            //  IoC Container에서 요청 URL을 처리할 method를 찾아야 한다.
            //  1) method 정보가 보관된 객체를 얻는다.
            RequestMappingHandlerMapping handlerMapping = 
                    (RequestMappingHandlerMapping) iocContainer.getBean(
                            RequestMappingHandlerMapping.class);
            
            //  2) HandlerMapping에서 URL을 처리한 method정보를 얻는다.
            Handler handler = handlerMapping.getHandler(pageControllerPath);
            
            if(handler == null)
                throw new Exception("요청을 처리할 수 없습니다.");
            
            //  3) URL을 처리항 Method를 호출한다.
            String viewUrl =
                    (String) handler.method.invoke(handler.instance,
                            request,
                            response);
            
            if(viewUrl.startsWith("redirect:")) {
                response.sendRedirect(viewUrl.substring(9));
            }   else {
                //  페이지 컨트롤러가 지정한 URL을 실행
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
                rd.include(request, response);
            }
        }   catch(Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("error", e);
            request.setAttribute("message", "실행오류!");
            
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.include(request, response);
        }
    }
}
