/*  IoC Container : AnnotationConfigApplicationContext	클래스 사용법. 
        => 스프링의 컨테이너 설정 정보는 자바 클래스의 애노테이션을 사용하여 기록한다.
        => 지정한 자바클래스를 찾는다.
    
Spring IoC Container에서 필수로 알아야 하는 계층도.
    
BeanFactory 인터페이스
|
+--> ApplicationContext 인터페이스.
    |
    +--> ClassPathXmlApplicationContext 클래스.
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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test03 {
    public static void main(String[] args) {
        
        //  생성자에 넘겨주는 값은 스프링 설정 정보를 담고 있는 자바 클래스 타입이다.
        //  이 스프링 IoC 컨테이너는 지정된 클래스의 객체를 만든 다음에,
        //  에노테이션 명령에 따라 메서드를 호출한 후 그 리턴값을 보관한다.
        //      요세 트랜드.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class); 
        
    }
}
