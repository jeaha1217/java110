package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.domain.Member;
import bitcamp.java110.cms.util.DataSource;

public class MemberMysqlDao implements MemberDao {
    // 항상 코드 중복이 생기면 유지 보수가 힘들다.
    // 하나의 DAO는 하나의 table에 대한 ownership을 갖고 있어야 한다.   
    //  작 table은 상관 없음.
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int insert(Member member) throws DaoException {
        Statement stmt = null;
        Connection con = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "insert into p1_memb(name,email,pwd,tel,cdt)"
                    + " values('" + member.getName()
                    + "','" + member.getEmail()
                    + "',password('" + member.getPassword()
                    + "'),'" + member.getTel()
                    + "',now())";
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int no = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            member.setNo(no);
            
            return 1;
        } catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
                throw new DaoException(e);
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
    
    @Override
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = "delete from p1_memb where mno=" + no;
            return stmt.executeUpdate(sql);
            
        } catch (Exception e) {
            throw new DaoException(e);
            
        } finally {
            try {stmt.close();} catch (Exception e) {}
        }
    }
}