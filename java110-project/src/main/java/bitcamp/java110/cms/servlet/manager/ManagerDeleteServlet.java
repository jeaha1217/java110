package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet { 
    private static final long serialVersionUID = 1L;
    ManagerMysqlDao managerDao;
    
    @Override   //  httpServlet을 상속 받을땐 빈 init를 오버라이드.
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (managerDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("번호에 해당하는 강사가 없습니다.");
        }
    }
}