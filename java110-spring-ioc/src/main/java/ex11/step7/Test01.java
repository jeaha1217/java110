// AOP : annotation으로 aop 설정하기 
package ex11.step7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    
    public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex11/step7/app-context-1.xml");
        
        // IoC 컨테이너에 들어있는 객체의 목록 출력하기
        printObjectList(iocContainer);
        
        Service proxy = (Service)iocContainer.getBean(Service.class);
        
        int r = proxy.addPhoto("ok.jpeg");
        System.out.println("리턴 값: " + r);
        
        r = proxy.addPhoto(null);
        System.out.println("리턴 값: " + r);
        
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
/*
-----------------
Bean 갯수 : 11
=> dao1 : ex11.step7.Dao1
=> dao2 : ex11.step7.Dao2
=> dao3 : ex11.step7.Dao3
=> myAdvice : ex11.step7.MyAdvice
=> serviceImpl : com.sun.proxy.$Proxy15
=> org.springframework.context.annotation.internalConfigurationAnnotationProcessor : org.springframework.context.annotation.ConfigurationClassPostProcessor
=> org.springframework.context.annotation.internalAutowiredAnnotationProcessor : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
=> org.springframework.context.annotation.internalCommonAnnotationProcessor : org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
=> org.springframework.context.event.internalEventListenerProcessor : org.springframework.context.event.EventListenerMethodProcessor
=> org.springframework.context.event.internalEventListenerFactory : org.springframework.context.event.DefaultEventListenerFactory
=> org.springframework.aop.config.internalAutoProxyCreator : org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
-----------------
MyAdvice.before(): ok.jpeg
addPhoto() + filename
MyAdvice.afterReturning(): 1
리턴 값: 1
MyAdvice.before(): null
addPhoto() + filename
MyAdvice.afterThrowing(): file not found...
Exception in thread "main" java.lang.RuntimeException: file not found...

*/