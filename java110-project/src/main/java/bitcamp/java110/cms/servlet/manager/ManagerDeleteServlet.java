package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

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

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - Manager Management - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>매니져 삭제 결과</h1>");
        
        try{
            managerDao.delete(no);
            out.println("<p>삭제하였습니다.</p>");
        } catch (Exception e) {
            out.println("<p>삭제 중 오류 발생!<p>");
            e.printStackTrace();
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}