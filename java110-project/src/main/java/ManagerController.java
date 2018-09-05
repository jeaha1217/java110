import java.util.Scanner;

public class ManagerController {
    
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    static Scanner keyIn;
    
    static class Manager extends Member{
        protected String tel;
        protected String position;
        
        public String getTel() {
            return tel;
        }
        public String getPosition() {
            return position;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    }
    
    static void serviceManagerMenu() {
        while(true) {
            System.out.print("매니져관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")) {
                printManager();
            }   else if(command.equals("add")) {
                inputManager();
            }   else if(command.equals("quit")){
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }   //  while
    }
    
    static void inputManager() {
        while (true) {
            Manager m = new Manager();
            
            System.out.print("이름? ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("직위? ");
            m.setPosition(keyIn.nextLine());
            
            System.out.print("전화번호? ");
            m.setTel(keyIn.nextLine());
            
            managers[managerIndex++] = m;
            
            System.out.print("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n"))
                break;
        }
    }
    
    static void printManager() {
        int count = 0;
        for(Manager m : managers) {
            if(count++ == managerIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %s\n",
                    m.getName(), m.getEmail(), m.getPassword(),
                    m.getPosition(), m.getTel());
        }
    }
}
