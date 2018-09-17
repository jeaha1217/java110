package bitcamp.java110.cms;

public class App {

    public static void main(String[] args) throws Exception {
        Thread main = Thread.currentThread();
//        System.out.println(main.getName());
        
        ThreadGroup mainGroup = main.getThreadGroup();
//        System.out.println(mainGroup.getName());
        
        ThreadGroup systemGroup = mainGroup.getParent();
        System.out.println(systemGroup.getName());
        
//        ThreadGroup p2 = p1.getParent();
//        System.out.println(p2.getName());
        
        
        System.out.println("[Thread]");
        Thread[] threads = new Thread[20];
        int count = systemGroup.enumerate(threads, false);
        for(int i = 0; i <count; i++ ) {
            System.out.println(threads[i].getName());
        }   System.out.println();
        
        System.out.println("[ThreadGroup]");
        ThreadGroup[] tgs = new ThreadGroup[20];
        count = systemGroup.enumerate(tgs, false);
        for(int i = 0; i <count; i++ ) {
            System.out.println(tgs[i].getName());
        }   System.out.println();
        
        System.out.println("[mainGroupThreads]");
        count = mainGroup.enumerate(threads, false);
        for(int i = 0; i <count; i++ ) {
            System.out.println(threads[i].getName());
        }   System.out.println();
        
        System.out.println("[Inno~Group'sThreads]");
        count = tgs[1].enumerate(threads, false);
        for(int i = 0; i <count; i++ ) {
            System.out.println(threads[i].getName());
        }   System.out.println();
    }
}
/*
    병행처리와 병렬 처리
    CPU작동 방식?
    
    Connection-oriented (TCP, 전화)
        Stateful  : FTP, Telnet, 상담.
        Stateless : http, 114
        
    Connection-less (UDT, 편지)
        ping test.
        Streaming.
        
    
    
    


*/