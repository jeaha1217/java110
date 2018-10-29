package ex11.step2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//  원래의 객체를 IoC Container에 등록하지 않고,
//  Proxy class으 기개체를 등록할 것이다.
//@Component
public class ServiceImpl implements Service{
     
    @Autowired Dao1 dao1;
    @Autowired Dao2 dao2;
    @Autowired Dao3 dao3;
    
    @Override
    public void add() {
        // 메서드가 호출되기 전/후에 실행될 코드는 
        // 다음과 같이 직접 삽입해야 한다.
        
        dao1.insert();
        dao2.insert();
        dao2.insert();
    }
}