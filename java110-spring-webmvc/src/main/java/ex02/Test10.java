// @RequestMapping 다루기 : URL다루기 III
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test10")
public class Test10 {

    //  클래스에 URL을 지정하고 method에 GET/POST등을 지정할 수 있다.
    //  
    //  test:
    //  http://localhost:8888/ex02/Test10.html

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public String m1() {
        return "ex02.Test10.m1()";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public String m2() {
        return "ex02.Test10.m2()";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
