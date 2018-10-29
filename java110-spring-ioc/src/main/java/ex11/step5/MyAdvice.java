package ex11.step5;

//  Advice class
//  - pointcut이 가리키는 method가 호출 될 때
//    그 호출 전/후에 실행될 method를 갖고있는 클래스
public class MyAdvice {
    
    public void before() {
        System.out.println("MyAdvice.before()");
    }
    
    public void after() {
        System.out.println("MyAdvice.after()");
    }
    
    public void afterReturning() {
        System.out.println("MyAdvice.afterReturning()");
    }
    
    public void afterThrowing() {
        System.out.println("MyAdvice.afterThrowing()");
    }
}
