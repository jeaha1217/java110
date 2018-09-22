package bitcamp.java110.ex01;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

//  클라이언트로부터 요청이 들어오면 실행되는 리스너.
//@WebListener
public class Listener02 implements ServletRequestListener {
    
    public Listener02() {
        System.out.println("Listener02() 호출됨.");
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        /*  클라이언트 요청이 들어왔을 때 호출된다.
            예를 들면, 클라이언트의 IP주소를 기록할 수 있다.
         */
        System.out.println("Listener02.requestInitialized.");
        HttpServletRequest httpReuest = (HttpServletRequest)sre.getServletRequest();
        System.out.printf("IP : %s\n", httpReuest.getRemoteAddr());
        System.out.printf("PATH : %s\n", httpReuest.getServletPath());
        System.out.printf("? : %s\n", httpReuest.getRequestURI());
    }
    
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //  클라이언트에게 응답을 완료했을때 호출한다.
        System.out.println("Listener02.requestDestroyed.");
    }
}