import java.util.Scanner;

public class TeacherController {
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    static Scanner keyIn;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;
        
        public String getTel() {
            return tel;
        }
        public int getPay() {
            return pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }
    
    static void serviceTeacherMenu() {
        while(true) {
            System.out.print("강사관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printTeacher();
            }   else if(command.equals("add")) {
                inputTeacher();
            }   else if(command.equals("quit")){
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    static void inputTeacher() {
        while (true) {
            Teacher t = new Teacher();
            
            System.out.print("이름? ");
            t.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            t.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            t.setPassword(keyIn.nextLine());
            
            System.out.print("전화번호? ");
            t.setTel(keyIn.nextLine());
            
            System.out.print("급여? ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의 과목?(예: JAVA, C++) ");
            t.setSubjects(keyIn.nextLine());
            
            teachers[teacherIndex++] = t;
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    static void printTeacher() {
        int count = 0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(), s.getEmail(), s.getPassword(),
                    s.getTel(), s.getPay(), s.getSubjects());
        }
    }
}
