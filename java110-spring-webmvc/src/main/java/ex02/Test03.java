// @RequestMapping 다루기 : GET/POST 구분하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test03 {
    //  태스트 방법 localhost:8888
    //  /ex02/Test03.html을 실행하여 테스트한다.

    //  GET 요청만 처리하기
    @RequestMapping(value="/ex02/test03/m1",
            method=RequestMethod.GET,
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1_1() {
        return "HEll the get ㅎㅇ";
    }

    //  POST 요청만 처리하기
    @RequestMapping(value="/ex02/test03/m1",
            method=RequestMethod.POST,
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1_2() {
        return "HEll the post ㅎㅇㅎㅇ";
    }
    
    //  GET/POST모두 처리하기
    @RequestMapping(value="/ex02/test03/m2",
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        return "HEll the everybody ㅎㅇㅎㅇ";
    }
}
