// @RequestMapping 다루기 : URL다루기 I
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test08 {

    //  각 method에 URL 지정하기
    //  
    //  test:
    //  http://localhost:8888/app/ex02/test08/m1
    //  http://localhost:8888/app/ex02/test08/m2

    @RequestMapping(value="/ex02/test08/m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test08.m1()";
    }
    
    @RequestMapping(value="/ex02/test08/m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test08.m2()";
    }
    
    
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
