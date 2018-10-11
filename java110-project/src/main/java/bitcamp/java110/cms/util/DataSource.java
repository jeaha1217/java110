package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
/*  
지금까지 모습.
Servlet 객체는 한개만 만들어 진다.
쓰레드는 자신의 스택 메모리 영역을 각자 하나씩 갖고있다.

두개의 쓰레드가 한 객체에게
service 메소드를 호출해서 request response를 주고 받게된다면?
    한쪽 쓰레드에서 service 객체의 instance 변수를 바꾸려고 한다면?
        공유자원이기 때문에 큰일남. -> local변수를 써야함.
    쓰레스 => 물류센터에서 바쁘게 움직이는 녀석이랄까? 옛날에 봤던 만화를 되생각해봐.
        일 없는 쓰레드가 쉬는곳 쓰레드 풀.
    근데 두 쓰레드가 한 커넥션으로 DBMS에게 정보를 보낼때?
        멀티스레드가 커넥션을 공유하면 다른 스레드 작업과 묶임
        한놈이 rollback하거나 commit이 겹쳐버리면 좓되는것임ㅇㅇ
            (커넥션 공유의 치명적인 단점)
        그래서 서버사이드 멀티쓰레드 서버에서는 커넥션을 하나만 쓰는것이 아님 

해결책.
쓰레드가 커넥션은 가지고 다니고, 자기 트렌젝션을 쓴다.

트랜젝션 관리.
Servlet -> Service
            insert -> DAO
            update -> DAO
               |   -> DAO
               V
            Service의 역할
            업무 로직, 트랜젝션 관리

            Service를 사용하여 TransactionManager -> DataSource
            commit과 rollback
*/

public class DataSource {
    String url;
    String username;
    String password;

    ArrayList<Connection> connections = new ArrayList<>();
    //  쓰레드를 보관하는 객체
    ThreadLocal<Connection> local = new ThreadLocal<>();

    public DataSource(
            String driver, 
            String url, 
            String username, 
            String password) throws Exception {

        Class.forName(driver);
        this.url = url;
        this.username = username;
        this.password = password;

    }

    //  DAO가 쓸 녀석
    public Connection getConnection() throws Exception {
        Connection con = local.get();
        if(local.get() != null) {
            return con;
        } else {
            return getConnection(false);
        }
    }

    //  transaction manager에게 빌려줌
    public Connection getConnection(boolean useTransaction) throws Exception {
        Connection con = null;
        while (connections.size() > 0) {
            con = connections.remove(0);
            // 유효하고 사용가능하다면 (3초이내에 응답이 오면 유효한것)
            if(!con.isClosed() && con.isValid(3)) {
                System.out.println("기존 connection 사용!");
                break;
            }
            con = null; //  
        }

        if(con == null) {
            System.out.println("새 connection 생성!");
            return DriverManager.getConnection(url, username, password);
        }

        if(useTransaction) {
            con.setAutoCommit(false);
            local.set(con);
        }   else {
            con.setAutoCommit(true);
        }

        return con;
    }

    //  DAO에게서 반납받음
    public void returnConnection(Connection con) {
        returnConnection(con, false);
    }

    //  TransactionManager에게서 반납받음
    public void returnConnection(Connection con, boolean useTransaction) {
        if(useTransaction) {
            local.remove();
        }
        if(local.get() == null) {
            //  트랜잭션으로 사용하는 커넥션이 아닐때만 커넥션 풀에 반납 받음.
            connections.add(con);
        }
    }
}
/*
    DAO가 Transaction이 false인 con과 true인 con,
    TransactionManager가 Transaction이 false인 con과 true인 con
    을 반납하는 process가 다름 어렵다 시바...
    
    비지니스 로직은 DB에서 하면 절대 안됨. 프로그램  코드에서 끝내야함.
*/
