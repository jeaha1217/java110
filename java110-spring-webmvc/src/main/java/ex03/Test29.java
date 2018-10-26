/* 인터셉터 다루기 - FrontController와 vs "PageController/JSP" 사이의 Filtering 방법.
    3대 필터링 기법
    Filter Servlet
    InterCeptor
    AOP
*/
package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03/test29")
public class Test29 {
    /*  Inteceptor를 Spring에 등록하기
        =>  XML 설정.
            - /WEB-INF/app-Servlet.xml 참고!
        =>  JAVA Config 설정
            - 문서 참고
         test:
           http://localhost:8888/app/ex03/test28/m1
     */
    @GetMapping("m1")
    public void m1() throws Exception {
        System.out.println("Test29.m1()");
    }
    
    @GetMapping("m2")
    public void m2() throws Exception {
        System.out.println("Test29.m2()");
    }
    
    @GetMapping("ok/m3")
    public void m3() throws Exception {
        System.out.println("Test29.m3()");
    }
    
    @GetMapping("no/m4")
    public void m4() throws Exception {
        System.out.println("Test29.m4()");
    }
}