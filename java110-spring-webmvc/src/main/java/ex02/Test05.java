// @RequestMapping 다루기 : Http요청 파라미터로 메서드 구분하기.
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test05 {

    //  특정 이름의 요청 헤더를 포함하고 있을 때만 호출 되도록 한다.
    //  test:
    //  http://localhost:8888/ex02/Test05.html

    @RequestMapping(value="/ex02/test05",
            headers="name")
    @ResponseBody
    public String m1() {
        return "EX02.Test05.m1()!";
    }

    @RequestMapping(value="/ex02/test05",
            headers= "age")
    @ResponseBody
    public String m2() {
        return "EX02.Test05.m2()!";
    }
    
    @RequestMapping(value="/ex02/test05",
            headers= {"name","age"})
    @ResponseBody
    public String m3() {
        return "EX02.Test05.m3()!";
    }
    
    @RequestMapping(value="/ex02/test05")
    @ResponseBody
    public String m4() {
        return "EX02.Test05.m4()!";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!