package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcamp.java110.cms.AppConfig;

public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();

        // DAO가 사용할 DB 커넥션풀 객체 준비
        // => DataSource 객체를 만들 때 컨텍스트 파라미터 값을 꺼내서 사용한다.
        try {
            ApplicationContext context =
                    new AnnotationConfigApplicationContext(AppConfig.class);
            
            sc.setAttribute("iocContainer", context);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
