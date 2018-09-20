package bitcamp.java110.cms.control;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hidden{
    @RequestMapping("hidden")
    public void hidden(ServletRequest request, ServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        out.println("\nAh?");
        out.println("Fuck You");
        out.println("Fuck You to Meet You");
    }
}