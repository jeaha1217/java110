// Request Handler의 파라미터 II
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test13")
public class Test13 {

    //  클라이언트가 보낸 파라미터 값을 메소드의 파라미터로 받기
    //  
    //  test:
    //  http://localhost:8888/app/ex02/test13/m1?name=JEJE&age=20&tel=1111
    //  http://localhost:8888/app/ex02/test13/m2?name=JEJE&age=20
    //  http://localhost:8888/app/ex02/test13/m3
    //  http://localhost:8888/app/ex02/test13/m4?name=bbb&age=12
    //  http://localhost:8888/app/ex02/test13/m5?name=xxx&age=777

    //  @RequestParam으로 파라미터로 받을 클라이언트 값을 지정한다
    //  기본은 필수이다. 따라서 값이 없으면(지정하지 않으면) 예외 발생.
    @RequestMapping("m1")
    public String m1(
            @RequestParam(name="name") String name, //  name과 value는 같다.
            @RequestParam(value="age") int age,
            @RequestParam(value="tel") String tel,
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("tel", tel);
        return "/ex02/Test13.jsp";
    }
    
    //  값을 받는 것을 선택사랑으로 만들고 싶다면
    //  required 속성을 false로 지정.
    //  주의 
    //  parameterType이 String이 아닌경우, null을 다른 타입으로 바꿀수 없기 때문에
    //  오류가 발생한다.
    @RequestMapping("m2")
    public String m2(
            @RequestParam(name="name", required=false) String name, // name과 value는 같다.
            @RequestParam(value="age", required=false) int age,
            @RequestParam(value="tel", required=false) String tel,
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("tel", tel);
        return "/ex02/Test13.jsp";
    }
    
    //  값을 생략했을 때 기본 값을 갖게 하고 싶다면 defaultValue 속성을 지정하라.
    @RequestMapping("m3")
    public String m3(
            @RequestParam(name="name", required=false) String name,
            @RequestParam(value="age", defaultValue="20") int age,
            @RequestParam(value="tel", required=false) String tel,
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("tel", tel);
        return "/ex02/Test13.jsp";
    }
    
    //  메서드의 파라미터 이름과 클라이언트가 보낸 이름이 일치할 때는 
    //  @RequestParam에서 이름을 지정할 필요가 없다.
    @RequestMapping("m4")
    public String m4(
            @RequestParam(required=false) String name,
            @RequestParam(defaultValue="20") int age,
            @RequestParam(required=false) String tel,
            Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("tel", tel);
        return "/ex02/Test13.jsp";
    }
    
    //  @RequestParam을 생략하면 다음을 선언한 것과 샅다.
    //      @RequestParam(value="변수명", required=false)
    @RequestMapping("m5")
    public String m5(
                String name,
                int age,
                String tel,
                Model model) {
        
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("tel", tel);
        return "/ex02/Test13.jsp";
    }
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
