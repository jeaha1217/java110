// @RequestMapping 다루기 : URL다루기 IV
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex02/test11")
public class Test11 {

    //  클래스에 URL을 지정했다 했으면, method에도 @RequestMapping을 붙여야 한다.
    //  
    //  test:
    //  http://localhost:8888/app/ex02/test11

    @RequestMapping
    @ResponseBody
    public String m1() {
        return "ex02.Test11";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
