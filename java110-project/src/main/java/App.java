import java.util.Scanner;

public class App {
    static Scanner keyIn = new Scanner(System.in);
    
    private static String promptMenu() {
        //  사용자로부터 메뉴를 입력 받기
        System.out.println("MENU");
        System.out.println("1. 학생 관리");
        System.out.println("2. 강사 관리");
        System.out.println("3. 매니져 관리");
        System.out.println("0. 종료");
        
        while(true) {
            System.out.print("메뉴 번호> ");
            
            String menu = keyIn.nextLine();
            
            switch(menu) {
            case "1" : 
            case "2" : 
            case "3" :
            case "0" :
                return menu;
            default :
                System.out.println("명령이 유효하지 않습니다.");
            }
        }
    }
    
    public static void main(String[] args) {
        StudentController.keyIn = keyIn;
        TeacherController.keyIn = keyIn;
        ManagerController.keyIn = keyIn;
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                StudentController.serviceStudentMenu();
            }   else if(menu.equals("2")){
                TeacherController.serviceTeacherMenu();
            }   else if(menu.equals("3")) {
                ManagerController.serviceManagerMenu();
            }   else if(menu.equals("0")){
                System.out.println("Bye!");
                break;
            }
        }
        
        keyIn.close();
        
    }
}








