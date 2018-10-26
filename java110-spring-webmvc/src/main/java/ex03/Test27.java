// 세션 다루기 - @SessionAttributes Annotation

package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/ex03/test27")
//  RequestHandler가 Model이나 Map 객체에 저장하는 값 중에서
//  Session에도 저장할 때 다음 annotation을 사용한다..
@SessionAttributes({"name","gender"})
//@SessionAttributes({"name","gender","tel"})
//@SessionAttributes(value="name")
public class Test27 {
    /* test:
           http://localhost:8888/app/ex03/test27/m1
           http://localhost:8888/app/ex03/test27/m2
           http://localhost:8888/app/ex03/test27/m3
     */
    @GetMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(Model model) throws Exception {
        model.addAttribute("name", "JEJE");
        model.addAttribute("tel", "01010203430");
        model.addAttribute("gender", "male");
        
        return "ex03.Test27.m1()";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(HttpSession session) throws Exception {
        String name = (String) session.getAttribute("name");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s, %s, %s\n",
                        name, tel, gender);
    }
    
    @GetMapping(value="logout1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout1(HttpSession session) throws Exception {
        session.invalidate();
        
        return String.format("Session 무효화!\n");
    }
    
    @GetMapping(value="logout2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String logout2(SessionStatus status) throws Exception {
        
        //  현재 이 RequestHandler가 소속되어 있는 PageController에서
        //  @SessionAttributes에 지정된 값만 HttpSession에서 제거한다.
        //  => 즉, name, gender만 제거된다.
        //  => Test28 페이지 컨트롤러에서
        //      관리되는 name2, gender2는 제거 대상이 아니다.
        //  => 기존의 HttpSession 객체는 계속 유효하다.
        //  => HttpSession 객체에 직접 저장한 값도 계속 유효하다.
        status.setComplete();
        
        return String.format("@SessionAttributes의 관리 대상을 제거!\n");
    }
}