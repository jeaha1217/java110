package bitcamp.java110.cms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(
            HttpServletRequest request, 
            HttpServletResponse response)
                    throws ServletException, IOException {
        
//        String webAppRoot = request.getContextPath();
        //  /java110-project
        
        PrintWriter out = response.getWriter();
        
        out.println("<header>");
        out.println("   <h1>비트캠프</h1>");
            
        out.println("   <ul>");
/*
        out.printf("        <li><a href='%s/student/list'>학생관리</a></li>\n",
                webAppRoot);
        out.printf("        <li><a href='%s/teacher/list'>강사관리</a></li>\n",
                webAppRoot);
        out.printf("        <li><a href='%s/manager/list'>매니저관리</a></li>\n",
                webAppRoot);
        //  servlet이 아닌 웹 브라우저가 보는 경로로 생각을 해야함.
*/
        
        out.println("        <li><a href='/student/list'>학생관리</a></li>\n");
        out.println("        <li><a href='/teacher/list'>강사관리</a></li>\n");
        out.println("        <li><a href='/manager/list'>매니저관리</a></li>\n");
        //  servlet이 아닌 웹 브라우저가 보는 경로로 생각을 해야함.
        out.println("   </ul>");
        out.println("</header>");
    }

}
