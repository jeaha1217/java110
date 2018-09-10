package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    @RequestMapping("manager/insert")
    public void insert(Scanner keyIn) {
        while (true) {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            if(App.managerDao.insert(m) > 0) {
                System.out.println("저장하였습니다.");
            }   else {
                System.out.println("같은 이메일의 매니져가 존재합니다.");
            }
            
            System.out.print("\n계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    {
        Manager m = new Manager();
        m.setName("q");
        m.setEmail("qManager@asdf.com");
        App.managerDao.insert(m);
        
        m = new Manager();
        m.setName("w");
        m.setEmail("wManager@asdf.com");
        App.managerDao.insert(m);
    }
}
