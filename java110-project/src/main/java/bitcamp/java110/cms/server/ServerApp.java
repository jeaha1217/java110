package bitcamp.java110.cms.server;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.java110.cms.context.RequestMappingHandlerMapping;
import bitcamp.java110.cms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ServerApp {
    ClassPathXmlApplicationContext iocContainer;
    RequestMappingHandlerMapping requestHandlerMap;

    public ServerApp() throws Exception{
        createIocContainer();
        logBeansOfContainer();
        processRequestMappingAnnotation();
    }

    private void createIocContainer() {
        iocContainer = 
                new ClassPathXmlApplicationContext
                ("bitcamp/java110/cms/conf/application-context.xml");
}

private void processRequestMappingAnnotation() {
    requestHandlerMap = 
            new RequestMappingHandlerMapping();

    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
        Object obj = iocContainer.getBean(name);

        requestHandlerMap.addMapping(obj);
    }
}

private void logBeansOfContainer() {
    System.out.println("--------------------------");
    String[] namelist = iocContainer.getBeanDefinitionNames(); 
    for(String name : namelist) {
        System.out.println(name);
    }
    System.out.println("--------------------------");
}

public void service()throws Exception{

    ServerSocket serverSocket = new ServerSocket(8888);
    System.out.println("Server is running now...");
    while(true) {
        Socket socket = serverSocket.accept();
        System.out.println("Connection");
        RequestWorker worker = new RequestWorker(socket);
        new Thread(worker).start(); //  호...

    }

}

public static void main(String[] args) throws Exception {
    ServerApp serverApp = new ServerApp();
    serverApp.service();

}

class RequestWorker implements Runnable {

    Socket socket;

    public RequestWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run(){
        //  이 메서드에 "main" 스레드에서 분리하여 독립적으로 수행할 코드를 둔다.
        try(
                Socket socket = this.socket;
                //  인스턴스 변수 socket을 autoclose하기 위해.
                
                PrintWriter out = new PrintWriter(
                        new BufferedOutputStream(
                                socket.getOutputStream()));
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                ){
            String requestLine = in.readLine();
            //  요청 객체 준비.
            Request request = new Request(requestLine);

            //  응답 객체 준비.
            Response response = new Response(out);

            RequestMappingHandler mapping =
                    requestHandlerMap.getMapping(request.getAppPath());
            if (mapping == null) {
                out.println("해당 요청을 처리할 수 없습니다.");
                out.println();
                out.flush();
                return;
            }

            try {

                //  요청 핸들러 호출.
                mapping.getMethod().invoke(
                        mapping.getInstance(), request, response);
              //mapping.getInstance() : method 주소를 줌.  만약 static일때는 null;
            } catch (Exception e) {
                System.out.println(e.getCause());
                e.printStackTrace();
                out.println("요청 처리중 오류가 발생했습니다!");
            }
            out.println();
            out.flush();
        }   catch(Exception e) {
            System.out.println(e.getMessage());
        }   finally {
            System.out.println("Response");
            System.out.println("Connection Closed");
            
        }
    }   //  run()
}   //  Request class 
}   //  ServerApp
