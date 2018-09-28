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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        Teacher t = new Teacher();

        t.setName(request.getParameter("name"));
        t.setEmail(request.getParameter("email"));
        t.setPassword(request.getParameter("Password"));
        t.setTel(request.getParameter("tel"));
        t.setPay(Integer.parseInt(request.getParameter("pay")));
        t.setSubjects(request.getParameter("subjects"));

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - Teacher Management - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>강사 등록결과</h1>");
        
        try{
            teacherDao.insert(t);
            out.println("<p>등록하였습니다.</p>");
        } catch (Exception e) {
            out.println("<p>이메일 등록 중 오류 발생!<p>");
            e.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
    }
}
