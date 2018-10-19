/*  의존 객체 자동 주입 : @Autowired에서 같은 타입의 객체가 여러개 일때 II 
    =>  @Resource = @Autowired + @Qualifier
    =>  이 애노테이션은 JSR-250 에서 제안한 애노테이션 이다.
        JDK에 기본으로 포함되어 있지 않기 때문에
        JSR-250명세에 따라 작성된 외부 라이브러리를 추가해야 한다.
        mvnrepository.com에서 "javax.annotation"으로 검색 하라.
        
    JSR?
        (JAVA Specification Request)
        =>  JAVA 기본 라이브러리로 포함시키기 요구하는 명세이다.
            JCP에서 제안한다.
            JSR에 따라 외부 개발자들이 라이브러리를 만들어 사용하다가
            많은 호응이 있으면 Java=에 정식으로 추가된다.
            
    JCP(JAVA Community Process)
    =>  자바 기술에 대한 표준 정의하는 모임
    => 오라클, MS, IBM, facebook, 삼성, LG등 유수 IT 기업이 참여하고 있다.
            
 */
package ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
    public static void main(String[] args) {

        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex08/app-context-6.xml");

        System.out.println("-----------------");

        // 컨테이너에 들어있는 객체의 개수와 이름 알아내기.
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("Bean 갯수 : %d\n", count);

        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", name, iocContainer.getType(name).getName());
        }

        System.out.println("-----------------");

        Car4 c1 = (Car4) iocContainer.getBean("c1");
        System.out.println(c1);

    }
}
//  예외 클래스는 안의 내용은 다른거 없지만 이름만으로 무슨 예외가 발생했는지 알기위해 여러가지 있는것.