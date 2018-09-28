package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        TeacherDao teacherDao = (TeacherDao) this.getServletContext()
                .getAttribute("teacherDao");
        
        response.setContentType("text/html;charset=UTF-8");
        
        Teacher t = new Teacher();

        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("Password"));
        t.setTel(request.getParameter("tel"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));
        
        try{
            teacherDao.insert(t);
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
            
            response.setHeader("Refresh", "3;url=list");
            
            request.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title> - Teacher Management - </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>이메일 등록 중 오류 발생!</h1>");
            out.printf("<p>%s</p>", e.getMessage());
            out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
