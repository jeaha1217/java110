package bitcamp.java110.cms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.web.PageController;

//  Spring Web MVC의 핵심 DispatcherServlet
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

        //  IoC Container에서 PageController를 찾는다
        try {
            PageController controller = (PageController) iocContainer.getBean(pageControllerPath);

            //  PageController 실행
            String viewUrl = controller.service(request, response);
            
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
