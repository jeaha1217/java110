//  Request Handler의 파라미터 IV - custom property editor
//  CustomPropertyEditor - PageController에 CustomPropertyEditor 장착하기.
package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;
//  Spring Update로 sqlDate는 인식해서 바꿈.

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex02/test15")
public class Test15 {

    /*  프론트 컨트롤러가 페이지 컨트롤러의 메소드를 호출할때 
        클라이언트가 보낸 데이터를 메서드의 파라미터 타입에 맞춰서
        변환하여 전달한다.
        즉 String 을 자동으로 primitive 타입으로 변환해 준다.
        만약 method의 타입이 primitive 타입이 아닌경우 
        실행 오류를 발생시킨다.
    
        test:
        http://localhost:8888/app/ex02/test15/m1
        http://localhost:8888/app/ex02/test15/m1?name=A6
        http://localhost:8888/app/ex02/test15/m1?name=A6&day=2018-10-24

malformed request syntax, invalid request message framing, or deceptive request routing
        뭐가 문제인지 구체적으로 알려주지 않음.
        해결책?
            => 클라이언트가 보낸 String 타입의 데이터를 메서드의 파라미터 타입으로 변환 시키는
            custom property editor 를 추가한다.
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
    
    //  http://localhost:8888/app/ex02/test15/m2?car=A6,Audi,true
    @RequestMapping("m2")
    public String m2(
            //  primitive type, String, java.util.Date, java.sql.Date
            //  타입이 아닌경우 파라미터 변수 앞에 @RequestParam을 붙여야 한다.
            //  즉, 클라이언트가 보낸 데이터가 어떤 것 인지 명시해야 한다.
            @RequestParam("car") Car car, Model model) {
        
        model.addAttribute("car", car);
        return "/ex02/Test15-2.jsp";
    }
    
    
    
    //  =>  프론트 컨트롤러가 request handler를 호출하기 전에
    //      클라이언트가 보낸 데이터를 request handler의 파라미터 타입으로 바꾼다.
    //  =>  프론트 컨츠롤러가 데이터 타입을 바꿀 때 WebDataBinder를 통해 설정된
    //      도구를 사용한다.
    //  =>  @InitBinder는 프론트 컨트롤러가 WebDataBinder를 사용하기 전에
    //      이 애노테이션이 지정된 메소드를 호출하여, 먼저 초기화 시킨 다음에
    //      사용할 것을 요구하는 애노테이션임.
    //  =>  클라이언트가 보낸 데이터를 request handler긔 각 파라미터 값으로 바꾸기 전에\
    //      이 메서드를 호출할 것임.
    //      큭 파라미터 개수만큼 호출한다.
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("오호라...");
        
        //  yyyy-MM-dd 형식으로 클라이언트가 보낸 분자열을
        //  java.util.Date 객체로 바꿔주는 도구
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //  시분 초 까지 하려면 어떻게해?
        format.setLenient(true);
        
        //  String ===> java.util.Date 변환기 등록 
        binder.registerCustomEditor(
                Date.class, 
//                new DatePropertyEditor(format)    //  직접 만들어 써도 되고,
                new CustomDateEditor(format, true)  
                //  Spring에서 제공하는거 써도 되고....
                );
        
        //  String ===> ex02.Car 변환기 등록 
        binder.registerCustomEditor(
                Car.class,
                new CarPropertyEditor());
    }
    //  어렵다 싶은건 코드로 보지말고 사람으로 봐라.
    //  복잡하게 개발하면 확장성이 올라간다.
    //  간단하게 만들면 확장성이 떨어진다.
    //  복붙을 해도 이해는 하고 하는게 낫다.
}
//  요즘 세대 개발자들은 HTTP를 정교하게 다룰줄 알아야 함!
