//  Spring WebMVC 설정을 다루는 클래스
package bitcamp.java110.cms.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bitcamp.java110.cms.web.interceptor.AuthInterceptor;

//  이 클래스가 IoC container가 사용해야 할 설정 정보를 담고 있는 클래스임을
//  frontController에게 알려주기 위해서는 다음 annotation을 반드시 붙여야 한다.
@Configuration
//  다음 annotation은 <mvc:annodation-driven/> 설정과 같은 의미이다.
//  MVC 관련 설정을 활성화시킨다.
@EnableWebMvc
public class WebConfig
    //  만약 MVC 설정을 좀 더 세밀하게 제어하고 싶다면 다음 인터페이스를 구현하라.
    implements WebMvcConfigurer {
    
    public WebConfig() {
        System.out.println("WebConfig has Called!!");
    }
    //  interface의 모든 method를 당장 구현할 필요가 없음.
    //  설정하고 싶은 메소드만 찾아서 구현하면 됨.
    
    //  interceptor를 설정하고 싶다면
    //  => 이 메소드를 frontController가 호출, interCeptor를 관리할 걸임.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 추가하고싶은 인터셉터 등록기 (registry)에 추가하라.
        registry.addInterceptor(new AuthInterceptor())
            .addPathPatterns("/**/add", "/**/delete");
    }
}
