package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

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
            response.setHeader("Refresh", "3;url=list");
            
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title> - Student Management - </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>삭제 중 오류 발생!</h1>");
            out.printf("<p>%s</p>", e.getMessage());
            out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.<p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
