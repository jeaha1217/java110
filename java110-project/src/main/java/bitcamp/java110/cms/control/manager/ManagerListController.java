package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerListController {
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        for (int i = 0; i < App.managers.size(); i++) {
            Manager m = App.managers.get(i);
            System.out.printf("%d: %s, %s, %s, %s, %s\n", 
                    i,
                    m.getName(), 
                    m.getEmail(), 
                    m.getPassword(), 
                    m.getTel(),
                    m.getPosition());
        }
    }
}
