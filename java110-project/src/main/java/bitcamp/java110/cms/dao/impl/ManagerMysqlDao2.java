package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

//@Component
public class ManagerMysqlDao2 implements ManagerDao {
    
    public List<Manager> findAll() {
        
        ArrayList<Manager> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
            
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno");
            
            while (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
            try {con.close();} catch (Exception e) {}
        }
        return list;
    }
    
    Connection con;{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
    //  InstanceField?
    
    public List<Manager> findAll2() {
        
        ArrayList<Manager> list = new ArrayList<>();
        
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.createStatement();
            
            rs = stmt.executeQuery(
                    "select" + 
                    " m.mno," +
                    " m.name," + 
                    " m.email," + 
                    " mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on mr.mrno = m.mno");
            
            while (rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            try {rs.close();} catch (Exception e) {}
            try {stmt.close();} catch (Exception e) {}
        }
        return list;
}
    
    
    public static void main(String[] args) {
        ManagerMysqlDao2 dao = new ManagerMysqlDao2();
        
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            dao.findAll();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
        
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            dao.findAll2();
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        //  커넥션 공유 해야 하는 이유 예제.
        
    }


    @Override
    public int insert(Manager manager) {
        // TODO Auto-generated method stub
        return 0;
    }


    @Override
    public Manager findByEmail(String email) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Manager findByNo(int no) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public int delete(int no) {
        // TODO Auto-generated method stub
        return 0;
    }
}









