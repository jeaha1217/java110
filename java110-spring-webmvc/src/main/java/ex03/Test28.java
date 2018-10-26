// 세션 다루기 - @ModelAttribute Annotation과 SessionStatus 객체

package ex03;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/ex03/test28")
//  RequestHandler가 Model이나 Map객체에 저장하는 값 중에서
//  Session에도 저장할 때 다음 annotation을 사용한다..
@SessionAttributes({"name2","gender2"})
//@SessionAttributes({"name","gender","tel"})
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
        
        //  FrontController가 ServletRequest에 값 보관 + Session에도 값 보관,
        //  => @SessionAttributed에 지정된 이름이기 때문.
        model.addAttribute("name2", "EKEK");
        model.addAttribute("gender2", "female");
        
        //  FrontController가 ServletRequest에 값 보관.
        //  => @SessionAttributes에 지정된 이름이 아니기 때문이다.
        model.addAttribute("tel2", "01089023430");
        
        //  PageController가 직접 Session에 보관.
        session.setAttribute("age2", "18");
        
        return "ex03.Test28.m1()";
    }
    
    @GetMapping(value="m2", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2(
            /*  @SesseionAttributes에 지정된 값을 받고 싶을때
                Parameter 변수에 @ModelAttribute(이름) annotation을 붙여라.
                =>  값이 없으면 null이 아니라 빈 문자열을 넣어준다 (미묘하게 다르다.)
                (근데 이거 Spring 버젼마다 약간씩 차이가 있다고..)
              
                =>  @SessionAttributes에 나열된 이름일 경우,("name2")
                    - 세션에 값이 있을 경우, 그 값을 파라미터에 주입해 준다.
                    - 세션에 값이 없을 경우, 예외 발생.                  */
            @ModelAttribute("name2") String name2,
            @ModelAttribute("gender2") String gender2, 

            //  =>  만약 @SessionAttributes에 나열된 이름이 아닐 경우,
            //      - 세션에 값이 없을 경우, 빈 문자열을 주입해 준다.
            @ModelAttribute("tel2") String tel2, 
            
            //      - 세션에 값이 없을 경우, 빈 문자열을 주입해 준다.
            @ModelAttribute("age2") String age2)throws Exception {
        
        return String.format("%s, %s, %s, %s\n",
                        name2, tel2, gender2, age2);
        //  OMG..@ModelAttribute에 
        //  ModelAttribute사용법을 잘 익혀야 한다.
    }
    
    @GetMapping(value="m3", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m3(HttpSession session) throws Exception {
        //  직접 섹션 객체를 꺼낸다.
        String name2 = (String) session.getAttribute("name2");
        String tel2 = (String) session.getAttribute("tel2");
        String gender2 = (String) session.getAttribute("gender2");
        String age2 = (String) session.getAttribute("age2");
        
        return String.format("%s, %s, %s, %s\n",
                        name2, tel2, gender2, age2);
    }
    
    //  27m1에서 28m5로 출력??
    @GetMapping(value="m4", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m4(
            //  다른 PageController의 @SesseionAttributes에서
            //  지정한 값을 때?
            //  =>  안된다.
            //  현재 PageController에서 지정한 이름의 값만 꺼낼 수 있다.
            @ModelAttribute("name") String name2,
            @ModelAttribute("tel") String tel2, 
            @ModelAttribute("gender") String gender2) { 
        
        return String.format("%s, %s, %s\n",
                        name2, tel2, gender2 );
    }
    
    @GetMapping(value="m5", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m5(HttpSession session) throws Exception {
        //  다른 PageController의 @SesseionAttributes에서
        //  지정한 값을 HttpSession 객체에서 직접 꺼낼 때?
        //  =>  꺼낼 수 있다.
        String name = (String) session.getAttribute("name2");
        String tel = (String) session.getAttribute("tel");
        String gender = (String) session.getAttribute("gender");
        
        return String.format("%s, %s, %s\n",
                        name, tel, gender);
    }
    
    @GetMapping(value="m6", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m6(Model model) throws Exception {
        
        return "es03.Test28.m6()";
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
        
        //  현재 이 RequestHandler가 소속되어 있는 페이지 컨트롤러에서
        //  @SessionAttributes에 지정된 값만 HttpSession에서 제거한다.
        //  즉, name2, gender2만 제거된다.
        //  => Test27 페이지 컨트롤러에서 관리되는 name, gender는 아니다.
        //  => 기존의 HttpSession객체는 계속 유효하다.
        //  => HttpSession 객체에 직접 저장한 값도 계속 유효하다.
        status.setComplete();
        
        return String.format("@SessionAttributes의 관리 대상을 제거!\n");
    }
}
/*
logout1 
m3
m1
m2
m3
logout2
m3
SessionAttribute에서 지정한것만 날아감.
Complete? Invalidate와 용도가 전혀 다르다!

27-m2
28-m3
*/
/*  HttpSession vs SessionAttributes
    =>  세션에 값을 저장할 때,
        모든 PageController에서 사용할 값이라면 HttpSession 객체에 직접 저장하라!
        특정 PageController에서만 사용하고 관리될 값이라면 @SessionAttributed로 등록하라!
    
    =>  값 제거
        HttpSession.invalidat()는 세션을 완전히 무효화 시킨다.
        SessionStatus.setComplete()은 해당 PageController의
        @SessionAttribute에 지정된 값만 세션 객체에서 제거한다.
        setComplete()은 세션을 무효화 시키지 않는다.
        "PageController가 작업을 수행하기 위해 잠시 세션을 이용했는데,
         작업이 완료되어서 세션에 잠시 보관된 값들을 제거하고 싶다!"
        라는 의미다.
    
    Test27, Test28 존나 잘 기억해 둬라.
*/
