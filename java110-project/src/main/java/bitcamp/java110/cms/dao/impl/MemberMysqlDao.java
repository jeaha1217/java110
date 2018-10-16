package bitcamp.java110.cms.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.java110.cms.dao.MemberDao;
import bitcamp.java110.cms.domain.Member;

public class MemberMysqlDao implements MemberDao {
    // 항상 코드 중복이 생기면 유지 보수가 힘들다.
    // 하나의 DAO는 하나의 table에 대한 ownership을 갖고 있어야 한다.   
    //  작 table은 상관 없음.
    SqlSessionFactory sqlSessionFactory;
    
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    @Override
    public int insert(Member member){
        try(SqlSession session = sqlSessionFactory.openSession(true)){  //  AutoCommit
            return session.insert(
                    "bitcamp.java110.cms.dao.MemberDao.insert", member);
        }
    }
    
    @Override
    public int delete(int no){
        try(SqlSession session = sqlSessionFactory.openSession(true)){
            return session.delete(
                    "bitcamp.java110.cms.dao.MemberDao.delete", no);
        }
    }
}