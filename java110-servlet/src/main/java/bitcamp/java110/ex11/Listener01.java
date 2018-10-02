//  session의 생성, 소멸 모니터링.
package bitcamp.java110.ex11;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class Listener01 implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //  세션 생성시 이 메소드 호출.
        System.out.printf("ex11/Listener01.sessionCreated():%s\n\n",
                se.getSession().getId());
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // 세셩 소멸시 이 메소드 호출.
        System.out.printf("ex11/Listener01.sessionDestroyed():%s\n\n",
                se.getSession().getId());
    }
}
