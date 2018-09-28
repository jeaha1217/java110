package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        try{
            managerDao.delete(no);
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
            
            request.setAttribute("errer", e);
            request.setAttribute("message", "매니져 삭제 오류");
            request.setAttribute("refresh", "3;url=list");

            request.getRequestDispatcher("/error").forward(request, response);
        }
        
    }
}