// 세션 다루기 - @SessionAttributes Annotation

package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/ex03/test27")
/* RequestHandler가 Model이나 Map객체에 저장하는 값 중에서
 * Session에도 저장할 때 다음 annotation을 사용한다..
 */
//@SessionAttributes({"name","gender","tel"})
@SessionAttributes({"name","tel"})
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
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        session.invalidate();
        
        return String.format("Session 무효화!\n");
    }
}