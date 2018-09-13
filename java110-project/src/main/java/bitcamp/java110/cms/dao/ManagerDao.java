package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {
    public int insert(Manager manager)
            throws MandatoryValueDaoException, DuplicationDaoException;
    List<Manager> findAll();
    Manager findByEmail(String email);
    default Manager findByNo(int no) {return null;}
    default int delete(String email) {return 0;}
    default int deleteByNo(int no) {return 0;}
    //  기존 구현체에는 영향을 안미침.
}
/*  Throwable
        Exception   :   개발자가 처리해야할 문제.
        Error       :   시스템(JVM) 에러. 받아서 처리할 생각 절대 ㄴ
    두가지로 받을수 있음.
    
    Exception을 상속 받은 daoException을 사용함.
    
*/