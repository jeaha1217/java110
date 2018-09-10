package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
//  일반주석.
//@Component(value="4")
@Component("HELL")
public class HelloController{

    @RequestMapping
    public void HELL(Scanner keyIn) {
        System.out.println("HELL");
    }

}
