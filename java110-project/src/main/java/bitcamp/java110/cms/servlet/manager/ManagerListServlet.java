package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/list")    //  서블릿은 반드시 / 가 들어감.
public class ManagerListServlet extends HttpServlet{ 
    private static final long serialVersionUID = 1L;

    //  컴파일러에게 이 메소드가 제대로 상속 받았는지 확인해달라고 어노테이션 붙임.
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {

        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List<Manager> list = managerDao.findAll();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - Manager Management - </title>");
        out.println("<style>");
        out.println("table, th, td {");
        out.println("border: 1px solid dimgray;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>매니져 목록</h1>");
        
        out.println("<p><a href='form.html'>추가</a></p>");
        
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>NO.</th><th>Name</th><th>Eamil</th><th>Position</th>");
        out.println("</thead>");
        out.println("<tbody>");

        for (Manager m : list) {
            out.println("<tr>");
            
            out.printf("<td>%d</td>", m.getNo());
            out.printf("<td><a href='detail?no=%d'>%s</a></td>",
                    m.getNo(), m.getName());
            out.printf("<td>%s</td>", m.getEmail());
            out.printf("<td>%s</td>", m.getPosition());

            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</tr>");
        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}