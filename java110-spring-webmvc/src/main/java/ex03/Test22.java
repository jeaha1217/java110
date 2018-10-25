// @RestController - JSON 문자열 자동 출력
package ex03;

import java.sql.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ex02.Car;
import ex02.Engine;
import ex02.Tire;

@RestController  //= @Controller + @ResponseBody JSON으로 출력함.
@RequestMapping("/ex03/test22")
public class Test22 {

    /*  
        PageController에 @Restcontroller를 붙이면
        FrontController는 Request Handler의 return값을 client로 바로 출력한다.
        
        이때,
        1)  return type이 String, Primitive 일 경우,
            => 문자열로 변환한 후 출력한다.
        
        2)  return type이 기타 Object인 경우,
            =? return 한 obj의 값을 JSON형식의 String으로 변환한후 출력한다.
        
        
        실행 원리.
            1)  HttpMessageConverter 규칙에 따라 만든 클래스를 찾는다.
                =>  "Http Message"는 Client로 부터 받은 data,
                    Client로 보내는 data를 가리킨다.
            
            2)  만약 HttpmessageConverter 구현체를 못 찾았다면?
                return 값을 바꿀 수 없기 때문에 실행 오류가 발생한다!
                (이 클래스에서 Gson lib의 역할)
        
        HttpMessageConverter 구현체는 어떻게 추가하는가?
        =>  SpringFrameWork는 기본 data Converter로 다음 두 개의 클래스를 사용한다.
                     MappingJackson2HttpMessageConverter
                     GsonHttpMessageConverter
        
        =>  MappingJackson2HttpMessageConverter는 다음 lib에 들어있다.
            
            "Jackson-databind" lib
        
        =>  GsonHttpMessageConverter는 다음 lib에 들어있다.
            
            "google-gson" lib
            
        =>  따라서 @Restcontroller를 사용하려면 위의 두 개의 lib 중 하나는   
            
       test:
           http://localhost:8888/app/ex03/test22/m2
           http://localhost:8888/ex02/Test22.html
        
        SpringFrameWork 4 이상부터 이용가능한 예제들.
    */

    //  출력하는 데이터가 application/json 이라고 FrontController에게 알려주면,
    //  FrontController는 return 객체를 JSON 변환기를 이용하여 변환한 후
    //  Client로 출력한다.
    //  
    @RequestMapping(value="m1", produces="application/json;charset=UTF-8")
    public Car m1() throws Exception {
        
        Car car = new Car();
        car.setModel("A6");
        car.setMaker("AUDI");
        car.setAuto(true);
        car.setCreatedDate(Date.valueOf("2018-10-25"));
        
        car.setEngine(new Engine ("bitEngine", 9000, 32));
        car.setMusics(new String [] {"Moderat","Flume", "Deadmau5"});
        
        car.setTires(new Tire[]{
                new Tire("bitTire", 65),
                new Tire("bitTire", 65),
                new Tire("bitTire", 65),
                new Tire("bitTire", 65)
        });
        return car;
    }
    
    /*  produces의 값을 text/plain으로 설정하면,
        FrontController는 return값을 JSON으로 바꾸지 않고,
        그대로 출력한다. 
     */
    @RequestMapping(value="m2", produces="text/plain;charset=UTF-8")
    public String m2() throws Exception {
        
        return "ex03.Test22.m2()";
    }
    
    
    /*  produces 속성에 어떤 content를 return 할지 그 차입을 지정하지 않는다면,
        FrontController는 request handler의 return type에 따라
        어떻게 처리할 지 결정한다.
        String 이라면 그대로 출력하고,
        다른 타입이라면 JSON data로 변경하여 출력한다.
        
        실무에서,
        @RestController tag를 붙인 class에서
        특별한 경우 아니면 produces를 사용하지 않는다.
        
     */
    @RequestMapping("m3")
    public Car m3() throws Exception {
        
        Car car = new Car();
        car.setModel("A4");
        car.setMaker("AUDI");
        car.setAuto(true);
        car.setCreatedDate(Date.valueOf("2018-10-25"));
        
        car.setEngine(new Engine ("bitEngine", 9000, 32));
        car.setMusics(new String [] {"Moderat","Flume", "Deadmau5"});
        
        car.setTires(new Tire[]{
                new Tire("bitTire", 65),
                new Tire("bitTire", 65),
                new Tire("bitTire", 65),
                new Tire("bitTire", 65)
        });
        return car;
    }
    
    //  @RestController일 경우 Return type이 String이라면 그대로 출력한다. 
    
    @RequestMapping("m4")
    public String m4() throws Exception {
        
        return "ex02.Test22.m4()";
    }
    //  @RestController일 경우 Return type이 Primitive type이 라면
    //  문자열로 변환하여 출력한다.
    @RequestMapping("m5")
    public int m5() throws Exception {
        
        return 10000;
    }
    
    @RequestMapping(value="mx", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String mx() throws Exception {
        
        return "될리 있나";
    }
    
    
}