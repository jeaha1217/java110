/*  의존 객체 자동 주입 : @Autowired에서 같은 타입의 객체가 여러개 일때 
    =>  어떤 객체를 주입해야 할지 모르기 때문에 예외를 발생시킨다.
    => 해결책 : car 3 test05
 */
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex08/app-context-4.xml");

        System.out.println("-----------------");

        // 컨테이너에 들어있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", name, iocContainer.getType(name).getName());
        }

        System.out.println("-----------------");

        Car2 c1 = (Car2) iocContainer.getBean("c1");
        System.out.println(c1);

    }
}
//  예외 클래스는 안의 내용은 다른거 없지만 이름만으로 무슨 예외가 발생했는지 알기위해 여러가지 있는것.