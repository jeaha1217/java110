package bitcamp.java110.cms.server;

import java.io.PrintWriter;

public class ServletResponse {
    PrintWriter out;

    public ServletResponse(PrintWriter out) {
        this.out = out;
    }
    
    public PrintWriter getWriter() {
        return this.out;
    }
    

}
