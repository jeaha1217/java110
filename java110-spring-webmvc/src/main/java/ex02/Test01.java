// RequestHandler에서 직접 콘텐트 출력하기
package ex02;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01 {

    @RequestMapping("/ex02/test01/m1")
    @ResponseBody
    public String m1() {
        //  리턴 값을 콘텐트로 보낼 때 메서드 선언부에 @REsponseBody를 붙인다.
        //  기본 콘텐트 타입이 "text/plain;charset=ISO-8859-1"임.
        //  therefore 한글 출력할때 ?로 출력됨.
        return "Muse - MK Ultra. 아메!!";
    }

    @RequestMapping(value="/ex02/test01/m2", 
            produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m2() {
        //  한글 깨지지 않도록 RequestMapping에 정보 등록.

        return "Muse - MK Ultra. 아메!!";
    }

    @RequestMapping("/ex02/test01/m3")
    @ResponseBody
    public HttpEntity<String> m3() {
        //  return 타입이 HttpEntity인 경우
        //  프론트 컨트롤러는 리턴값이 콘텐트인것으로 간주한다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        HttpEntity<String> entity =
                new HttpEntity<>("Muse - MK Ultra. 내귀에 도청장치!?", headers);
        return entity;
    }
    
    @RequestMapping("/ex02/test01/m4")
    @ResponseBody
    public ResponseEntity<String> m4() {
        //  return 타입이 ResponseEntity인 경우
        //  프론트 컨트롤러는 리턴값이 콘텐트인것으로 간주한다.
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain;charset=UTF-8");
        
        ResponseEntity<String> entity =
                new ResponseEntity<>("Muse - MK Ultra. 아메?!",
                                    headers,
                                    HttpStatus.OK);
        return entity;
    }
}
