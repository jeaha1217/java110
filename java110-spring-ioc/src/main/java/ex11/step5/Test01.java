// AOP : 메소드 전/후에 필터 삽입할 때 다양한 위치 
package ex11.step5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
         
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step5/app-context-1.xml");
        
        // 이 시점에서 IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        
        int r = proxy.addPhoto("ok.jpeg");
        System.out.println("return : " + r);
        
        System.out.println("-----------------");
        
        r = proxy.addPhoto(null);
        System.out.println("return : " + r);
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