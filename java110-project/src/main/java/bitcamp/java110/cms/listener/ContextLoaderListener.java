package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;

//@WebListener
public class ContextLoaderListener implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Call ContextLoaderListener.contextInitialized()");
        
        ServletContext sc = sce.getServletContext();
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
            e.printStackTrace();
        }
    }
}
