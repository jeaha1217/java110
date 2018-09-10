package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
@Component("plus")
public class PlusController{
    
    @RequestMapping
    public void plus(Scanner keyIn) {
        System.out.print("a? ");
        int a = Integer.parseInt(keyIn.nextLine());
        
        System.out.print("b? ");
        int b = Integer.parseInt(keyIn.nextLine());
        
        System.out.printf("%d + %d = %d\n", a, b, a + b);
    }
}
