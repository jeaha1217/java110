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
            /* 등록 오류 내용을 출력하고 1초가 경과한 후에 목록 페이지를 요청하도록 
             * '리프레시'명령을 설정.
             * =>
             */
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
            out.println("<h1>이메일 등록 중 오류 발생!</h1>");
            out.printf("<p>%s</p>", e.getMessage());
            out.println("<p>잠시 기다리면 목록 페이지로 자동으로 이동합니다.</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
