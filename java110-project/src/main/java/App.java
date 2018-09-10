import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
    /*  남이 짠 코드에 쫄지 말라.
        객체 지향 잘 하는 방법, 짜여진 코드가 무슨일을 하는지 이해를 먼저 하라.
        
    */
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.java110.cms.control");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        //  IoC컨테이너에 보관된 객체의 이름 목록을 가져온다.
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            // => 이름으로 객체를 꺼낸다.
            Object obj = iocContainer.getBean(name);
            
            //  =>  객체에서 @RequestMapping이 붙은 메서드를 찯아 저장한다.
            requestHandlerMap.addMapping(obj);
        }
        
        while (true) {
            String menu = prompt();
            if (menu.equals("exit")){
                System.out.println("Bye!");
                break;
            }
            
            RequestMappingHandler mapping = requestHandlerMap.getMapping(menu);
            if(mapping == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
//            Method method = mapping.getMethod();
//            method.invoke(mapping.getInstance(), keyIn);
            
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
            //  한줄로 간단하게 만드는것에 익숙해지자.
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("\n메뉴> ");
        String menu = keyIn.nextLine();
        return menu;
        
    }
}