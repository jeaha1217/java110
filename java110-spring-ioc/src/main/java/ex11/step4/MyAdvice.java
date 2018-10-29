package ex11.step4;

//  Advice class
//  - pointcut이 가리키는 method가 호출 될 때
//    그 호출 전/후에 실행될 method를 갖고있는 클래스
public class MyAdvice {
    
    public void advice1() {
        System.out.println("MyAdvice.advice1()");
    }
    
    public void advice2() {
        System.out.println("MyAdvice.advice2()");
    }
}
