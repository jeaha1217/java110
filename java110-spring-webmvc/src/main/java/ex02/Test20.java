// Multipart/form-data 받기
package ex02;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ex02/test20")
public class Test20 {

    /*  
       test:
           http://localhost:8888/ex02/Test20.html
           
       주의!
           FrontController가 Multipart data를 처리하려면,
           
       방법1)
           DD file(web.xml)에 Front Controller를 선언할때 다음의 tag를 설정한다.
               <multipart-config>
                    <max-file-size>2000000</max-file-size>
               </multipart-config>
       
       방법2)
           Apache Common Fileupload를 이용하여 multipart data를 처리하는
           Spring 제공 객체를 추가해야한다.
        => multipartResolver 라는 이름으로 다음과 같이 객체를 등록한다.
            - 이 방식은 꼭! Apache commons-fileupload 의존 라이브러리를 추가해야한다.
        => XML 설정 :
           <bean id="multipartResolver" 
               class="org.springframework.web.multipart.commons.CommonsMultipartResolver"> 
           <property name="maxUploadSize" value="10000000" /> 
           </bean>
            --> "build.gradle"
       
       방법3) -> 은 다음시간에 배우도록 한다.
        => Java Config 설정 방법 : 예를 들면 AppConfig 클래스에 다음 메서드를 추가 할 수 있다.
                
                @Bean(name = "multipartResolver")
                public CommonsMultipartResolver multipartResolver() {
                
                    CommonsMultipartResolver multipartResolver =
                         new CommonsMultipartResolver();
                    multipartResolver.setMaxUploadSize(100000);
                    
                    return multipartResolver;
                }

    */
    
    @Autowired
    ServletContext sc;
    //  Spring과 java에서 나오는 태그가 겹치는게 있다면 자바 태그를 사용하길 권장함.
    
    @RequestMapping(value="m1", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String m1(
            String name,
            int age,
            MultipartFile[] files) throws Exception {
        
        System.out.printf("name=%s\n", name);
        System.out.printf("age=%d\n", age);
        
        for (MultipartFile f : files) {
            if(f.getSize() == 0) continue;
            //  먼저 거르는게 코드를 아낄 수 있음.
            
            String filename = UUID.randomUUID().toString();
            f.transferTo(new File(sc.getRealPath("/upload/" + filename)));
            System.out.printf("file=%s\n[%s]\n,",
                    filename, f.getOriginalFilename());
        }
        return "ex02.Test20.m1()\t작성 완료";
    }
    
}