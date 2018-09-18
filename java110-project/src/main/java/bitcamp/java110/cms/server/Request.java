package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String, String> paramMap = new HashMap<>();
    
    public Request(String command) {
        this.command = command;
        
        //  명령어에서 QueryString을 분리한다.
        //  manager/detail?no=XX
        String[] values = command.split("\\?");
        this.appPath = values[0];               //  manager/detail
        if(values.length >= 2) {                 //  no=XX
            queryString = values[1];
            
            parseQueryString(queryString);
            
            System.out.println(queryString);
        }
    }
    
    public String getParameter(String name) {
        return this.paramMap.get(name);
    }

    private void parseQueryString(String qs) {
        String[] values = qs.split("&"); 
        
        for(String value : values) {
//            System.out.println(value);
            String[] kv = value.split("=");
            paramMap.put(kv[0], kv[1]);
        }
        
    }

    public String getCommand() {
        return this.command;
    }
    
    public String getAppPath() {
        return this.appPath;
    }
    
    public String getQueryString() {
        return this.queryString;
    }
    
    
    public static void main(String[] args) {
        String str = "manager/detail?no=10";
        
        Request req = new Request(str);
        
//        System.out.println(req.getParameter("name"));
//        System.out.println(req.getParameter("email"));
        
        
        System.out.println(req.getCommand());
        System.out.println(req.getAppPath());
        System.out.println(req.getQueryString());
        System.out.println(req.getParameter("no"));

        //  단위 테스트 하는것?
//        assertEquals(req.getCommand(), "manager/detailno=10");
//        assertEquals(req.getAppPath(), "manager/detail");
//        assertEquals(req.getQueryString(), "no=10");
    }
    
}

/*
클래스에 대해서 테스트를 해야함.
지금 이것은 웸페이지 구조를 따라하는것


이거 알면 crawling도 잘 할 수 있음. 

RegularExpression



*/