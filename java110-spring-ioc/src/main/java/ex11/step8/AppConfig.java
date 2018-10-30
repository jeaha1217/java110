package ex11.step8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="ex11.step8")
@EnableAspectJAutoProxy
public class AppConfig {
    /*  XML설정보다 Annotation 설정이 훨_씬 편하다.
     * 
     */
}
