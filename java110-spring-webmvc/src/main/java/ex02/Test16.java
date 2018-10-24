// global custom property editor
package ex02;

import java.util.Date;
//  Spring Update로 sqlDate는 인식해서 바꿈.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test16")
public class Test16 {

    /*  모든 페이지 컨트롤러가 사용할 커스텀 프로퍼티 에디터는
        @ControllerAdvice annotation이 붙은 클래스에
        @InitBinder(가 붙은) method를 등록하라.
        
        =>  이 방법의 문제점은 커스텀 프로퍼티 에디터가 필요하지 않은 페이지 컨트롤러에 대해서도
            매번 @InitBinder method를 호출한다는것.
        
         
    //  test:
    //  http://localhost:8888/app/ex02/test16/m1
    //  http://localhost:8888/app/ex02/test16/m1?name=A6
    //  http://localhost:8888/app/ex02/test16/m1?name=A6&day=2018-10-24

    */
    @RequestMapping("m1")
    public String m1(
            String name,
            Date day, 
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("day", day);
        return "/ex02/Test15.jsp";
    }
    
    @RequestMapping("m2")
    public String m2(
            @RequestParam("car") Car car,
            Model model) {
        
        model.addAttribute("car", car);
        
        return "/ex02/Test15-2.jsp";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
