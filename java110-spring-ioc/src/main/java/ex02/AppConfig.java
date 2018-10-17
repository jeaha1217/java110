package ex02;

import org.springframework.context.annotation.Bean;

public class AppConfig {
    
    public AppConfig() {
        System.out.println("Call AppConfig()");
    }
    
    @Bean	//	<== Bean Container에게 이 메서드를 호출해서 리턴 값을 보관하라는 명령
    public Car getCar() {
        System.out.println("Call getCar()");
        Car c = new Car();
        c.setModel("Sonata");
        c.setCc(1998);
        c.setMaker("HD");
        return c;
    }
}
