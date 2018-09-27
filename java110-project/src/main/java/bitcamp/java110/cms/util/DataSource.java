package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataSource {
    Connection con;
    
    public Connection getConnection() throws Exception {
        if(con == null) {
            
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
        }
        return this.con;
    }   //  에!?
}
/*
    connection을 자꾸하면 낭비가 심해서 커넥션을 미리 준비함.
    finally에서 닫아주지 않아야 하고,
    임시 저장공간에 저장해서 쿼리문을 통해 데이터를 보내는 방식임으로
    중간에 쓰던 문장에 에러가 나면 지워야 함.
    therefore : delete나 insert에서는 rollback을 해줘야함.
    
    취업 최소 프로그래밍 요구조건.
    "왜 하는지 의미를 알고" 어디에 무엇을 어떻게 복붙 해야 하는지 아는 것.
*/