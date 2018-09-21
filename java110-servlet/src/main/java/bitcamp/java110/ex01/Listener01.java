/*  리스너 만들기.
    - 리스너 (Listener)? 특정 상황에 놓이면 실행되는 객체.
    - javax.servlet.XXXListener
*/
package bitcamp.java110.ex01;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//  웹 애플리케이션이 시작 되거나 종료되는 상황일때 실행 되는 리스너 만들기.
//  리스너를 만들었으면 서블릿 컨테이너에 등록해야 한다.
//@WebListener
public class Listener01 implements ServletContextListener {
    
    public Listener01() {
        System.out.println("Listener01() 호출됨.");
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* 웹 애플리캐이션이 시작 될 때 이 메소드가 호출 됨.
        이 웹 애플리캐이션에 소속된 서블릿들이
        공통으로 사용하는 자원은 이 메서드에서 준비함.
        예를 들면, IoC Container, DAO, DA Connetion등
         */
        System.out.println("Listener01.contextInitialized.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 웹 애플리캐이션이 종료 될 때 이 메소드가 호출 됨.
        //  contextInitialized()에서 중비했던 자원을 해제함.
        
        System.out.println("Listener01.contextDestroyed.");
    }
    
}
