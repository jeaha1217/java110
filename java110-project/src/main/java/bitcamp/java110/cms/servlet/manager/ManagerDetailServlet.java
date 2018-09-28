package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet{ 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        int no = Integer.parseInt(request.getParameter("no"));
        Manager m = managerDao.findByNo(no);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
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
        out.println("<h1>매니져 상세 정보</h1>");

        if (m == null) {
            out.println("<p>해당 번호의 매니저가 없습니다!</p>");
        }   else {
            out.println("<table>");
            out.println("<tbody>");
            
            out.printf("<tr><th>번호</th><td>%d</td></tr>\n", m.getNo());
            out.printf("<tr><th>이름</th><td>%s</td></tr>\n", m.getName());
            out.printf("<tr><th>이메일</th><td>%s</td></tr>\n", m.getEmail());
            out.printf("<tr><th>암호</th><td>%s</td></tr>\n", m.getPassword());
            out.printf("<tr><th>전화</th><td>%s</td></tr>\n", m.getTel());
            out.printf("<tr><th>직위</th><td>%s</td></tr>\n", m.getPosition());
            
            out.println("</tbody>");
            out.println("</table>");
            
//            out.printf("<Button type='button' onclick='remove(%d)'>삭제</Button>", m.getNo());
            out.println("<Button type='button' onclick='remove()'>삭제</Button>");
        }
        
        out.println("<script>");
/*       
        out.println("function remove(no) {");
        out.println("location.href = 'delete?no=' + no");
        //  href 현재 경로를 상대경로로
        //  localhost:8888/java110-project/manager/
        //   가 자동으로 들어감.
*/        
        out.println("function remove() {");
        out.printf("location.href = 'delete?no=' + %d", m.getNo());
        
        
        out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}