//  세션의 원리 - 세션 ID와 cookie
package bitcamp.java110.ex11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ex11/servlet21")
public class Servlet21 extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //  http://localhost:8888/ex11/servlet21
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        
        /*  session얻기
            요청 프로토콜의 쿠키 정보에서 세션 id를 검사한다.
            있다면,
                => 웹 브라우져가 제시한 세션 아이디에 해당하는 세션 객체를 찾는다.
                => 있다면, 유효 하다면,
                   그 세션 객체를 리턴 한다.
                   웹 브라우져가 세션 아이디를 갖고 있기 때문에
                   응답할 때 프로토콜에 쿠키를 다시 세션 아이디를 보내지 않는다.
                => 있으나 timeout되어 무효하다면,
                   없을 때와 똑같이 처리한다.
                => 서버 재시작등으로 서버측에 정보가 없다면,
                   없을때와 똑같이 처리한다.
            없다면,
                => 새로 httpSeeion 객체를 생성하려 리턴한다.
                => 응답할 때 응답 프로토콜의 쿠키 정보로
                   새로 생성한 세션객체의 세션 아이디를 보낸다.
                => 웹 브라우저는 서버로부터 받은 쿠케 데이터인 세션 ID를
                   서버에 요청할 때 마다 보낼 것이다.
                               
            세션ID를 응답 프로토콜로 보내는 예)
            Set-Cookie: JSESSIONID=74B95B5BE12FEA68828E10F5294B39AA; Path=/; HttpOnly
            => 톰캣 서버에서는 JSESSION 이라는 쿠키 이름으로 세션 아이디를 보낸다.
            => WAS마다 세션ID의 쿠키 이름이 다를 수 있다.
        */
        HttpSession session = request.getSession();
        
        //  세션에 데이터 보관하기.
        session.setAttribute("name", "JeJe");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title> ! SESSION ! </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Session 만들기</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
