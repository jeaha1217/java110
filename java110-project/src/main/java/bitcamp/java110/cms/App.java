package bitcamp.java110.cms;
import java.util.Scanner;

import bitcamp.java110.cms.context.ApplicationContext;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class App {
    /*  
        
    */
    
    static Scanner keyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        
        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.java110.cms");
        
        RequestMappingHandlerMapping requestHandlerMap = 
                new RequestMappingHandlerMapping();
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            Object obj = iocContainer.getBean(name);
            
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
            
            mapping.getMethod().invoke(mapping.getInstance(), keyIn);
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("\n메뉴> ");
        String menu = keyIn.nextLine();
        return menu;
    }
}
/*
    
*/
