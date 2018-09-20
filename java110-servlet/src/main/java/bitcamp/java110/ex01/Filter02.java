package bitcamp.java110.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
//@WebFilter("/ex01/*")
public class Filter02 implements Filter{

    public Filter02() {
        System.out.println("Filter02() 호출.");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02.init() 호출.");
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain)
                    throws IOException, ServletException {

        System.out.println("\tFilter02.doFilter() -- before");
        chain.doFilter(request, response);
         System.out.println("\tFilter02.do2Filter()  --\t after");
    }

    @Override
    public void destroy() {
        System.out.println("Filter02.Destroy() 호출.");
        Filter.super.destroy();
    }
}
