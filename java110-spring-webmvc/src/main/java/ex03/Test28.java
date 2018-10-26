// 세션 다루기 - @ModelAttribute Annotation

package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ex03/test28")
/* RequestHandler가 Model이나 Map객체에 저장하는 값 중에서
 * Session에도 저장할 때 다음 annotation을 사용한다..
 */
//@SessionAttributes({"name","gender","tel"})
@SessionAttributes({"name2","gender2"})
//@SessionAttributes(value="name")
public class Test28 {
    /* test:
           http://localhost:8888/app/ex03/test28/m1
           http://localhost:8888/app/ex03/test28/m2
           http://localhost:8888/app/ex03/test28/m3
     */
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model, HttpSession session) throws Exception {
        //  FrontController가 Session에 보관.
        model.addAttribute("name2", "JEJE");
        model.addAttribute("tel2", "01010203430");
        model.addAttribute("gender2", "male");
        
        //  PageController가 직접 저장했다?
        session.setAttribute("age2", "20");
        
        return "ex03.Test28.m1()";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            //  @SesseionAttributes에 지정된 값을 받고 싶을때
            //  Parameter 변수에 @ModelAttribute annotation을 붙여라.
            //  =>  이름을 명시 해야 한다.("name2")
            //  =>  Session객체에 직접 저장한 값은 받지 못한다.
            //  =>  값이 없으면 null이 아니라 빈 문자열을 넣어준다 (미묘하게 다르다.)
            //  SessionAttribute는 Session과 한쌍이다?
            //  근데 이거 Spring 버젼마다 약간씩 차이가 있다고..
            @ModelAttribute("name2") String name2,
            @ModelAttribute("tel2") String tel2, 
            @ModelAttribute("gender2") String gender2, 
            @ModelAttribute("age2") String age2) throws Exception {
        
        return String.format("%s, %s, %s, %s\n",
                        name2, tel2, gender2, age2);
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        session.invalidate();
        
        return String.format("Session 무효화!\n");
    }
    
    @GetMapping(value="m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(HttpSession session) throws Exception {
        String name2 = (String) session.getAttribute("name2");
        String tel2 = (String) session.getAttribute("tel2");
        String gender2 = (String) session.getAttribute("gender2");
        String age2 = (String) session.getAttribute("age2");
        
        return String.format("%s, %s, %s, %s\n",
                        name2, tel2, gender2, age2);
    }
    
    //  27m1에서 28m5로 출력??
    @GetMapping(value="m5", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m5(
            //  다른 PageController의 @SesseionAttributes에서 지정한 값을 때?
            //  =>  안된다.
            //  현재 PageController에서 지정한 이름의 값만 꺼낼 수 있다.
            @ModelAttribute("name") String name2,
            @ModelAttribute("tel") String tel2, 
            @ModelAttribute("gender") String gender2) { 
        
        return String.format("%s, %s, %s\n",
                        name2, tel2, gender2 );
    }
    
    @GetMapping(value="m6", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m6(HttpSession session) throws Exception {
        //  다른 PageController의 @SesseionAttributes에서
        //  지정한 값을 HttpSession 객체에서 직접 꺼낼 때?
        //  =>  꺼낼 수 있다.
        String name = (String) session.getAttribute("name2");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s, %s, %s\n",
                        name, tel, gender);
    }
}