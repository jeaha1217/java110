package ex02;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//  @ControllerAdvice가 붙은 클래스는
//  front Controller가 request handler를 호출 할 때마다
//  매번 조언을 얻기 위해 annotation 역할에 따라 메서드를 실행한다.

@ControllerAdvice
public class GlobalControllerAdvice {
    //  Controller를 실행하는데 필요한 충고를 저장하는 클래스
    
    //  @InitBinder 조언
    //  => request handler를 호출 할 때 그 파라미터 값을 준비해야 하는데,
    //      그 값을 준비하는데 도움이 되는 메서드니까
    //      먼저 이 메서드를 호출하라는 의미이다.
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("GlobalControllerAdvice.initBinder");
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);   //  24시간 표기법을 사용할지 안할지의 여부
        
        binder.registerCustomEditor(
                Date.class, 
                new CustomDateEditor(format, true));
        //  Spring에서 제공하는 것을 써도 됨.
        
        binder.registerCustomEditor(
                Car.class,
                new CarPropertyEditor());
    }
}
