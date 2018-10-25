// InternalResourceViewResolver 사용하기
//  (JSP 연동)
package ex03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex03/test23")
public class Test23 {

    /*  
       test:
           http://localhost:8888/app/ex03/test23/m1
        
        SpringFrameWork 4 이상부터 이용가능한 예제들.
    */

     
    @RequestMapping("m1")
    public String m1(Model model) throws Exception {
        
        //  다음 Data를 DBMS에서 가져왔다고 가정하자.
        Car car = new Car();
        car.setModel("DB9");
        car.setMaker("AustinMartin");
        car.setAuto(true);
        
        //  JSP가 사용할 수 있도록 Model 객체에 저장하자.
        //  =>  FrontController는 Model객체에 저장된 값을 ServletRequest 보관소로 옮긴다.
        model.addAttribute("car", car);
        
        //  다음과 같이 jsp파일을 웹 브라우져에서 요청할 수 있는 폴더에 두게 되면,
        //  페이지 컨트롤러를 경유하지 않고 실행 될 수 있기 때문에,
        //  (물론 아무런 의미가 없겠지만)
        //  이것을 방지하기 위해 보통 jsp파일을 WEB-INF 폴더 아래에 둔다.
//          return "/ex03/Test23.jsp";
        
        //  문제는 WEB-INF 폴더 아래에 JSP 파일을 두게 되면,
        //  다음과 같이 return url작성하는데 너무 길어서 번거롭다.
//        return "/WEB-INF/jsp/ex03/Test23.jsp";
        
        //  이를 해결하기 위해 InternalResourceViewResolver를 사용한다.
        //  공통 경로는 InternalResourceViewResolver에 등록해 두고,
        //  RequestHandler에서는 공통 경로를 제외한 나머지 경로만 지정하기 때문에
        //  편_안.
        return "ex03/Test23";
        //  대소문자 구분을 잘. 좀. 해.
    }
    
    @RequestMapping("m2")
    public void m2(Model model) throws Exception {
        
        //  다음 Data를 DBms에서 가져왔다고 가정.
        Car car = new Car();
        car.setModel("DB9");
        car.setMaker("AustinMartin");
        car.setAuto(true);
        
        //  JSP가 사용할 수 있도록 model 객체에 저장하자.
        //  =>  FrontController는 Model객체에 저장된 값을 ServletRequest 보관소로 옮긴다.
        model.addAttribute("car", car);

        //  만약 request handler와 같은 경로의 jsp파일이 있다면 
        //  jsp url을 리턴하지 않아도 된다.
        //  즉 request handler가 값을 리턴하지 않으면,
        //  request handelr게 지정된 url로 jsp를 찾는다.
        //  예를 들어 이 request handler의 기본 jsp url은 다음과 같다.
        //  /WEB-INF/jsp/ex03/test23/m2.jsp
    }
}