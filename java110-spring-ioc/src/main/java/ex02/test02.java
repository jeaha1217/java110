/*  IoC Container : FileSystemXmlApplicationContext 클래스 사용법.
        => 스프링의 컨테이너 설정 정보는 XML 파일에 기록한다.
        => OS의 File System 에서 설정파일을 찾는 컨테이너.
    
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
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test02 {
    
    public static void main(String[] args) {
        
        //  생성자에 넘겨준 Spring 설정 파일의 경로는
        //  OS의 파일 시스템 기준이다.
        //  이클립스에서 자바클래스를 실행시키면,
        //  폴더의 현재위치는 프로잭트 경로임.
        //  따라서 다음 경로는 이 프로젝트 경로를 기준으로 찾는다.
        ApplicationContext iocContainer = 
                new FileSystemXmlApplicationContext(
                        "src/main/java/ex02/app-context-1.xml"); 
		
	}
}
