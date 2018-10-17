/*  IoC Container : ClassPathXmlApplicationContext 클래스 사용법.
        => 스프링의 컨테이너 설정 정보는 XML 파일에 기록한다.
        => 스프링 설정 파일을 찾을 때 자바의 classpath에서 찾는다.
    
Spring IoC Container에서 필수로 알아야 하는 계층도.
    
BeanFactory 인터페이스
|
+--> ApplicationContext 인터페이스.
    |
    +--> ClassPathXmlApplicationContext	클래스.
        |
        +--> FileSystemXmlApplicationContext 클래스.
        |
        +--> AnnotationConfigApplicationContext 클래스.
        |
        +--> WebApplicationContext      인터페이스.(웹 어플리케이션에서 사용. 당장 쓰는 놈은 아님.)
            |
            +--> StaticWebApplicationContext 클래스.
            |
            +--> XmlWebApplicationContext 클래스.
            |
            +-->  AnnotationConfigWebApplicationContext 클래스.
 */
package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test01 {
    
    public static void main(String[] args) {
        
        //  생성자에 넘겨준 Spring 설정 파일의 경로는
        //  java의 classpath경로임.
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex02/app-context-1.xml"); 
	}
}
