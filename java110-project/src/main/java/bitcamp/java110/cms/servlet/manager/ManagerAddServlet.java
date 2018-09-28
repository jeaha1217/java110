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

@WebServlet("/manager/add")
public class ManagerAddServlet extends HttpServlet{ 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost( // service, doGet, doPost
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        //  등록 결과를 출력하고, 1초후에 목록 페이지를 요청하도록
        //  refresh명령을 설정한다.
        //  응답 할때 응답 헤더로 리프레시에 대한 명령을 웹 브라우져에 알린다.
        
        //  post 방식으로 들어온 한글 데이터는
        //  다음 메소드를 호출하여 어떤 인코딩인지 알려줘야
        //  getParameter() 호출할 때 정상적으로 디코딩 할 것이다.
        request.setCharacterEncoding("UTF-8");
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        Manager m = new Manager();

        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPosition(request.getParameter("position"));
        
        
        
        try{
            managerDao.insert(m);
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
            out.println("<title> - Manager Management - </title>");
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