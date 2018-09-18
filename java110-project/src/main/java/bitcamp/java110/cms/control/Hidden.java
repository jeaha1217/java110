package bitcamp.java110.cms.control;

import java.io.PrintStream;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hidden{
    @RequestMapping("hidden")
    public void hidden(PrintStream out) {
        out.println("\nAh?");
        out.println("Fuck You");
        out.println("Fuck You to Meet You");
    }
}