// @RequestMapping 다루기 : URL다루기 II
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test09")
public class Test09 {

    //  공통 URL은 클래스에 선언한다.
    //  /는 있어도 되고 없어도 되고 알아서 해줌.
    //
    //  test:
    //  http://localhost:8888/app/ex02/test09/m1
    //  http://localhost:8888/app/ex02/test09/m2

    @RequestMapping("/m1")
    @ResponseBody
    public String m1() {
        return "ex02.Test09.m1()";
    }
    
    @RequestMapping("m2")
    @ResponseBody
    public String m2() {
        return "ex02.Test09.m2()";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
