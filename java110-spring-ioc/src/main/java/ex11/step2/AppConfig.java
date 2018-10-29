package ex11.step2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ex11.step02")
public class AppConfig {
    
    //  IoC container가 관리하는 객체라면 다음과 같이
    //  파라미터로 달라고 요청하면 IoC container가 method를 호출할 때
    //  념겨줄 것임..
    
    @Bean
    public Service service(Dao1 dao1, Dao2 dao2, Dao3 dao3) {
        ServiceImpl worker = new ServiceImpl();
        worker.dao1 = dao1;
        worker.dao2 = dao2;
        worker.dao3 = dao3;
        
        return new ServiceProxy(worker);
    }
}