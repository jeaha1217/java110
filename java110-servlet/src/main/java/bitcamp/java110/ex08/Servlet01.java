/*  리프레쉬
    => 리프레쉬? 서버가 보낸 콘텐트를 클라이언트가 출력한 후에
         지정한 URL로 자동으로 요청하게 만드는 기술.
 */

package bitcamp.java110.ex08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08/servlet01")
public class Servlet01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex08/servlet01
        방법1)
            응답 헤더에 리프레시 명령을 추가하기.
            다음은 응답 내용을 출력한 후, 2초 후에 http://daum.net을 요청하라는 명령.
        res.setHeader("Refresh", "2;url=http://daum.net");    //  2초후 url링크로 가라.
        */
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        /*  방법2)
            => HTML의 <meta> tag에 refresh명령을 설정할 수 있다.
         */
        out.println("<meta http-equiv='Refresh' content=5;url=http://daum.net>");  //
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - ex08 - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>servlet01 실행</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}

/*

 */