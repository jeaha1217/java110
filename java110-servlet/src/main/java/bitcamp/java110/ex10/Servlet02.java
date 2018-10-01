/*  쿠키(cookies) - 웹브라우저가 보낸 쿠키 꺼내기.
    => 
 */

package bitcamp.java110.ex10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10/servlet02")
public class Servlet02 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest req,
            HttpServletResponse res)
                    throws ServletException, IOException {
        /*  http://localhost:8888/ex10/servlet02
            1) http 요청 프로토콜에서 쿠키 목록 가져오기.
                쿠키가 없다면 null을 리턴함.
         */
        Cookie[] cookies = req.getCookies();
        
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> - ex10 - </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>쿠키 받기.</h1>");

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                out.printf("<p>%s=%s</p>\n",
                        cookie.getName(),
                        cookie.getValue());
            }
        }
/*
    HTTP 요청 프로토콜의 예)
RequestHeader
GET /ex10/servlet02 HTTP/1.1
Host: localhost:8888
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,/;q=0.8
Accept-Encoding: gzip, deflate, br
Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
Cookie: name=Looser; age=12; working=true            <== 서버에 보내는 쿠키
 
언어에 상관없이 공통된 웹 기술임 
*/
        out.println("</body>");
        out.println("</html>");
    }
}

/*  

*/