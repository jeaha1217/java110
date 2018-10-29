// AOP : 메소드 앞/뒤에 필터 끼우는 기술 
// 
package ex11.step4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    /*  AOP (Aspect-Oriented Programming)?
        - 기존의 코드를 손대지 않고 특정 기능을 삽입하는 기술
        - 메소드 호출 앞/뒤/값리턴뒤 에 코드를 삽입할 수 있다.
        - 일종의 필터를 추가하는 기술이다.
        
        AOP 적용 방법
        - AOP 관련 lib를 추가.
            - "AspectJ Weaver"로 검색
            - build.gradle 추가
            - gradle eclipse
            - prject refresh
        - Filter 역할을 할 클래스 정의
        - XML 또는 Java config 로 필터를 정의
        
        AOP용어
        - Advice     : 필터링 대상이 되는 method(join point)의
                       호출 앞/뒤에 삽입하는 필터객체.
                     예) MyAdvice
        - Join Point : Advice가 삽입될 method.
                     예) insert(), update(), delete() 등
        - Pointcut   : Advice를 삽입해야 하는 method에 대한 위치 정보.
                     예) execute("* ex11.step4.ServiceImpl.*(..)")
        - Target Object : Advice를 삽입해야 하는 method를 갖고 있는 클래스.
                     예) ServiceImple, ManagerDao 등
        - Aspect     : 어느 pointcut에 어떤 advice를 삽입할 것인지를 가리키는 정보
                     예) 설정정보.
    */
    public static void main(String[] args) {
         
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step4/app-context-1.xml");
        
        // 이 시점에서 IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        proxy.add(); // proxy.xxx() --> MethodFilter.invoke() --> orignal.xxx()
        proxy.update();
        proxy.delete();
        proxy.list();
        proxy.addPhoto();
    }
    
    public static void printObjectList(ApplicationContext iocContainer) {
        System.out.println("-----------------");

        // 컨테이너에 들어있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n",
                    name,
                    iocContainer.getType(name).getName());
        }
        System.out.println("-----------------");
    }
}