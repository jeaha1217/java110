package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;

@WebServlet("/student/delete")
public class StudentDeleteServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        StudentDao studentDao = (StudentDao) this.getServletContext()
                .getAttribute("studentDao");
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        try{
            studentDao.delete(no);
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
            
            request.setAttribute("errer", e);
            request.setAttribute("message", "학생 삭제 오류");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}
