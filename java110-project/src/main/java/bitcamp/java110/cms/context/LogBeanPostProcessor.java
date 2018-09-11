package bitcamp.java110.cms.context;

import java.util.Collection;

import bitcamp.java110.cms.annotation.Component;

//  새로운 기능을 추가해보자.
//  객체 지향으로 잘 짜여진 프로그램은 확장이 쉽다.
@Component
public class LogBeanPostProcessor implements BeanPostProcessor{
    ApplicationContext beanContainer;
    
    public void postProcess(ApplicationContext beanContainer){
        //  objPool에 보관된 객체 목록을 꺼낸다.
        Collection<Object> objList = beanContainer.objPool.values();
        
        System.out.println("================================");
        for(Object obj : objList) {
            System.out.println(obj.getClass().getName());
        }
        System.out.println("================================");
    }
}
