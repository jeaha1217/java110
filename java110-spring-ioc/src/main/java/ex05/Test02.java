/*	setter 호출 : Set property 값 설정하기.
	
	XML 문법
    방법)
        <property name="프로퍼티명" >
            <set>...</set>
        </property>
 */
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
    public static void main(String[] args) {

        ApplicationContext iocContainer =
                new ClassPathXmlApplicationContext("ex05/app-context-2.xml");

        System.out.println("-----------------");

        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n",
                name,
                iocContainer.getType(name).getName());
        }

        System.out.println("-----------------");

        Car c1 = (Car) iocContainer.getBean("c1");
        System.out.println(c1);

    }
}