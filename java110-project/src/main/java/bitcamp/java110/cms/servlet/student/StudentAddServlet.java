package bitcamp.java110.cms.servlet.student;

import java.io.IOException;

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
        
        request.setCharacterEncoding("UTF-8");
        StudentDao studentDao = (StudentDao) this.getServletContext()
                .getAttribute("studentDao");
        Student s = new Student();

        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));
        s.setPassword(request.getParameter("password"));
        s.setSchool(request.getParameter("school"));
        s.setWorking(Boolean.parseBoolean(request.getParameter("working")));
        s.setTel(request.getParameter("tel"));

        
        try{
            studentDao.insert(s);
            //  오류 없이 등록에 성공했다면,
            //  목록 페이지로 다시 요청하라고 redirect를 요청한다.
            response.sendRedirect("list");
        } catch (Exception e) {
            e.printStackTrace();
            
            request.setAttribute("errer", e);
            request.setAttribute("message", "학생 등록 오류");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}
