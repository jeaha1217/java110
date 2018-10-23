// RequestHandler에서 직접 콘텐트 출력하기
package ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Test02 {

    @RequestMapping("/ex02/test02/m1")
    public String m1() {
        //  @ResponseBody annotation이 없으면 리턴 값은 JSP URL이다.
        //  프론트 컨트롤러틑 니 메서드가 리턴한 URL의 JSP를 실행한다.
        return "/ex02/Test02.jsp";
    }
    
    @RequestMapping("/ex02/test02/m2")
    public View m2() {
        //  JSP URL을 객체에 담아 리턴할 수 있다.
        return new JstlView("/ex02/Test02.jsp");
    }
    
    @RequestMapping("/ex02/test02/m3")
    public ModelAndView m3() {
        //  JSP URL을 객체에 담아 리턴할 수 있다.
        //  프론트 컨트롤러는 객체에 저장된값은 SErvletRequest 보관소로 옮긴다.
        //  JSP URL을 실행한다.
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "asdfㅇㅅㅇ");
        mv.addObject("age", 20);
        mv.setViewName("/ex02/Test02.jsp");
        return mv;
    }
    
    @RequestMapping("/ex02/test02/m4")
    public String m4() {
        //  Redirect하기/
        //  리턴하는 URL앞에 "redirect:"를 붙여라!
        return "redirect:../test01/m2";
    }
    
    @RequestMapping("/ex02/test02/m5")
    public View m5() {
        //  Redirect하기II
        //  객체에 리다이렉URL 정보를 담아서 리턴할 수 있다.
        return new RedirectView("redirect:../test01/m2");
    }
}
    //  void는 나중에