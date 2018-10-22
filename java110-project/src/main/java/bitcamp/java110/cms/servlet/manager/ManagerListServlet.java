package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.service.ManagerService;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        
        int pageNo = 1;
        int pageSize = 5;
        
        if(request.getParameter("pageNo") != null) {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
            if(pageNo < 1) {
                pageNo = 1;
            }
        }
        
        if(request.getParameter("pageSize") != null) {
            pageSize = Integer.parseInt(request.getParameter("pageSize"));
            if(pageSize <= 5 || pageSize >= 10) {
                pageSize = 5;
            }
        }
        //   CPU 과부화를 막기위해, DDos 공격을 막기도 함.
        
        ApplicationContext iocContainer = 
                (ApplicationContext) this.getServletContext()
                        .getAttribute("iocContainer");
        
        ManagerService managerService =
                iocContainer.getBean(ManagerService.class);
        
        List<Manager> list = managerService.list(pageNo, pageSize);
        
        request.setAttribute("list", list);
        
        request.setAttribute("viewUrl", "/manager/list.jsp");
    }
}