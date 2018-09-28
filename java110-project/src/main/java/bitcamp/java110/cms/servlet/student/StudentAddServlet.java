package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/add")
public class StudentAddServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        StudentDao studentDao = (StudentDao) this.getServletContext()
                .getAttribute("studentDao");
        
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Student s = new Student();

        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        s.setTel(request.getParameter("tel"));

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - Student Management - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 등록결과</h1>");
        
        try{
            studentDao.insert(s);
            out.println("<p>등록하였습니다.</p>");
        } catch (Exception e) {
            out.println("<p>이메일 등록 중 오류 발생!<p>");
            e.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
    }
}
