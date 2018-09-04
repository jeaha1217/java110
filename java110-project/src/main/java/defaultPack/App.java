package defaultPack;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        //  키보드 입력을 처리할 객체 준비.
        Scanner keyIn = new Scanner(System.in);
        
        //  회원 정보 입력 받기.
        System.out.print("Name?");
        String name = keyIn.nextLine();
        
        System.out.print("email?");
        String email = keyIn.nextLine();
        
        System.out.print("PWD?");
        String password = keyIn.nextLine();
        
        System.out.printf("%s, %s, %s \n", name, email, password);
    }
}
