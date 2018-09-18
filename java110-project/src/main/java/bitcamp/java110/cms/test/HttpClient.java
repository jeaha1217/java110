package bitcamp.java110.cms.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
    public static void main(String[] args) throws Exception{
        try (
                Socket socket = new Socket("www.zdnet.co.kr", 80);

                PrintStream out = new PrintStream(socket.getOutputStream());
                Scanner in = new Scanner(socket.getInputStream());
                ){
            //  HTTP요청.
            //  1) request-line
            out.println("GET / HTTP/1.1");

            //  2) 요청 헤더 (request-header | general-header | )
            out.println("Host: www.zdnet.co.kr");
            out.println("Connection: keep-alive");
            out.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
            out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            out.println("Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7");

            //  3) Header 끝을 표시.
            out.println("");

            //  4) 서버에 보낼 데이터[message-body]
            // =>없으면 생랼.
            while(true) {
                String str = in.nextLine();
                System.out.println(str);
            }
        }
    }
}
/*
https://tools.ietf.org/html/rfc2616#section-5
    general-header
    request-header
    entity-header
        entity : 사과주스.
        header : 사과쥬스 영양정보(부가정보[meta-data]).


타자기.
CR : Carrage Return
LF : Line Feed
유닉스와 리눅스의 \n

전산 기초를 알아야 네트워킹을 알 수 있다고 ㅠ 하....
할게 시발 존나 많아요....

응답 프로토콜의 Status-Code
    - 1xx: Informational - Request received, continuing process.
    - 2xx: Success - The action was successfully received, understood, and accepted.
    - 3xx: Redirection - Further action must be taken in order to complete the request.
    - 4xx: Client Error - The request contains bad syntax or cannot be fulfilled.
    - 5xx: Server Error - The server failed to fulfill an apparently valid request.
    이런거 존나 잘 알아야 좋은데서 일해...
    301, 400, 404, 500

http를 화면에 출력하는것을 랜더링이라고 함.


*/