package ex11.step3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodFilter implements InvocationHandler {
    
    public Object original;
    
    public MethodFilter (Object original) {
        this.original = original;
    }
    
    /*  메소드 호출 과정
        APP
         --> [자동생성된 프록시] add() 호출 -->
             --> [methodFilter] invoke() 호출
                 --> [원래객체] 메소드 호출
    */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // add() 메소 드호출 전 수행할 작업.
        if(method.getName().equals("add")) {
            System.out.println("MethodFilter: 호출 전 작업수행!");
        }
        //  원래 객체의 메소드 호출
        Object rv = method.invoke(original,  args);
        
        //  add()메소드 호출 후 수핼할 작업
        if(method.getName().startsWith("add")) {
            System.out.println("MethodFilter: 호출 후 작업수행!");
        }
        
        return rv;
    }
}
