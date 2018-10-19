/*  JAVA Config 

    =>  XML로 설정하지 않고, 자바 클래스에서 애노테이션으로 설정하는것을 말함.  기억!!
    =>  요즘 많이 사용하고 있는 SpringBoot의 기본 설정 방법임.
    
    
 */
package ex10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        
        //  JAVA Config를 사용할 때는 다음 IoC Container 를 사용한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("-----------------");

        // 컨테이너에 들어있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", name, iocContainer.getType(name).getName());
        }

        System.out.println("-----------------");

        Car c1 = (Car) iocContainer.getBean("c1");
        System.out.println(c1);
        
        Car c2 = (Car) iocContainer.getBean("getAustinMartin");
        System.out.println(c2);
        
        Car DB7 = (Car) iocContainer.getBean("getAustinMartin");
        System.out.println(DB7);
        
        Car DB11 = (Car) iocContainer.getBean("DB11");
        System.out.println(DB11);
        
        //  여기 까지가 Spring의 "기초"...
    }
}