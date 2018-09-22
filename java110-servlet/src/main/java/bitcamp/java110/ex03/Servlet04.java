package bitcamp.java110.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
  클라이언트로 출력하기 - Binary 출력.

  Binary : 일반 text 에디터로 직접 편집이 불가능함.
           exe, hwp, gif, avi, xls, ppt, jpeg, wav, png, ... 
  Text   : 
           txt, properties, gradle, xml, html, cs, js, csv ...
 */
@WebServlet("/ex03/servlet04")
public class Servlet04 extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /*  webapp 밑에 있는 파일은 직접 가져갈 수 있음.
            WEB-INF 직접 가져지 못하게 막아둔 곳.
              - Servlet을 통해서 간접적으로 보여줄 수 있음.
        */  

        //  웹 애플리케이션 정보를 다루는 객체를 얻는다.
        //        String path = req.getRealPath("/WEB-INF");    //  
        ServletContext ctx = this.getServletContext();

        // ServletContext 객체를 통해 현재 웹 어플리캐이션의 실제 경로를 알아낸다.
        String filePath = ctx.getRealPath("WEB-INF/pic2.jpg");
        res.setContentType("image/jpeg");

        try(    //  try with resource 문법.
                BufferedInputStream in =
                new BufferedInputStream(new FileInputStream(filePath));

                BufferedOutputStream out =
                        new BufferedOutputStream(res.getOutputStream());
                //  binary 출력.
                ){
            int b;
            while((b = in.read()) != -1) {
                out.write(b);
            }
            out.flush();
        }
    }
}