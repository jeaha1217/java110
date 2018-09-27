package bitcamp.java110.cms.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;

//  이 서블릿의 배치정보는 web.xml에 둔다.
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        System.out.println("Call InitServlet.init()");
        ServletContext sc = this.getServletContext();
        //  DAO 가 사용할 DB커넥션 객체 준비.
        //  => Datasource 객체를 만들때 context parameter값을 꺼내서 사용.
        try {
            DataSource dataSource = new DataSource(
                    sc.getInitParameter("jdbc.driver"),
                    sc.getInitParameter("jdbc.url"),
                    sc.getInitParameter("jdbc.username"),
                    sc.getInitParameter("jdbc.password"));

            //  DAO 객체 생성 밒 DB 커넥션풀 주입하기.
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);

            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);

            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);

            // 서블릿에서 DAO를 이용할 수 있도록 ServletContext보관소에 저장하기.
            sc.setAttribute("managerDao", managerDao);
            sc.setAttribute("teacherDao", teacherDao);
            sc.setAttribute("studentDao", studentDao);
        }   catch (Exception e) {
            throw new ServletException(e);
        }

        /*  service() 또는 doGet(), doPost()등의 메소드를 구현하지 않해?
        이 서블릿은 클라이언트의 요청을 처리하기 위해 만든 서블릿이 아님.
        클라이언트 요청을 처리하는 다른 서블릿들이 사용할 공용 자원을 준비하는 일을함.
        그래서 service() 또는 doGet(), doPost()를 구현하지 않는다.
        클라이언트가 요청하지 않아도 이 서블릿 객체가 생성되고
        init()가 실행되어야 하기 때문에 loadOnStartup 배치 속성을 추가한다.
         */
    }
}