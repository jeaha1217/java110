package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
            // 오류 내용을 처리하는 서블렛으로 실행을 위임한다.
            RequestDispatcher rd = request.getRequestDispatcher("/error");

            //  위임하기 전에 작업을 수행하는데 필요한 정보를
            //  ServletRequest 보관소에 담아 전달한다.
            request.setAttribute("errer", e);
            request.setAttribute("message", "매니져 등록 오류");
            request.setAttribute("refresh", "3;url=list");

            //  작업을 위임한다.
            rd.forward(request, response);
        }
    }
}