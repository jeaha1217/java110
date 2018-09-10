package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    @RequestMapping("student/add")
    //  어? 웹의 주소구조와 같다..?
    public void add(Scanner keyIn) {
        while (true) {
            Student m = new Student();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력? ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직여부?(true/false) ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());
            
            App.students.add(m);
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    {   //  구조에 따라 어디에 붙냐에 따라 Static이였다가 Instance였다가.
        Student s = new Student();
        s.setName("a");
        App.students.add(s);
        
        s = new Student();
        s.setName("b");
        App.students.add(s);
        
        s = new Student();
        s.setName("c");
        App.students.add(s);
        
        s = new Student();
        s.setName("d");
        App.students.add(s);
        
        s = new Student();
        s.setName("e");
        App.students.add(s);
    }
}
