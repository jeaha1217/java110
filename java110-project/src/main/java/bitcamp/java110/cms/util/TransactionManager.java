package bitcamp.java110.cms.util;

import java.sql.Connection;

public class TransactionManager {
    
    static DataSource dataSource;

    public static void setDataSource(DataSource dataSource) {
        TransactionManager.dataSource = dataSource;     //?
    }
    
    public static void startTransaction() throws Exception{
        //  트렌젝션을 시작하면 미리 Thread가 사용할 커넥션을 준비시킨다.
        dataSource.getConnection(true);
    }
    
    public static void commit() throws Exception {
        //  DataSourde는 이전에 쓰래드에 보관했던 커넥션 객체를 리턴한다.
        Connection con = dataSource.getConnection();
        con.commit();
        
        //  커넥션 객체를 다 사용한 후, 스레드에 저장된 것을 제거하고 커넥션풀에 반납한다.
        dataSource.returnConnection(con, true);
    }
    
    public static void rollback() throws Exception {
        //  DataSourde는 이전에 쓰래드에 보관했던 커넥션 객체를 리턴한다.
        Connection con = dataSource.getConnection();
        con.rollback();
        dataSource.returnConnection(con, true);
    }
}
