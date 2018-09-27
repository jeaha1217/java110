package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

@WebServlet("/manager/list")    //  서블릿은 반드시 / 가 들어감.
public class ManagerListServlet extends HttpServlet{ 
    private static final long serialVersionUID = 1L;
    ManagerMysqlDao managerDao;
    
    @Override   //  httpServlet을 상속 받을땐 빈 init를 오버라이드.
    public void init() throws ServletException {
        DataSource dataSource = new DataSource();
        managerDao = new ManagerMysqlDao();
        managerDao.setDataSource(dataSource);
        super.init();
    }
    
    //  컴파일러에게 이 메소드가 제대로 상속 받았는지 확인해달라고 어노테이션 붙임.
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        List<Manager> list = managerDao.findAll();
        response.setContentType("text/plain;charset=UTF-8");
        //  MIME TYPE에 관해서 잘 알아야 한다규!!
        PrintWriter out = response.getWriter();

        for (Manager s : list) {
            out.printf("%d, %s, %s, %s\n",
                    s.getNo(),
                    s.getName(), 
                    s.getEmail(), 
                    s.getPosition());
        }
    }
}